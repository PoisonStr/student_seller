package cn.edu.hqu.javaee.chapter7_1.domain.entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.web.multipart.MultipartFile;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class Seller {
	
	@Getter
	@Setter
	private Long id;
	private String address;
	private String username;
	private String type;
    private String nop;
    private String ifnot;
	private String cost;


	@Override
	//判断对象是否相等
	public boolean equals(Object that) {
		// TODO Auto-generated method stub  某个类实现了接口后自动生成的
		//Object类的equals方法比较的是hashCode,如果String在没有重写equals的情况下
		//s1.equals()返回应该是false
		return EqualsBuilder.reflectionEquals(this, that, "firstName","lastName","userName","password","email");
	}//object类的equals方法是比较2个类的哈希码 是不是相等，如果相等，返回这几个值，实现在点击时提示功能？？）（猜想能否将这个功能用于学生选房时的选择上）
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return HashCodeBuilder.reflectionHashCode(this, "firstName","lastName","userName","password","emial","sex");
	}

	@SuppressWarnings("unused")
	private String getUsername() {
		return username;
	}	
	public void setUsername(String username) {
		// TODO Auto-generated method stub
		this.username=username;
		
	}
	@SuppressWarnings("unused")
	private void setAddress(String address) {
		this.address = address;
	}
	public String getcost() {
		// TODO Auto-generated method stub
		return cost;
	}
	@SuppressWarnings("unused")
	private void setcost(String cost) {
		this.cost = cost;
	}
	@SuppressWarnings("unused")
	private String getnop() {
		return nop;
	}
	@SuppressWarnings("unused")
	private void setnop(String nop) {
		this.nop = nop;
	}
	@SuppressWarnings("unused")
	private String getifnot() {
		return ifnot;
	}
	@SuppressWarnings("unused")
	private void setifnot(String ifnot) {
		this.ifnot = ifnot;
	}
	@SuppressWarnings("unused")
	
public class ID {
		     
		    private long giveid;
		    public void setId(long id){
		        this.giveid = id;
		    }
		    public long getId(){
		        return giveid;
		    }
		    void add(){
		        ID[] hlo = new ID[100];
		        for(int i = 0; i < hlo.length; i++){
		            hlo[i] = new ID();
		            hlo[i].setId((i+1));
}
		    }