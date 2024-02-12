package org.example.iotdevicerestapi.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.iotdevicerestapi.dto.request.SimCardRequestDto;
import org.example.iotdevicerestapi.dto.response.SimCardResponseDto;
import org.example.iotdevicerestapi.entity.IOTDevice;
import org.example.iotdevicerestapi.entity.SimCard;
import org.example.iotdevicerestapi.exceptions.NotFoundCustomException;
import org.example.iotdevicerestapi.mapper.SimCardRequestDtoToSimCardMapper;
import org.example.iotdevicerestapi.mapper.SimCardToSimCardResponseDtoMapper;
import org.example.iotdevicerestapi.repository.IOTDeviceRepository;
import org.example.iotdevicerestapi.repository.SimCardRepository;
import org.example.iotdevicerestapi.service.SimCardService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SimCardServiceImpl implements SimCardService {
    private final SimCardRepository simCardRepository;
    private final SimCardToSimCardResponseDtoMapper toSimCardResponseDtoMapper;
    private final SimCardRequestDtoToSimCardMapper toSimCardMapper;
    private final IOTDeviceRepository iotDeviceRepository;
    @Override
    public void saveSimCard(SimCardRequestDto requestDto, Long deviceId) {
        SimCard simCard=toSimCardMapper.apply(requestDto,deviceId);
        simCard=simCardRepository.save(simCard);
        IOTDevice iotDevice = iotDeviceRepository.findById(deviceId).orElseThrow(
                ()-> new NotFoundCustomException("Device with id : "+deviceId+" not found!")
        );
        iotDevice.setSimCard(simCard);
        iotDeviceRepository.save(iotDevice);
    }

    @Override
    public SimCardResponseDto findSimCardById(Long simCardId) {
        SimCard simCard=simCardRepository.findById(simCardId).orElseThrow(
                ()-> new NotFoundCustomException("Sim card with id : "+simCardId+" not found!")
        );
        return toSimCardResponseDtoMapper.apply(simCard);
    }

    @Override
    public List<SimCardResponseDto> findAll() {
        List<SimCard>simCards=simCardRepository.findAll();
        return simCards.stream().map(toSimCardResponseDtoMapper).toList();
    }
}
