package org.lanqiao.orm;

import static org.junit.Assert.assertTrue;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.lanqiao.orm.jopo.Dept;
import org.lanqiao.orm.jopo.Emp;
import org.lanqiao.orm.mapper.EmpMapper;
import utils.MybutisUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppTest 
{
    SqlSession session = null;
    EmpMapper mapper = null;
    @Before
    public void before(){
        session = MybutisUtil.getSession();
        mapper = session.getMapper(EmpMapper.class);
    }
    @Test
    public void selectEmpById()
    {
        Emp emp = mapper.selectEmpById(122);
        System.out.println(emp);
    }
//    @Test
//    public void selectEmpListCondition(){
//        List<Emp> empList = mapper.selectEmpListCondition("程序员",40000.00,30);
//        for(Emp emp:empList){
//            System.out.println(emp);
//        }
//    }
@Test
public void selectEmpListCondition(){
    PageHelper.startPage(1,1,"sal desc");
    Map<String,Object> conditionMap = new HashMap<>();
    conditionMap.put("job","程序员");
    conditionMap.put("sal",3000);
    conditionMap.put("deptno",30);
    List<Emp> empList = mapper.selectEmpListCondition(conditionMap);
    for(Emp emp:empList){
        System.out.println(emp);
    }
    //分页信息
    PageInfo<Emp> info = new PageInfo<>(empList);
    int pageSize = info.getPageSize();
    long total = info.getTotal();
    int pages = info.getPages();
    System.out.println("pageSize =" + pageSize  +"====="+ "total=" + total +"++++++++++++" + "pages=" + pages);
}
@Test
public void selectDeptAndEmpByDeptnoTest2(){
       List<Dept> depts = mapper.selectDeptAndEmpByDeptno2(30);
    System.out.println(depts);
    }
    @After
    public void after(){
        if (session!=null){
            session.close();
        }
    }
}
