package cn.edu.hqu.javaee.chapter7_1.repository;

import cn.edu.hqu.javaee.chapter7_1.domain.entity.Hquer;

public interface SellerRepository {
	public void save(Seller seller);
	public Seller findByUserName(String userName);
	public void save2(Sellerinformation sellerinformation);
	public Sellerinformation findByUserName2(String userName);
	
}
