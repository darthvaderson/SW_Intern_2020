package com.qcells.consumer.data.model.strings;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class StringDevice {
	private StringDeviceInfo info;
	private String error;
	private int stringVoltage;
	private float stringCurrent;
	private int temperature;
	private int totalWh;
	private com.qcells.consumer.data.model.strings.Modules Modules;
}
