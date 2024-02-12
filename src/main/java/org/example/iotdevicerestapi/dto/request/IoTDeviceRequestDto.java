package org.example.iotdevicerestapi.dto.request;

import lombok.Builder;
import org.example.iotdevicerestapi.enums.DeviceStatus;

@Builder
public record IoTDeviceRequestDto(
        DeviceStatus deviceStatus,
        double deviceTem
) {
}
