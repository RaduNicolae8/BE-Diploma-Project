package com.diploma.project.controller;

import com.diploma.project.service.GenericService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class GenericController<T,DTO> {
    private final GenericService<T,DTO> genericService;

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
//    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<List<DTO>> findAll() {
        List<DTO> allAdmissions = genericService.findAll();
        return ResponseEntity.ok(allAdmissions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTO> findById(@PathVariable Long id) {
        DTO dto = genericService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<DTO> save(@RequestBody DTO dto) {
        DTO savedDTO = genericService.save(dto);
        return ResponseEntity.ok(savedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        genericService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAll() {
        genericService.deleteAll();
        return ResponseEntity.ok().build();
    }
}
