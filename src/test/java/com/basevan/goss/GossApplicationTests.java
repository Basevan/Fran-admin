package com.basevan.goss;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.basevan.goss.biz.MenuService;
import com.basevan.goss.common.request.MenuQueryVO;
import com.basevan.goss.common.response.MenuDTO;
import com.basevan.goss.common.utils.ResultUtils;
import com.basevan.goss.controller.PageController;
import com.basevan.goss.dao.entity.MenuDO;
import com.basevan.goss.dao.mapper.MenuMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@SpringBootTest(classes = GossApplication.class)
class GossApplicationTests {

    private PageController pageController;

    private MenuMapper menuMapper;

    private MenuService menuService;

    @Autowired
    public GossApplicationTests(PageController pageController,MenuMapper menuMapper,MenuService menuService){
        this.pageController = pageController;
        this.menuMapper = menuMapper;
        this.menuService = menuService;
    }

    //controller层测试
    @Test
    void contextLoads() {
//        List<Map<String,Object>> list = pageController.getData();
//        list.forEach(System.out::println);
//        List<Map<String,Object>> list1 = list.stream().filter(me -> ((long)me.get("pid")) == 0).collect(Collectors.toList());
//        //.forEach(System.out::println)
//
//        List<Map<String,Object>> list2 = list.stream().filter(me -> ((long)me.get("pid")) != 0).collect(Collectors.toList());

//        pageController.getAll();
       //.forEach(System.out::println)
        pageController.getData();
    }

    //mapper层测试
    @Test
    void testGetData(){
        System.out.println(menuMapper.selectList(new QueryWrapper<MenuDO>().lambda().and( me -> me.eq(MenuDO::getId,1))).toString());
    }

    //service层测试
    @Test
    void testService(){
//        List<MenuDO> list = menuMapper.selectList(null);
//        menuService.getAllMenu();
//        List<MenuDTO> list = menuService.getAllMenu();
    }

    @Test
    void testMapper(){

    }

    @Test
    public void testTransfer(){
        MenuQueryVO menuQueryVO = new MenuQueryVO();
        menuQueryVO.setDomain("www.baidu.com");
        menuQueryVO.setIcon("el-icon-search");
        menuQueryVO.setName("角色管理");
        menuQueryVO.setType(1);
        menuQueryVO.setUri("/");
        pageController.addMenu(menuQueryVO);
    }
}
