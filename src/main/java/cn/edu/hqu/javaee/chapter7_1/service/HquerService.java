package cn.edu.hqu.javaee.chapter7_1.service;

import cn.edu.hqu.javaee.chapter7_1.domain.entity.Hquer;

public interface HquerService {
	public Hquer login(String userName,String password);
	public boolean register(Hquer hquer);
	public Hquer getUserDetail(String userName);
    public void add(String ID);
}
