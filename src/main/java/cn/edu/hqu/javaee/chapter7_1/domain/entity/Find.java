package cn.edu.hqu.javaee.chapter7_1.domain.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Find {
	private String type;
    private String nop;
    private String cost;
    private String ifnot;
    @Override
	//判断对象是否相等
	public boolean equals(Object that) {
		// TODO Auto-generated method stub  某个类实现了接口后自动生成的
		//Object类的equals方法比较的是hashCode,如果String在没有重写equals的情况下
		//s1.equals()返回应该是false
		return EqualsBuilder.reflectionEquals(this, that, "type","nop","cost","");
	}//object类的equals方法是比较2个类的哈希码 是不是相等，如果相等，返回这几个值，实现在点击时提示功能？？）（猜想能否将这个功能用于学生选房时的选择上）
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return HashCodeBuilder.reflectionHashCode(this, "type","nop","cost");
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public String getNop() {
		return nop;
	}
	public void setNop(String nop) {
		this.nop = nop;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getIfnot() {
		return ifnot;
	}
	public void setIfnot(String ifnot) {
		this.ifnot = ifnot;
	}
}
