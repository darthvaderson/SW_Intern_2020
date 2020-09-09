package com.qcells.consumer.data.model.gateway;

import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GatewayDevice {
	private long startTs;
	private long endTs;
	private String mac;
	private String id;
	private String sn;
	private Software software;
	private Ioboard ioboard;
}
