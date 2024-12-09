package com.innovate.entity;
public record NotifyEvent(
        String message,
        String recipient,
        NotifyChannel notifyChannel
        ) {
}
