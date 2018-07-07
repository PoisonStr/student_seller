package cn.edu.hqu.javaee.chapter7_1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.hqu.javaee.chapter7_1.domain.entity.Message;
import cn.edu.hqu.javaee.chapter7_1.repository.HquerRepository;
import cn.edu.hqu.javaee.chapter7_1.repository.MessageRepository;
import cn.edu.hqu.javaee.chapter7_1.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService{

	@Autowired
	MessageRepository messageRepository;
	@Autowired
	MissRepository missRepository;
	@Override
	public List<Message> getMessageByUserName(String userName) {
		
		return messageRepository.findMessageByUserId(missRepository.findByUserName(userName).getId());
	}//实现针对于不同的用户的message查找，如果没有username限制时，就会用户之间的消息就会乱。（等于说是以username作为两个数据库之间的媒介）
	@Override
	public void saveMessage(Message message) {
		messageRepository.save(message);
		
	}

}
