package com.innovate.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.innovate.entity.NotifyEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Component
@Slf4j
public class NotifyEventProducer {

    KafkaTemplate<String, String> kafkaTemplate;
    ObjectMapper objectMapper;

    @Value("${spring.kafka.topic}")
    public String topic;

    public NotifyEventProducer(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public CompletableFuture<SendResult<String, String>> sendLibraryEvent(String uniqueId, NotifyEvent notifyEvent) throws JsonProcessingException {

        String key = uniqueId;
        String value = objectMapper.writeValueAsString(notifyEvent);

        var completableFuture = kafkaTemplate.sendDefault(key, value);
       return completableFuture
                .whenComplete((sendResult, throwable) -> {
                    if (throwable != null) {
                        handleFailure(key, value, throwable);
                    } else {
                        handleSuccess(key, value, sendResult);

                    }
                });
    }

    public CompletableFuture<SendResult<String, String>> sendLibraryEvent_Approach2(String uniqueId, NotifyEvent notifyEvent) throws JsonProcessingException {

        String key = uniqueId;
        String value = objectMapper.writeValueAsString(notifyEvent);

        ProducerRecord<String, String> producerRecord = buildProducerRecord(key, value, topic);
        var completableFuture = kafkaTemplate.send(producerRecord);
        return completableFuture
                .whenComplete((sendResult, throwable) -> {
                    if (throwable != null) {
                        handleFailure(key, value, throwable);
                    } else {
                        handleSuccess(key, value, sendResult);

                    }
                });
    }

    private ProducerRecord<String, String> buildProducerRecord(String key, String value, String topic) {


        List<Header> recordHeaders = List.of(new RecordHeader("event-source", "scanner".getBytes()));

        return new ProducerRecord<>(topic, null, key, value, recordHeaders);
    }


//    public SendResult<Integer, String> sendLibraryEventSynchronous(LibraryEvent libraryEvent) throws JsonProcessingException, ExecutionException, InterruptedException, TimeoutException {
//
//        Integer key = libraryEvent.libraryEventId();
//        String value = objectMapper.writeValueAsString(libraryEvent);
//        SendResult<Integer, String> sendResult = null;
//        try {
//            sendResult = kafkaTemplate.sendDefault(key, value).get(1, TimeUnit.SECONDS);
//        } catch (ExecutionException | InterruptedException e) {
//            log.error("ExecutionException/InterruptedException Sending the Message and the exception is {}", e.getMessage());
//            throw e;
//        } catch (Exception e) {
//            log.error("Exception Sending the Message and the exception is {}", e.getMessage());
//            throw e;
//        }
//
//        return sendResult;
//
//    }

    private void handleFailure(String key, String value, Throwable ex) {
        log.error("Error Sending the Message and the exception is {}", ex.getMessage());
//        try {
//            throw ex;
//        } catch (Throwable throwable) {
//            log.error("Error in OnFailure: {}", throwable.getMessage());
//        }


    }

    private void handleSuccess(String key, String value, SendResult<String, String> result) {
        log.info("Message Sent SuccessFully for the key : {} and the value is {} , partition is {}", key, value, result.getRecordMetadata().partition());
    }
}
