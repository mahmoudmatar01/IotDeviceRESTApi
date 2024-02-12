package org.example.iotdevicerestapi.dto.response;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import org.example.iotdevicerestapi.enums.DeviceStatus;

@Builder
@JsonInclude
public record SimCardResponseDto(
        Long simId,
        String operatorCode,
        String simCountry,
        DeviceStatus simStatus
) {
}
