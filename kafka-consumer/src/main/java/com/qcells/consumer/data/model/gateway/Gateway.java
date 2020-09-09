package com.qcells.consumer.data.model.gateway;

import lombok.*;

import java.util.List;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Gateway {
	private List<GatewayDevice> devices;
}
