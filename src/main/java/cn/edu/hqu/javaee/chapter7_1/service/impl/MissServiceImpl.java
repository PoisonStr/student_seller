package cn.edu.hqu.javaee.chapter7_1.service.impl;

import org.mockito.internal.matchers.Find;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.hqu.javaee.chapter7_1.domain.entity.Hquer;
import cn.edu.hqu.javaee.chapter7_1.repository.FindRepository;
import cn.edu.hqu.javaee.chapter7_1.repository.HquerRepository;
import cn.edu.hqu.javaee.chapter7_1.service.FindService;
import cn.edu.hqu.javaee.chapter7_1.service.HquerService;

@Service
public class FindServiceImpl implements FindService{
	@Autowired
	FindRepository findRepository;

	@Override
	public Hquer Hquer(String type, String nop,String cost,String,ifnot) {
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
