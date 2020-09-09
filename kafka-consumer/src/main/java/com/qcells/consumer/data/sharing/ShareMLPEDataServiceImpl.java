package com.qcells.consumer.data.sharing;

import com.qcells.consumer.hazelcast.manager.MapManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ShareMLPEDataServiceImpl implements ShareMLPEDataService{

	@Autowired
    MapManager mapManager;

	@Override
	public void shareMLPEData(String keyId, String data) {
			try {
				// Hazelcast 사용 이유
				if(data == null){
					// keyId인 장비는 brokenflag = true 시켜주기 -> Map으로 갈까말까,,,,
				}

				// 여러 서비스 서버 있는 경우 구분 및 확인용
				if(mapManager.getMLPEDataMap(keyId) != null) {
					// System.out.println(mapManager.getMLPEDataMap(keyId));
				}

				// 최신 데이터로 바꿔주기
				mapManager.putMLPEDataMap(keyId, data);

				Thread.sleep(2000);
			} catch(Exception e) {
				e.printStackTrace();
			}
	}
}
