package cn.edu.hqu.javaee.chapter7_1.web.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.validation.Valid;

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
import cn.edu.hqu.javaee.chapter7_1.service.SellerService;
import cn.edu.hqu.javaee.chapter7_1.web.controller.FormEntity.User;

@Controller
@RequestMapping("/seller")
public class SellerController {
	@Autowired 
	SellerService sellerService;
	//   /hquer/register
	@RequestMapping(value="/sellerregister",method=RequestMethod.GET)
	public String showRegisterForm(Model model) {
		model.addAttribute(new Hquer());
		return "sellerregister";
	}
	
	//注册时的页面跳转关系
	@RequestMapping(value="/sellerregister",method=RequestMethod.POST)
	public String processRegister(@Valid Seller seller,Errors errors,RedirectAttributes model) throws IOException {
		if(errors.hasErrors())
			return "sellerregister";
		else if(!sellerService.sellerregister(seller)) {
			errors.rejectValue("userName", "用户已存在");
			return "sellerregister";
		}
		else {//如果成功，则跳转到注册成功的页面
			Files.copy(seller.getPic().getInputStream(), Paths.get(Chapter71Application.ROOT, seller.getUserName()+".jpeg"),StandardCopyOption.REPLACE_EXISTING);
			model.addFlashAttribute(seller);
			return "redirect:/seller/"+seller.getUserName();
		}
		//localhost:8080/hquer/lixinyuan
	}

	
	// 登录时的跳转页面关系
	@RequestMapping(value="/sellerlogin",method=RequestMethod.GET)
	public String showLoginForm(Model model) {
		model.addAttribute(new User());
		return "sellerlogin";
		
	}
	
	@RequestMapping(value="/sellerlogin",method=RequestMethod.POST)
	public String processLogin(@Valid User user,Errors erros) {
		User user;
		if((seller=sellerService.login(user.getUserName(), user.getPassword()))==null)
			return "sellerlogin";
		
		else
		return "addchange";
		
	}


//注册时的页面跳转关系
@RequestMapping(value="/register",method=RequestMethod.POST)
public String processRegister(@Valid Seller seller,Errors errors,RedirectAttributes model) throws IOException {
	if(errors.hasErrors())
		return "register";
	else if(!sellerService.sellerregister(seller)) {
		return "register";
	}
	else {//如果成功，则跳转到注册成功的页面
		Files.copy(seller.getPic().getInputStream(), Paths.get(Chapter71Application.ROOT, hquer.getUserName()+".jpeg"),StandardCopyOption.REPLACE_EXISTING);
		model.addFlashAttribute(seller);
		return "redirect:/hquer/"+seller.getUserName();
	}
	//localhost:8080/hquer/lixinyuan
}
@RequestMapping(value="/addchange",method=RequestMethod.GET)
public String showLoginForm(Model model) {
	model.addAttribute(new User());
	return "addchange";
	
}

//上传时的页面跳转关系
@RequestMapping(value="/addchange",method=RequestMethod.POST)
public String processRegister(@Valid Hquer hquer,Errors errors,RedirectAttributes model) throws IOException {
	if(errors.hasErrors())
		return "addchange";
	else if(!sellerService.addchange(seller)) {
		return "addchange";
	}
	else {//如果成功，则跳转到上传成功的页面
		Files.copy(hquer.getPic().getInputStream(), Paths.get(Chapter71Application.ROOT, hquer.getUserName()+".jpeg"),StandardCopyOption.REPLACE_EXISTING);
		model.addFlashAttribute(hquer);
		return "success";
	}
	//localhost:8080/hquer/lixinyuan
}

