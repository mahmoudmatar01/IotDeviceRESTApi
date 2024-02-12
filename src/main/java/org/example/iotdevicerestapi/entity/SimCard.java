package org.example.iotdevicerestapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.iotdevicerestapi.enums.DeviceStatus;

@Entity
@Table(name = "sim-card")
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class SimCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long simId;
    private String operatorCode;
    private String simCountry;
    @Enumerated(value = EnumType.STRING)
    private DeviceStatus simStatus;
}
