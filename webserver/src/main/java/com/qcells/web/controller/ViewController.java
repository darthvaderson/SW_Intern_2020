package com.qcells.web.controller;

import java.util.ArrayList;
import java.util.Locale;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import com.qcells.web.inter.manager.HTTPClientManager;
import com.qcells.consumer.info.dto.ServerInfo;
import com.qcells.web.model.dto.UpdateInfo;
import com.qcells.web.model.service.ServerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class ViewController extends HttpServlet{
	private static final String producer_address = "http://localhost:8081/count";
	@Autowired
	private HTTPClientManager httpClientManager;
	@Autowired
	private ServerInfoService serverInfoService;

	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletRequest req) {


		String tmp = httpClientManager.get(producer_address);
		System.out.println(tmp);
		model.addAttribute("rest",tmp);

		try{
			ServerInfo serverInfo = serverInfoService.getServerInfo("192.168.56.1:8082");

			model.addAttribute("ip1",serverInfo.getIpAddress());
			model.addAttribute("cpu1",serverInfo.getCpuUsage());
			model.addAttribute("memory1",serverInfo.getMemUsage());
			model.addAttribute("number1",serverInfo.getDeviceCount());

		}catch(Exception e){
			e.printStackTrace();
		}

		return "info";
	}

	@RequestMapping(value= "/update", method = RequestMethod.GET)
	@ResponseBody
	public UpdateInfo infoUpdate(){

		UpdateInfo info = new UpdateInfo();
		String tmp = httpClientManager.get(producer_address);
		System.out.println(tmp);

		info.setCount(tmp);
		try{
			info.getInfo().add(serverInfoService.getServerInfo("192.168.56.1:8082"));

		}catch(Exception e){
			e.printStackTrace();
		}

		return info;
	}


}
