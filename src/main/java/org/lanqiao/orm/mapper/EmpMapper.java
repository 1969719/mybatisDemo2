package org.lanqiao.orm.mapper;

import org.lanqiao.orm.jopo.Dept;
import org.lanqiao.orm.jopo.Emp;

import java.util.List;
import java.util.Map;

public interface EmpMapper {
   public Emp selectEmpById(Integer empno);

   public List<Emp> selectEmpList();

//多条件插查询

//   public List<Emp> selectEmpListCondition(String job,double sal,Integer deptno);

public List<Emp> selectEmpListCondition(Map<String, Object> conditionMap);
public List<Dept> selectDeptAndEmpByDeptno2(Integer deptno);


}
