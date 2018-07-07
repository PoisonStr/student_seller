 package cn.edu.hqu.javaee.chapter7_1.repository;

import java.util.List;

import cn.edu.hqu.javaee.chapter7_1.domain.entity.Message;
//登录判断
public interface MessageRepository {
	public void save(Message message);
	public List<Message> findMessageByUserId(Long userId);
	

}
