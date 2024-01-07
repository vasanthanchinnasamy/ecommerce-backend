package com.innovate.controller;

import java.util.UUID;

import com.innovate.dto.ProductAttributeDto;
import com.innovate.model.ProductAttribute;
import com.innovate.service.ProductAttributeService;
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
@RequestMapping("/productAttribute")
@CrossOrigin
public class ProductAttributeController {

    @Autowired
    private ProductAttributeService productAttributeService;

    @GetMapping("/getAll")
    public ResponseEntity<Iterable<ProductAttribute>> getAll() {
        return new ResponseEntity<>(productAttributeService.getProductAttributes(), HttpStatus.OK);
    }

//    @GetMapping("/getByCategory/{category}")
//    public ResponseEntity<Iterable<ProductAttribute>> getByCategory(@PathVariable String category) {
//        return new ResponseEntity<>(productAttributeService.getProductAttributesByCategory(category), HttpStatus.OK);
//    }

    @PostMapping("/add")
    public ResponseEntity<ProductAttribute> add(@RequestBody ProductAttributeDto productAttributeDto) {
        return new ResponseEntity<>(productAttributeService.addProductAttribute(productAttributeDto), HttpStatus.OK);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<Void> remove(@RequestParam UUID attributeId) {
        productAttributeService.removeProductAttribute(attributeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ProductAttribute> update(@RequestBody ProductAttributeDto productAttributeDto) {
        return new ResponseEntity<>(productAttributeService.updateProductAttribute(productAttributeDto), HttpStatus.OK);
    }
}

