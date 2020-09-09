package com.qcells.consumer.data.model.strings;

import lombok.*;

import java.util.List;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Strings {
	private long startTs;
	private long endTs;
	private List<StringDevice> devices;
}
