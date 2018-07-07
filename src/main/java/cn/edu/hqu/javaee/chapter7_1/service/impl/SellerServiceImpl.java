package cn.edu.hqu.javaee.chapter7_1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.hqu.javaee.chapter7_1.domain.entity.Hello;
import cn.edu.hqu.javaee.chapter7_1.domain.entity.Hquer;
import cn.edu.hqu.javaee.chapter7_1.repository.SellerRepository;
import cn.edu.hqu.javaee.chapter7_1.service.HquerService;

@Service
public class SellerServiceImpl implements SellerService{
	@Autowired
	SellerRepository sellerRepository;

	@Override
	public Seller sellerlogin(String userName, String password) {
		Seller seller;
		
		if((seller=sellerRepository.findByUserName(userName))!=null 
				&& seller.getPassword().equals(password)) {
			System.out.println(seller.getUserName());
			return seller;
		}
		return null;  //否则停留在此页面
	}

	@Override//对于注册页面，需要判断用户名这一块是否重复
	public boolean register(Seller seller) {
		if((sellerRepository.findByUserName(seller.getUserName()))==null) {
			sellerRepository.save(seller); //满足条件将助兴保存如数据库操作
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}
	@Override//对于上传页面，需要判断是否改变这一块
	public boolean addchange(Seller seller) {
		if((sellerRepository.findByUserName(seller.getUserName())
				==null&&seller.gettype().equals(type)
				==null&&seller.getnop().equals(nop)
				==null&&seller.getcost().equals(cost)
				==null&&seller.getifnot().equals(ifnot)))
		{
			sellerRepository.save(seller); //满足条件将助兴保存如数据库操作
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Seller getUserDetail(String userName) {
		return sellerRepository.findByUserName(userName);//执行返回具体信息
	}
	@Override
	public void add(String ID) {
		 java.util.Scanner sc = new java.util.Scanner(System.in);
	        int num = sc.nextInt();
	        Hello[] hlo = new Hello[num];
	        for(int i = 0; i < hlo.length; i++){
	            hlo[i] = new Hello();
	            hlo[i].setId((i+1));
	}

}
}