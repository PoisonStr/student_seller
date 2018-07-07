package cn.edu.hqu.javaee.chapter7_1.repository;

import cn.edu.hqu.javaee.chapter7_1.domain.entity.Find;

public interface FindRepository {
	public Find findByUserName(String type,String nop,String cost,String ifnot );
}
