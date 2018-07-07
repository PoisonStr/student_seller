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
public class Hquer {
	
	@Getter
	@Setter
	private Long id;
	
	@Getter
	@Setter
	@NotEmpty
	@Size(min=1,max=30,message="{firstName.size}")
	private String firstName;
	
	@Getter
	@Setter
	@NotEmpty
	@Size(min=5,max=16,message="{userName.size}")
	private String userName;
	
	@Getter
	@Setter
	@NotEmpty
	@Size(min=4,max=25,message="{password.size}")
	private String password;
	
	@Getter
	@Setter
	@NotEmpty
	@Size(min=1,max=30,message="{lastName.size}")
	private String lastName;
	
	@Getter
	@Setter
	@NotEmpty(message="{sex.size}")
	@Email(message="{sex.valid}")
	private String sex;
	
	@Getter
	@Setter
	private MultipartFile pic;

	private String address;
	private String tel;
	private String date;
    private String nop;


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
	private String getSex() {
		return sex;
	}	
	public void setsex(String sex) {
		// TODO Auto-generated method stub
		this.sex=sex;
		
	}
	@SuppressWarnings("unused")
	private void setAddress(String address) {
		this.address = address;
	}
	public Object gettel() {
		// TODO Auto-generated method stub
		return null;
	}
	@SuppressWarnings("unused")
	private String getTel() {
		return tel;
	}
	@SuppressWarnings("unused")
	private void setTel(String tel) {
		this.tel = tel;
	}
	@SuppressWarnings("unused")
	private String getDate() {
		return date;
	}
	@SuppressWarnings("unused")
	private void setDate(String date) {
		this.date = date;
	}
	public String getAddress() {
		return address;
	}
	public void setaddress(String address) {
		// TODO Auto-generated method stub
		this.address=address;
	}
	public Object getsex() {
		// TODO Auto-generated method stub
		return sex;
	}
	public Object getdate() {
		// TODO Auto-generated method stub
		return date;
	}
	public void settel( String tel) {
		// TODO Auto-generated method stub
		this.tel=tel;
		
	}
	public void setdate(String date) {
		// TODO Auto-generated method stub
		this.date=date;
	}
	public Object getnop() {
		
		// TODO Auto-generated method stub
		return nop;
	}
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

   public static class miss {
			     
			    private Object missplace;
				private Object misstime;
			    public void setmissplace(String missplace[]){
			        this.missplace= missplace;
			    }
			    public static Object getmissplace(){
			        return missplace;
			    }
			    public void setmisstime(String misstime){
			    	
			    }
				public static Object getmisstime() {
					// TODO Auto-generated method stub
					return misstime;}
				
			   
			    
			 
			    void add2(){
			        Miss[] h = new Miss[100];
			        for(int i = 0; i < 100; i++){
			            h[i] = new miss();
			            h[i].setmissplace((i+1));
	}



