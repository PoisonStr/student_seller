package cn.edu.hqu.javaee.chapter7_1.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import cn.edu.hqu.javaee.chapter7_1.domain.entity.Message;
import cn.edu.hqu.javaee.chapter7_1.repository.MessageRepository;

@Repository
public class MessageRepositoryImpl implements MessageRepository {

	private static final String SQL_SAVE_MESSAGE = "insert into message (hquerId,message,postedTime) values(?,?,?)";
	private static final String SQL_FIND_MESSAGE_BY_HQUERID = "select id,hquerId,message,postedTime from message where hquerId=?";
	@Autowired
	private JdbcOperations jdbcOperations;
	@Override
	public List<Message> findMessageByUserId(Long userId) {
		List<Message> list=new ArrayList<Message>();
		list=jdbcOperations.query(SQL_FIND_MESSAGE_BY_HQUERID, new RowMapper<Message>() {

			@Override
			public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
				Message message=new Message();
				message.setHquerId(rs.getLong("hquerId"));
				message.setMessage(rs.getString("message"));
				message.setPostedTime(rs.getDate("postedTime"));
				return message;
			}
			
		}, userId);
		return list;
	}
	@Override
	public void save(Message message) {
		// TODO Auto-generated method stub
		jdbcOperations.update(SQL_SAVE_MESSAGE, message.getHquerId(),message.getMessage(),message.getPostedTime());
	}

}
