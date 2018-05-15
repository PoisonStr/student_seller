package cn.edu.hqu.javaee.chapter7_1.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import cn.edu.hqu.javaee.chapter7_1.domain.entity.Hquer;
import cn.edu.hqu.javaee.chapter7_1.repository.HquerRepository;

@Repository
public class HquerRepositoryImpl implements HquerRepository {
	private static final String SQL_INSERT_HQUER = "insert into hquer (firstname,lastname,username,email,password) values(?,?,?,?,?)";
	private static final String SQL_FIND_HQUER = "select id,firstname,lastname,username,email,password from hquer where username=?";
	@Autowired
	private JdbcOperations jdbcOperations;

	@Override
	public void save(Hquer hquer) {
		// TODO Auto-generated method stub
		jdbcOperations.update(SQL_INSERT_HQUER, hquer.getFirstName(), hquer.getLastName(), hquer.getUserName(),
				hquer.getEmail(), hquer.getPassword());
	}

	@Override
	public Hquer findByUserName(String userName) {
		List<Hquer> list = new ArrayList<Hquer>();
		list = jdbcOperations.query(SQL_FIND_HQUER, new RowMapper<Hquer>() {

			@Override
			public Hquer mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Hquer hquer = new Hquer();
				hquer.setId(rs.getLong("id"));
				hquer.setFirstName(rs.getString("firstname"));
				hquer.setLastName(rs.getString("lastname"));
				hquer.setUserName(rs.getString("username"));
				hquer.setEmail(rs.getString("email"));
				hquer.setPassword(rs.getString("password"));
				return hquer;
			}

		}, "zhangsan");
		
		if (list.size() >= 1) {
			return list.get(0);
		} else
			return null;
	}
}
