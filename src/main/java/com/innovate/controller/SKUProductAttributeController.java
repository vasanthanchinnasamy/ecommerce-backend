package com.innovate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.innovate.model.SKUProductAttribute;
import com.innovate.service.SKUProductAttributeService;

@RestController
@RequestMapping("/skuProductAttribute")
@CrossOrigin
public class SKUProductAttributeController {

    @Autowired
    private SKUProductAttributeService skuProductAttributeService;

    @GetMapping("/getAll")
    public ResponseEntity<Iterable<SKUProductAttribute>> getAll() {
        return new ResponseEntity<>(skuProductAttributeService.getAllSKUProductAttributes(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<SKUProductAttribute> add(@RequestBody SKUProductAttribute skuProductAttribute) {
        return new ResponseEntity<>(skuProductAttributeService.addSKUProductAttribute(skuProductAttribute), HttpStatus.OK);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<Void> remove(@RequestBody SKUProductAttribute skuProductAttribute) {
        skuProductAttributeService.removeSKUProductAttribute(skuProductAttribute);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
