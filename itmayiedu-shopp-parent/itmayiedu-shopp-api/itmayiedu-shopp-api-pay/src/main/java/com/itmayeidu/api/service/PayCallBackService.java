package com.itmayeidu.api.service;

import com.itmayiedu.base.ResponseBase;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @CLassName PayCallBackService
 * @Description: TODO
 * @date: 2019/12/26 11:10
 * @Version 1.0
 */
@RequestMapping("/callBack")
public interface PayCallBackService {
	//同步回调
	@RequestMapping("/sysCallBackService|")
	public ResponseBase synCallBack(@RequestParam Map<String ,String> param);
	//异步回调
	@RequestMapping("/asynCallBackService")
	public String aysnCallBack(@RequestParam Map<String,String>params);

}
