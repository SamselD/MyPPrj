package com.ex.serviceImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class LoginServiceCtrl {

	@RequestMapping(value="/getInfo", method=RequestMethod.POST)
	public Map<String,Object> processLogin(Map<String, String> userInfo){
		System.out.println("Information : "+userInfo);
		Map<String, Object> rMap = new HashMap();
		rMap.put("result", "success");
		return rMap;
	}
}
