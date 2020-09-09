package com.qcells.consumer.data.model.strings;

import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ModuleDevice {
	private int moduleSerial;
	private float moduleVoltage;
	private float moduleTemperature;
	private int moduleWatt;
	private float moduleCurrent;
}
