package org.example.iotdevicerestapi.service;

import org.example.iotdevicerestapi.dto.request.SimCardRequestDto;
import org.example.iotdevicerestapi.dto.response.SimCardResponseDto;

import java.util.List;

public interface SimCardService {
    void saveSimCard(SimCardRequestDto requestDto,Long deviceId);
    SimCardResponseDto findSimCardById(Long simCardId);
    List<SimCardResponseDto> findAll();
}
