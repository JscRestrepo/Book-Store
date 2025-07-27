package com.books.system.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DevCacheController {

    @DeleteMapping("/clear-all-caches")
    @CacheEvict(value = "books", allEntries = true)
    public ResponseEntity<String> clearCaches() {
        return ResponseEntity.ok("✔️ Caché de libros limpiado correctamente.");
    }
}
