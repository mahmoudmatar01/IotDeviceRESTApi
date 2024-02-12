package org.example.iotdevicerestapi.service;

import org.example.iotdevicerestapi.dto.request.IoTDeviceRequestDto;
import org.example.iotdevicerestapi.dto.response.IotDeviceResponseDto;
import org.example.iotdevicerestapi.enums.DeviceStatus;

import java.util.List;

public interface IoTDeviceService {
    void addIoTDevice(IoTDeviceRequestDto requestDto);
    List<IotDeviceResponseDto> getAllDevicesWaitingForActivation();
    void updateDeviceConfigurationStatus(Long deviceId, DeviceStatus newStatus);
    void removeDevice(Long deviceId);
    List<IotDeviceResponseDto>  findByDeviceStatusAndDeviceTemBetween(DeviceStatus deviceStatus,double temValue1,double temValue2);
}
