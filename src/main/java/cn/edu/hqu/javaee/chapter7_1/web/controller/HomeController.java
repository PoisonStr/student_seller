package cn.edu.hqu.javaee.chapter7_1.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller//首页的地址为http/Index
public class HomeController {
	@RequestMapping({"/","index"})
	public String home() {
		return "home";
	}
}
