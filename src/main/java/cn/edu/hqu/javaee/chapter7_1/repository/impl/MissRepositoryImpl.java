package cn.edu.hqu.javaee.chapter7_1.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mockito.internal.matchers.Find;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import cn.edu.hqu.javaee.chapter7_1.domain.entity.Hquer;
import cn.edu.hqu.javaee.chapter7_1.domain.entity.Hquer.ID.miss;
import cn.edu.hqu.javaee.chapter7_1.repository.FindRepository;
import cn.edu.hqu.javaee.chapter7_1.repository.HquerRepository;

@Repository
public class MissRepositoryImpl implements MissRepository {//访问店家数据库
	private static final String SQL_FIND_Miss= "select id,missplace,misstime where type=? nop=? cost=? ifnot=?";
	private static final String SQL_INSERT_Miss= "insert into hquer ( id,missplace,misstime) values(?,?,?)";
	@Autowired
	private JdbcOperations jdbcOperations;
	public void save2(Hquer hquer) {
		// TODO Auto-generated method stub
		for(int i=0;i<100;i++) {
		jdbcOperations.update(SQL_INSERT_MISS, miss.getmissplace(), miss.getmisstime() }}
	@Override//查找，并返回hquer,从而在数据库中显示消息列表RowMapper
	public Hquer findByUserName2(String userName) {
	List<Hquer> list2 = new ArrayList<Hquer>();
	list2 = jdbcOperations.query(SQL_FIND_MISS, new RowMapper<Hquer>() {
		@Override//一个类其中用于实现RowMapper接口的方法，第一个参数表示获取到的结果集、第二个表示结果集中获取到的结果个数，通常用于查询语句~
		public Hquer mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Hquer miss = new Hquer();
			miss.setmissplace(rs.getString("missplace"));
			miss.setmisstime(rs.getString("misstime"));
			return miss;
		}

	}, userName);
	if (list2.size() >= 1) {
		return list2.get(0);  
	} else
		return null;

}
}