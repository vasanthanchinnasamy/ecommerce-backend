package com.innovate.controller;

import java.util.UUID;

import com.innovate.dto.ProductAttributeValueDto;
import com.innovate.model.ProductAttributeValue;
import com.innovate.service.ProductAttributeValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/productAttributeValue")
@CrossOrigin
public class ProductAttributeValueController {

    @Autowired
    private ProductAttributeValueService productAttributeValueService;

    @GetMapping("/getAll")
    public ResponseEntity<Iterable<ProductAttributeValue>> getAll() {
        return new ResponseEntity<>(productAttributeValueService.getProductAttributeValues(), HttpStatus.OK);
    }

    @GetMapping("/getByAttribute/{attributeId}")
    public ResponseEntity<Iterable<ProductAttributeValue>> getByAttribute(@PathVariable UUID attributeId) {
        return new ResponseEntity<>(productAttributeValueService.getProductAttributeValuesByAttribute(attributeId), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ProductAttributeValue> add(@RequestBody ProductAttributeValueDto productAttributeValueDto) {
        return new ResponseEntity<>(productAttributeValueService.addProductAttributeValue(productAttributeValueDto), HttpStatus.OK);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<Void> remove(@RequestParam UUID attributeValueId) {
        productAttributeValueService.removeProductAttributeValue(attributeValueId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ProductAttributeValue> update(@RequestBody ProductAttributeValueDto productAttributeValueDto) {
        return new ResponseEntity<>(productAttributeValueService.updateProductAttributeValue(productAttributeValueDto), HttpStatus.OK);
    }
}

