package com.tencent.pojo;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.tencent.group.Goup1;
import com.tencent.group.Goup2;

/**
 * 映射Emp表的实体类
 */
public class Emp {

	/**雇员编号*/
	@Min(value = 1000,message = "{emp.empno}",groups = {Goup1.class})
	@Max(value = 9999,message = "{emp.empno}",groups = {Goup1.class})
	private int empno;
	/**雇员姓名*/
	@Pattern(regexp = "[0-9a-zA-z_]{6,10}",message = "{emp.ename}",groups = {Goup1.class})
	private String ename;
	/**职位*/
	@NotEmpty(message = "{emp.job}",groups = {Goup2.class})
	private String job;
	/**上级经理*/
	@Min(value = 1000,message = "{emp.mgr}",groups = {Goup2.class})
	@Max(value = 9999,message = "{emp.mgr}",groups = {Goup2.class})
	private int mgr;
	/**入职日期*/
	@NotNull(message = "{emp.hiredate}",groups = {Goup2.class})
	private Date hiredate;
	/**薪水*/
	@Min(value = 1000,message = "{emp.salary}",groups = {Goup2.class})
	@Max(value = 99999,message = "{emp.salary}",groups = {Goup2.class})
	private double salary;
	/**奖金*/
	@Min(value = 1000,message = "{emp.salary}",groups = {Goup2.class})
	@Max(value = 99999,message = "{emp.salary}",groups = {Goup2.class})
	private double comm;
	/**部门*/
	private Dept dept;//一对一，一个员工属于一个部门
	/**
	 * 	管理的下属员工信息 
	 */
	public List<Emp> subEmpList;//一对多，一个员工可以管理多个下属
	
	/**构造函数*/
	public Emp() {
		super();
	}
	public Emp(int empno, String ename, String job, int mgr, Date hiredate, double salary, double comm, Dept dept,
			List<Emp> subEmpList) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.salary = salary;
		this.comm = comm;
		this.dept = dept;
		this.subEmpList = subEmpList;
	}
	/**访问器*/
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getMgr() {
		return mgr;
	}
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public double getComm() {
		return comm;
	}
	public void setComm(double comm) {
		this.comm = comm;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	
	public List<Emp> getSubEmpList() {
		return subEmpList;
	}
	public void setSubEmpList(List<Emp> subEmpList) {
		this.subEmpList = subEmpList;
	}
	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", ename=" + ename + ", job=" + job + ", mgr=" + mgr + ", hiredate=" + hiredate
				+ ", salary=" + salary + ", comm=" + comm + ", dept=" + dept + "]";
	}
	
	
	
}
