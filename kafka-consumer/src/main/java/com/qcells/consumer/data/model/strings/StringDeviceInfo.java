package com.qcells.consumer.data.model.strings;

import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StringDeviceInfo {
	private String portError;
	private String host;
	private int port;
	private int id;
	private String name;
	private int serialNo;
	private String fwVersion;
	private int comparator;
	private int devider;
	private int rawPulsesCounter;
}
