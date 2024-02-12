package org.example.iotdevicerestapi.controller;

import lombok.RequiredArgsConstructor;
import org.example.iotdevicerestapi.dto.request.SimCardRequestDto;
import org.example.iotdevicerestapi.dto.response.SimCardResponseDto;
import org.example.iotdevicerestapi.service.SimCardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sim-cards")
@RequiredArgsConstructor
public class SimCardController {
    private final SimCardService simCardService;

    @PostMapping("/{deviceId}")
    public ResponseEntity<?> saveSimCard(@RequestBody SimCardRequestDto requestDto, @PathVariable Long deviceId) {
        simCardService.saveSimCard(requestDto, deviceId);
        return new ResponseEntity<>("Data saved!",HttpStatus.CREATED);
    }

    @GetMapping("/{simCardId}")
    public ResponseEntity<?> findSimCardById(@PathVariable Long simCardId) {
        SimCardResponseDto simCard = simCardService.findSimCardById(simCardId);
        return new ResponseEntity<>(simCard, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        List<SimCardResponseDto> simCards = simCardService.findAll();
        return new ResponseEntity<>(simCards, HttpStatus.OK);
    }
}
