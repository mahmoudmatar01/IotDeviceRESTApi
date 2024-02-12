package org.example.iotdevicerestapi.repository;

import org.example.iotdevicerestapi.entity.IOTDevice;
import org.example.iotdevicerestapi.enums.DeviceStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOTDeviceRepository extends JpaRepository<IOTDevice,Long> {
    List<IOTDevice> findByDeviceStatus(DeviceStatus deviceStatus);
    List<IOTDevice> findByDeviceStatusAndDeviceTemBetween(DeviceStatus deviceStatus,double value1,double value2);
}