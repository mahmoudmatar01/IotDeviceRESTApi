package org.example.iotdevicerestapi.dto.response;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import org.example.iotdevicerestapi.enums.DeviceStatus;

@Builder
@JsonInclude
public record IotDeviceResponseDto(
        Long deviceId,
        DeviceStatus deviceStatus,
        double deviceTem,
        Long simCardId
) {
}
