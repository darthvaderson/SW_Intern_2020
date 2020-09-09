package com.qcells.web.inter.manager;

import com.hazelcast.core.EntryEvent;
import com.hazelcast.map.listener.EntryAddedListener;
import com.hazelcast.map.listener.EntryUpdatedListener;
import org.springframework.stereotype.Service;

@Service("hazelcastListenerManager")
public class HazelcastListenerManager implements EntryUpdatedListener<Object, Object>, EntryAddedListener<Object, Object>{

	@Override
	public void entryAdded(EntryEvent<Object, Object> event) {
		// TODO Auto-generated method stub
		System.out.println("entryAdded : " + event);
		System.out.println(event.getName());
		System.out.println(event.getKey());
		System.out.println(event.getEventType());
	}

	@Override
	public void entryUpdated(EntryEvent<Object, Object> event) {
		// TODO Auto-generated method stub
//		System.out.println("entryUpdated : " + event);
//		System.out.println(event.getValue());
	}
}
