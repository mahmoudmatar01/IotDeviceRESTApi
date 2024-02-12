package org.example.iotdevicerestapi.mapper;
import org.example.iotdevicerestapi.dto.request.IoTDeviceRequestDto;
import org.example.iotdevicerestapi.entity.IOTDevice;
import org.example.iotdevicerestapi.enums.DeviceStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Component
public class IoTDeviceRequestDtoToIotDeviceMapper implements Function<IoTDeviceRequestDto, IOTDevice> {
    @Override
    public IOTDevice apply(IoTDeviceRequestDto ioTDeviceRequestDto) {
        return IOTDevice.builder()
                .deviceStatus(ioTDeviceRequestDto.deviceStatus())
                .deviceTem(ioTDeviceRequestDto.deviceTem())
                .build();
    }
}
