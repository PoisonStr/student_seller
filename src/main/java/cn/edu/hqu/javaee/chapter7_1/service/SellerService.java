package cn.edu.hqu.javaee.chapter7_1.service;

import cn.edu.hqu.javaee.chapter7_1.domain.entity.Hquer;
import cn.edu.hqu.javaee.chapter7_1.service.impl.Seller;

public interface SellerService {
	public Seller login(String userName,String password);
	public boolean sellerregister(Seller seller);
	public Seller getUserDetail(String userName);
    public void add(String ID);
    public boolean addchange(Seller seller);
}
