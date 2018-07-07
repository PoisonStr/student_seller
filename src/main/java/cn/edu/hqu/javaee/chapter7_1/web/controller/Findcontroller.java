package cn.edu.hqu.javaee.chapter7_1.web.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.validation.Valid;

import org.mockito.internal.matchers.Find;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.edu.hqu.javaee.chapter7_1.Chapter71Application;
import cn.edu.hqu.javaee.chapter7_1.domain.entity.Hquer;
import cn.edu.hqu.javaee.chapter7_1.domain.entity.Seller;
import cn.edu.hqu.javaee.chapter7_1.service.FindService;
import cn.edu.hqu.javaee.chapter7_1.service.HquerService;
import cn.edu.hqu.javaee.chapter7_1.service.SellerService;
import cn.edu.hqu.javaee.chapter7_1.web.controller.FormEntity.User;

@Controller
//查找时的页面跳转关系

@RequestMapping(value="/{userName}",method=RequestMethod.GET)
public String hquerProfile(@PathVariable String userName,Model model) {
	if(!model.containsAttribute("hquer")) {
		Hquer hquer=sellerService.getUserDetail(username);
		model.addAttribute(hquer);
	}
	return "hquer_profile";
	return "seller_profile";
}
}