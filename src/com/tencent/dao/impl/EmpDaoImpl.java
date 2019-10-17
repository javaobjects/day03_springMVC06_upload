package com.tencent.dao.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.tencent.dao.IEmpDao;
import com.tencent.exception.CustomerException;
import com.tencent.pojo.Dept;
import com.tencent.pojo.Emp;
/**
 */
/**
 * 
* <p>Title: EmpDaoImpl</p>  
* <p>
*	Description: 
*   数据访问层-接口实现类
*   
* </p> 
* @author xianxian 
* @date 2019年10月16日
 */
@Repository("empDao")//相当于 IEmpDao empDao = new EmpDaoImpl();
public class EmpDaoImpl implements IEmpDao {

	private static List<Emp> empList = new ArrayList<Emp>();
	
	static{
		//下属列表
		List<Emp> subEmpList = new ArrayList<Emp>();
		subEmpList.add(new Emp(100001, "下属一号", "需求工程师", 9999, new Date(), 8000, 500, new Dept(10, "需求部", "东软大厦125C"),null));
		subEmpList.add(new Emp(100002, "下属二号", "前端工程师", 9999, new Date(), 8000, 500, new Dept(20, "前端部", "东软大厦125C"),null));
		subEmpList.add(new Emp(100003, "下属三号", "开发工程师", 9999, new Date(), 8000, 500, new Dept(30, "开发部", "东软大厦125C"),null));
		subEmpList.add(new Emp(100004, "下属四号", "测试工程师", 9999, new Date(), 8000, 500, new Dept(40, "测试部", "东软大厦125C"),null));
		subEmpList.add(new Emp(100005, "下属五号", "实施工程师", 9999, new Date(), 8000, 500, new Dept(50, "实施部", "东软大厦125C"),null));
		
		//员工列表
		empList.add(new Emp(1111, "张三", "需求工程师", 9999, new Date(), 8000, 500, new Dept(10, "需求部", "东软大厦125C"),subEmpList));
		empList.add(new Emp(2222, "李四", "前端工程师", 9999, new Date(), 8000, 500, new Dept(20, "前端部", "东软大厦125C"),subEmpList));
		empList.add(new Emp(3333, "王五", "开发工程师", 9999, new Date(), 8000, 500, new Dept(30, "开发部", "东软大厦125C"),subEmpList));
		empList.add(new Emp(4444, "赵六", "测试工程师", 9999, new Date(), 8000, 500, new Dept(40, "测试部", "东软大厦125C"),subEmpList));
		empList.add(new Emp(5555, "田七", "实施工程师", 9999, new Date(), 8000, 500, new Dept(50, "实施部", "东软大厦125C"),subEmpList));
	}
	
	@Override
	public List<Emp> selectEmps() {
		return empList;
	}

	@Override
	public Emp selectEmpByempIndex(Integer empIndex) {
		
		return empList.get(empIndex);
	}

	@Override
	public boolean insertEmp(Emp emp) {
		empList.add(emp);
		
		//制造异常，将异常交给异常处理器去处理
		
		try {
			FileInputStream input = new FileInputStream(new File("CustomerValidationMessages.properties文件找不到"));
		} catch (FileNotFoundException e) {
			
			throw new CustomerException("CustomerValidationMessages.properties文件找不到");
		}
		
		return true;
	}
	
	
}
