package org.example.iotdevicerestapi.mapper;

import org.example.iotdevicerestapi.dto.response.SimCardResponseDto;
import org.example.iotdevicerestapi.entity.SimCard;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class SimCardToSimCardResponseDtoMapper implements Function<SimCard, SimCardResponseDto> {

    @Override
    public SimCardResponseDto apply(SimCard simCard) {
        return SimCardResponseDto.builder()
                .simId(simCard.getSimId())
                .simStatus(simCard.getSimStatus())
                .simCountry(simCard.getSimCountry())
                .operatorCode(simCard.getOperatorCode())
                .build();
    }

}
