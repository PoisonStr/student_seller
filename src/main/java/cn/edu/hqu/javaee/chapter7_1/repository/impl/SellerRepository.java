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
import cn.edu.hqu.javaee.chapter7_1.domain.entity.Seller;
import cn.edu.hqu.javaee.chapter7_1.domain.entity.Seller.ID.miss;
import cn.edu.hqu.javaee.chapter7_1.repository.SellerRepository;

@Repository
public class SellerRepositoryImpl implements SellerRepository {
	private static final String SQL_INSERT_Seller = "insert into hquer (id,address,type,cost,nop,username,ifnot) values(?,?,?,?,?,?)";
	private static final String SQL_FIND_Seller = "select id,address,type,cost,nop,username,ifnot from seller where username=?";
	private static final String SQL_INSERT_Sellerinformation = "insert into hquer (id,address,tel,firstname,lastname,password,username) values(?,?,?,?,?,?,?)";
	private static final String SQL_FIND_Sellerinformation = "select id,address,tel,firstname,lastname,password,username from seller where username=?";
	@Autowired
	private JdbcOperations jdbcOperations;

	@Override//实现向数据库中存入输入的数据
	public void save(Seller seller) {
		// TODO Auto-generated method stub
		jdbcOperations.update(SQL_INSERT_Seller, seller.getId(), seller.getUsername(), seller.getaddress(),
				seller.gettype(), seller.getcost(),seller.getnop(),seller.getdifnot());
	}
	@Override//查找，并返回hquer,从而在数据库中显示消息列表RowMapper
	public Seller findByUserName(String userName) {
		List<Seller> list = new ArrayList<Seller>();
		list = jdbcOperations.query(SQL_FIND_Seller, new RowMapper<Seller>() {

			@Override//一个类其中用于实现RowMapper接口的方法，第一个参数表示获取到的结果集、第二个表示结果集中获取到的结果个数，通常用于查询语句~
			public Seller mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Seller seller = new Seller();
			    seller.setId(rs.getLong("id"));
        		seller.setUserName(rs.getString("username"));
				seller.setaddress(rs.getString("address"));
				seller.settype(rs.getString("type"));
				seller.setcost(rs.getString("cost"));
				seller.setnop(rs.getString("nop"));
				seller.setifnot(rs.getString("ifnot"));
				return seller;
			}

		}, userName);
		
		if (list.size() >= 1) {
			return list.get(0);    
		} else
			return null;
		if(seller.getUsername()==seller.setUsername()) {
			return  save(seller);
		}
	}
		
	public void save2( Sellerinformation  sellerinformation) {
		// TODO Auto-generated method stub
		jdbcOperations.update(SQL_INSERT_Sellerinformation, Sellerinformation.gettel(), Sellerinformation.getUsername(),Sellerinformation.getaddress(),Sellerinformation,getfirstname(),Sellerinformation.getlastname(),Sellerinformation.getpassword() }}
	@Override//查找，并返回hquer,从而在数据库中显示消息列表RowMapper
	public Seller findByUserName2(String userName) {
		List<Sellerinformation> list2 = new ArrayList<Sellerinformation>();
		list2 = jdbcOperations.query(SQL_FIND_Sellerinformation, new RowMapper<Sellerinformation>() {

			@Override//一个类其中用于实现RowMapper接口的方法，第一个参数表示获取到的结果集、第二个表示结果集中获取到的结果个数，通常用于查询语句~
			public Sellerinformation mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Sellerinformation sellerinformation = new Sellerinformation();
				sellerinformation.setId(rs.getLong("id"));
				sellerinformation.setFirstName(rs.getString("firstname"));
				sellerinformation.setLastName(rs.getString("lastname"));
				sellerinformation.setUserName(rs.getString("username"));
				sellerinformation.setaddress(rs.getString("address"));
				sellerinformation.setPassword(rs.getString("password"));
				sellerinformation.settel(rs.getString("tel"));
				return sellerinformation;
			}

		}, userName);
		
		if (list2.size() >= 1) {
			return list2.get(0);    
		} else
			return null;
	} 

}
