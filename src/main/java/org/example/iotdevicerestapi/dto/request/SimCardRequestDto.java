package org.example.iotdevicerestapi.dto.request;

import lombok.Builder;
import org.example.iotdevicerestapi.enums.DeviceStatus;

@Builder
public record SimCardRequestDto(
        String operatorCode,
        String simCountry,
        DeviceStatus simStatus

) {
}
