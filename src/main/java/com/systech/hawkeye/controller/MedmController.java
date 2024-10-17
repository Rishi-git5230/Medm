package com.systech.hawkeye.controller;

import com.systech.hawkeye.model.MedmModel;
import com.systech.hawkeye.repository.MedmRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medm")
public class MedmController {
    private final MedmRepository medmRepository;

    public MedmController(MedmRepository medmRepository) {
        this.medmRepository = medmRepository;
    }

    @GetMapping
    public List<MedmModel> getAllMedm() {
        return medmRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<MedmModel> createMedm(@RequestBody MedmModel medm) {
        MedmModel savedMedm = medmRepository.save(medm);
        return ResponseEntity.ok(savedMedm);
    }
}
