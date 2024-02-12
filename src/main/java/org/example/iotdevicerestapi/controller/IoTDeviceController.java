package org.example.iotdevicerestapi.controller;

import lombok.RequiredArgsConstructor;
import org.example.iotdevicerestapi.dto.request.IoTDeviceRequestDto;
import org.example.iotdevicerestapi.dto.response.IotDeviceResponseDto;
import org.example.iotdevicerestapi.enums.DeviceStatus;
import org.example.iotdevicerestapi.service.IoTDeviceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
@RequiredArgsConstructor
public class IoTDeviceController {
    private final IoTDeviceService ioTDeviceService;

    @PostMapping("/add")
    public ResponseEntity<?> addIoTDevice(@RequestBody IoTDeviceRequestDto requestDto) {
        ioTDeviceService.addIoTDevice(requestDto);
        return new ResponseEntity<>("Data Saved!",HttpStatus.CREATED);
    }

    @GetMapping("/waiting-for-activation")
    public ResponseEntity<?> getAllDevicesWaitingForActivation() {
        List<IotDeviceResponseDto> iotDevices = ioTDeviceService.getAllDevicesWaitingForActivation();
        return new ResponseEntity<>(iotDevices, HttpStatus.OK);
    }

    @PutMapping("/{deviceId}/update-status")
    public ResponseEntity<?> updateDeviceConfigurationStatus(
            @PathVariable Long deviceId,
            @RequestParam DeviceStatus newStatus
    ) {
        ioTDeviceService.updateDeviceConfigurationStatus(deviceId, newStatus);
        return new ResponseEntity<>("Data Updated!",HttpStatus.OK);
    }

    @DeleteMapping("/{deviceId}")
    public ResponseEntity<?> removeDevice(@PathVariable Long deviceId) {
        ioTDeviceService.removeDevice(deviceId);
        return new ResponseEntity<>("Data Removed!",HttpStatus.OK);
    }

    @GetMapping("/status-and-tem")
    public ResponseEntity<List<IotDeviceResponseDto>> findByDeviceStatusAndSimCardStatusAndDeviceTemBetween(
            @RequestParam DeviceStatus deviceStatus,
            @RequestParam double temValue1,
            @RequestParam double temValue2
    ) {
        List<IotDeviceResponseDto> iotDevices = ioTDeviceService.findByDeviceStatusAndDeviceTemBetween(
                deviceStatus, temValue1, temValue2
        );
        return new ResponseEntity<>(iotDevices, HttpStatus.OK);
    }
}
