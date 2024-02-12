package org.example.iotdevicerestapi.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.iotdevicerestapi.dto.request.IoTDeviceRequestDto;
import org.example.iotdevicerestapi.dto.response.IotDeviceResponseDto;
import org.example.iotdevicerestapi.entity.IOTDevice;
import org.example.iotdevicerestapi.enums.DeviceStatus;
import org.example.iotdevicerestapi.exceptions.BadRequestException;
import org.example.iotdevicerestapi.exceptions.NotFoundCustomException;
import org.example.iotdevicerestapi.mapper.IoTDeviceRequestDtoToIotDeviceMapper;
import org.example.iotdevicerestapi.mapper.IoTDeviceToIotDeviceResponseDtoMapper;
import org.example.iotdevicerestapi.repository.IOTDeviceRepository;
import org.example.iotdevicerestapi.service.IoTDeviceService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class IoTDeviceServiceImpl implements IoTDeviceService {
    private final IOTDeviceRepository iotDeviceRepository;
    private final IoTDeviceRequestDtoToIotDeviceMapper toIotDeviceMapper;
    private final IoTDeviceToIotDeviceResponseDtoMapper toIotDeviceResponseDtoMapper;
    @Override
    public void addIoTDevice(IoTDeviceRequestDto requestDto) {
        IOTDevice iotDevice=toIotDeviceMapper.apply(requestDto);
        iotDeviceRepository.save(iotDevice);
    }

    @Override
    public List<IotDeviceResponseDto> getAllDevicesWaitingForActivation() {
        List<IOTDevice>iotDevices=iotDeviceRepository.findByDeviceStatus(DeviceStatus.WAITING_FOR_ACTIVATION);
        return iotDevices.stream().map(toIotDeviceResponseDtoMapper).toList();
    }

    @Override
    public void updateDeviceConfigurationStatus(Long deviceId, DeviceStatus newStatus) {
        IOTDevice iotDevice=getDeviceById(deviceId);
        iotDevice.setDeviceStatus(newStatus);
        iotDeviceRepository.save(iotDevice);
    }

    @Override
    public void removeDevice(Long deviceId) {
        IOTDevice iotDevice=getDeviceById(deviceId);
        iotDeviceRepository.delete(iotDevice);
    }

    @Override
    public List<IotDeviceResponseDto> findByDeviceStatusAndDeviceTemBetween(DeviceStatus deviceStatus, double temValue1, double temValue2) {
        try{
            List<IOTDevice>iotDevices=iotDeviceRepository.findByDeviceStatusAndDeviceTemBetween(deviceStatus,temValue1,temValue2);
            return iotDevices.stream().map(toIotDeviceResponseDtoMapper)
                    .sorted(Comparator.comparingDouble(IotDeviceResponseDto::deviceTem))
                    .toList();
        }catch (Exception e){
            throw new BadRequestException(e.getMessage());
        }

    }

    private IOTDevice getDeviceById(Long iotDeviceId) {
        return iotDeviceRepository.findById(iotDeviceId).orElseThrow(
                ()->new NotFoundCustomException("Device with id : "+iotDeviceId+" not found!")
        );
    }
}
