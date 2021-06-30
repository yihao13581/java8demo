package com.haotian.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @CLassName IndexController
 * @Description: TODO
 * @date: 2021/1/14 15:57
 * @Version 1.0
 */
@Controller
public class IndexController {
	@GetMapping({"/","/index"})
	public String index(){
		return "index";
	}
}
