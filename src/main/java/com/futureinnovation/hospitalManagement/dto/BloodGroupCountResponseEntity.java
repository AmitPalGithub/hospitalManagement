package com.futureinnovation.hospitalManagement.dto;

import com.futureinnovation.hospitalManagement.entity.type.BloodGroupType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class BloodGroupCountResponseEntity {

    private BloodGroupType bloodGroupType;
    private Long count;

    public BloodGroupCountResponseEntity(BloodGroupType bloodGroup, Long count) {
        this.bloodGroupType = bloodGroup;
        this.count = count;
    }
}
