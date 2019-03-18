package com.prashanth.spring.geode.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.gemfire.mapping.annotation.Region;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Region("temps")
public class Temperature {

    @Id
    private Long id;
    private double temperature;
    private String city;

}
