package org.example.iotdevicerestapi.mapper;

import org.example.iotdevicerestapi.dto.response.IotDeviceResponseDto;
import org.example.iotdevicerestapi.entity.IOTDevice;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class IoTDeviceToIotDeviceResponseDtoMapper implements Function<IOTDevice, IotDeviceResponseDto> {
    @Override
    public IotDeviceResponseDto apply(IOTDevice iotDevice) {
        return IotDeviceResponseDto.builder()
                .deviceId(iotDevice.getDeviceId())
                .deviceStatus(iotDevice.getDeviceStatus())
                .deviceTem(iotDevice.getDeviceTem())
                .simCardId(iotDevice.getSimCard()!=null?iotDevice.getSimCard().getSimId():null)
                .build();
    }
}
