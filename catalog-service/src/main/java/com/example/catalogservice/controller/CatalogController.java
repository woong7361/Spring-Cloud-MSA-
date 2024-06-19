package com.example.catalogservice.controller;

import com.example.catalogservice.jpa.CatalogEntity;
import com.example.catalogservice.service.CatalogService;
import com.example.catalogservice.vo.ResponseCatalog;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/catalog-service")
@RequiredArgsConstructor
public class CatalogController {

    private final Environment emv;
    private final  CatalogService catalogService;

    @GetMapping("/catalogs")
    public ResponseEntity<ArrayList<ResponseCatalog>> getCatalogs() {
        Iterable<CatalogEntity> catalogs = catalogService.getAllCatalogs();
        ArrayList<ResponseCatalog> result = new ArrayList<>();

        catalogs.forEach(c -> {
            result.add(new ModelMapper().map(c, ResponseCatalog.class));
        });

        return ResponseEntity.ok(result);
    }
}
