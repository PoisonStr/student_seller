package cn.edu.hqu.javaee.chapter7_1.service.impl;

import org.mockito.internal.matchers.Find;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.hqu.javaee.chapter7_1.domain.entity.Hello;
import cn.edu.hqu.javaee.chapter7_1.domain.entity.Hquer;
import cn.edu.hqu.javaee.chapter7_1.repository.HquerRepository;
import cn.edu.hqu.javaee.chapter7_1.service.HquerService;

@Service
public class HquerServiceImpl implements HquerService{
	@Autowired
	HquerRepository hquerRepository;
	@Autowired
	SellerRepository sellerRepository;

	@Override
	public Hquer login(String userName, String password) {
		Hquer hquer;
		
		if((hquer=hquerRepository.findByUserName(userName))!=null 
				&& hquer.getPassword().equals(password)) {
			System.out.println(hquer.getUserName());
			return hquer;
		}
		return null;  //否则停留在此页面
	}

	@Override//对于注册页面，需要判断用户名这一块是否重复
	public boolean register(Hquer hquer) {
		if((hquerRepository.findByUserName(hquer.getUserName()))==null) {
			hquerRepository.save(hquer);
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean find(Seller seller) {
		if((sellerRepository.findByUserName(seller.getUserName()))==null) {
			sellerRepository.save(seller);
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Hquer getUserDetail(String userName) {
		return SellerRepository.findByUserName2(userName);
	}
	public Seller seller(String type, String nop,String cost,String,ifnot) {
		Seller seller;
		
		if((seller=sellerRepository.gettype(type))!=null 
				&& seller.getnop().equals(nop)&&seller.getcost.equal(cost)&&seller.getif.equal(ifnot)) {
			return seller;
		}
		return null;
	}

	
	@Override
	public Seller getUserDetail(String type,String nop,String cost,String ifnot) {
		return sellerRepository.findByUserName(type);
	}

}
public Hquer Hquer(String type, String nop,String cost,String,ifnot) {
	Seller seller;
	
	if((seller=sellerRepository.gettype(type))!=null 
			&& seller.getnop().equals(nop)&&seller.getcost.equal(cost)&&seller.getif.equal(ifnot)) {
		return seller;
	}
	return null;
}


@Override
public Find getUserDetail(String type,String nop,String cost,String ifnot) {
	return sellerRepository.findByUserName(type);
}

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
                return hlo[i];
}
}
