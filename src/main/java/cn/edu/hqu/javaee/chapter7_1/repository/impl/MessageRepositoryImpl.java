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
	private static final String SQL_INSERT_Message = "insert into hquer (posttime,misstime,username,missplace) values(?,?,?,?)";
	private static final String SQL_FIND_Message= "select id,posttime,misstime,username,missplace from hquer where username=?";

	@Autowired
	private JdbcOperations jdbcOperations;
	public void save(Message message) {
		// TODO Auto-generated method stub
		jdbcOperations.update(SQL_INSERT_message, message.getPosttime(),message.getusername(),message.getmissplace(),message.getmisstime());
	}
	@Override
	public List<Message> findMessageByUserId(Date username) {
		List<Message> list=new ArrayList<Message>();
		list=jdbcOperations.query(SQL_FIND_Message, new RowMapper<Message>() {

			@Override
			public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
				Message message=new Message();
				message.setPostedTime(rs.getLong("posttime"));
				message.setusername(rs.getString("username"));
				message.setmissplace(rs.getDate("missplace"));
				message.setmisstime(rs.getDate("misstime"));
				return message;
			}
			
		}, username);
		return list;
	}
	@Override
	

}
