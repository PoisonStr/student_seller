package cn.edu.hqu.javaee.chapter7_1.service;

import org.mockito.internal.matchers.Find;

import cn.edu.hqu.javaee.chapter7_1.domain.entity.Hquer;

public interface FindService {
	public Find getUserDetail(String userName);
	public Find find(String type, String nop,String cost,String,ifnot);

}
