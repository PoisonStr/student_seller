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
import cn.edu.hqu.javaee.chapter7_1.domain.entity.Hquer.ID.miss;
import cn.edu.hqu.javaee.chapter7_1.repository.HquerRepository;

@Repository
public class HquerRepositoryImpl implements HquerRepository {
	private static final String SQL_INSERT_HQUER = "insert into hquer (firstname,lastname,address,tel,date,sex,username,password) values(?,?,?,?,?,?,?,?)";
	private static final String SQL_FIND_HQUER = "select id,firstname,lastname,address,tel,date,sex,username,password from hquer where username=?";
	private static final String SQL_INSERT_MISS = "insert into hquer (missplace,,misstime) values(?,?)";
	private static final String SQL_FIND_MISS = "select missplace,misstime from hquer where missplace=?";
	@Autowired
	private JdbcOperations jdbcOperations;

	@Override//实现向数据库中存入输入的数据
	public void save(Hquer hquer) {
		// TODO Auto-generated method stub
		jdbcOperations.update(SQL_INSERT_HQUER, hquer.getFirstName(), hquer.getLastName(), hquer.getAddress(),
				hquer.getsex(), hquer.getPassword(),hquer.gettel(),hquer.getdate());
	}
	@Override//查找，并返回hquer,从而在数据库中显示消息列表RowMapper
	public Hquer findByUserName(String userName) {
		List<Hquer> list = new ArrayList<Hquer>();
		list = jdbcOperations.query(SQL_FIND_HQUER, new RowMapper<Hquer>() {

			@Override//一个类其中用于实现RowMapper接口的方法，第一个参数表示获取到的结果集、第二个表示结果集中获取到的结果个数，通常用于查询语句~
			public Hquer mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Hquer hquer = new Hquer();
				hquer.setId(rs.getLong("id"));
				hquer.setFirstName(rs.getString("firstname"));
				hquer.setLastName(rs.getString("lastname"));
				hquer.setUserName(rs.getString("username"));
				hquer.setaddress(rs.getString("address"));
				hquer.setPassword(rs.getString("password"));
				hquer.setsex(rs.getString("sex"));
				hquer.settel(rs.getString("tel"));
				hquer.setdate(rs.getString("date"));
				return hquer;
			}

		}, userName);
		
		if (list.size() >= 1) {
			return list.get(0);    
		} else
			return null;
	} 

}
