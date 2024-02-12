package org.example.iotdevicerestapi.mapper;

import lombok.RequiredArgsConstructor;
import org.example.iotdevicerestapi.dto.request.SimCardRequestDto;
import org.example.iotdevicerestapi.entity.SimCard;
import org.example.iotdevicerestapi.exceptions.NotFoundCustomException;
import org.example.iotdevicerestapi.repository.IOTDeviceRepository;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class SimCardRequestDtoToSimCardMapper implements Function<SimCardRequestDto, SimCard> {
    private final IOTDeviceRepository iotDeviceRepository;
    @Override
    public SimCard apply(SimCardRequestDto simCardRequestDto) {
        return apply(simCardRequestDto,null);
    }
    public SimCard apply(SimCardRequestDto simCardRequestDto,Long deviceId) {
        iotDeviceRepository.findById(deviceId).orElseThrow(
                ()-> new NotFoundCustomException("Device with id : "+deviceId+" not found!")
        );
        return SimCard.builder()
                .simCountry(simCardRequestDto.simCountry())
                .simStatus(simCardRequestDto.simStatus())
                .operatorCode(simCardRequestDto.operatorCode())
                .build();
    }
}
