package com.github.spring.boot.dome.mybatis;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.spring.boot.dome.entity.SysUser;
import com.github.spring.boot.dome.mapper.SysUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @program: spring-boot-dome
 * @description: test
 * @author: Jamie
 * @create: 2019-03-04 15:31
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
public class DomeMybatisTest {

    @Autowired
    private SysUserMapper  sysUserMapper;

    @Test
    public void testSelectAll(){
      List<SysUser> sysUsers = sysUserMapper.selectAll();
        for (SysUser sysUser: sysUsers) {
            System.out.println("UserName:"+sysUser.getUsername());
        }
    }
    @Test
    public void testPage(){
        //设置页码和总数
        PageHelper.startPage(0,10);
        //设置分页查询条件
        Example example = new Example(SysUser.class);
        example.createCriteria().andEqualTo("username","pig");
        PageInfo<SysUser> pageInfo = new PageInfo<>(sysUserMapper.selectByExample(example));
        //获取结果
        List<SysUser> userList = pageInfo.getList();
        for (SysUser sysUser : userList) {
            System.out.println("Page.UserName:"+sysUser.getUsername());
        }
    }
}
