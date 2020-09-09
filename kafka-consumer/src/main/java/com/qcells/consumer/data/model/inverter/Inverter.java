package com.qcells.consumer.data.model.inverter;

import lombok.*;

import java.util.List;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Inverter {
	private long startTS;
	private long endTS;
	private String error;
	private List<InverterDevice> devices;
}
