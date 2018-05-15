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
	@NotEmpty(message="email must not be empty")
	@Email(message="{email.valid}")
	private String email;
	
	@Getter
	@Setter
	private MultipartFile pic;
	
	@Override
	public boolean equals(Object that) {
		// TODO Auto-generated method stub
		return EqualsBuilder.reflectionEquals(this, that, "firstName","lastName","userName","password","email");
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return HashCodeBuilder.reflectionHashCode(this, "firstName","lastName","userName","password","emial");
	}
}
