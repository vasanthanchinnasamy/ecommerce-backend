package com.innovate.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.innovate.dto.SKUDto;
import com.innovate.model.SKU;
import com.innovate.service.SKUService;

@RestController
@RequestMapping("/sku")
@CrossOrigin
public class SKUController {

    @Autowired
    private SKUService skuService;

    @GetMapping("/getAll")
    public ResponseEntity<Iterable<SKU>> getAll() {
        return new ResponseEntity<>(skuService.getAllSKUs(), HttpStatus.OK);
    }

    @GetMapping("/getByProduct/{productId}")
    public ResponseEntity<Iterable<SKU>> getByProduct(@PathVariable UUID productId) {
        return new ResponseEntity<>(skuService.getSKUsByProduct(productId), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<SKU> add(@RequestBody SKUDto skuDto) {
        return new ResponseEntity<>(skuService.addSKU(skuDto), HttpStatus.OK);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<Void> remove(@RequestParam UUID skuId) {
        skuService.removeSKU(skuId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<SKU> update(@RequestBody SKUDto skuDto) {
        return new ResponseEntity<>(skuService.updateSKU(skuDto), HttpStatus.OK);
    }
}
