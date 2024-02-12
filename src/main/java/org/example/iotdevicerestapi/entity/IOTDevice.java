package org.example.iotdevicerestapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.iotdevicerestapi.enums.DeviceStatus;

@Entity
@Table(name = "iot-device")
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class IOTDevice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deviceId;
    @Enumerated(value = EnumType.STRING)
    private DeviceStatus deviceStatus;
    private double deviceTem;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sim_card_id")
    private SimCard simCard;
}
