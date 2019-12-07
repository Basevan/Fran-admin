package com.basevan.goss.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.basevan.goss.biz.MenuService;
import com.basevan.goss.common.request.MenuQueryVO;
import com.basevan.goss.common.response.MenuDTO;
import com.basevan.goss.common.utils.ResultUtils;
import com.basevan.goss.controller.utils.MenuUtil;
import com.basevan.goss.dao.entity.MenuDO;
import com.basevan.goss.dao.mapper.MenuMapper;
import org.checkerframework.framework.qual.RequiresQualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p></p>
 *
 * @Author: basevan.tang   2019/11/25
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/goss")
public class PageController {

    private MenuService menuService;

    @Autowired
    public PageController(MenuService menuService){

        this.menuService = menuService;
    }

    @RequestMapping("/getData")
    public JSONObject getData(){
        //获取全部数据
        List<Map<String,Object>> list = menuService.getAllDataDistinct();
        //规范返回数据格式
        return ResultUtils.success(menuService.getAllMenu(list,"0"));
    }

    public void getAll(){
        menuService.getAllData().forEach(System.out::println);
    }

    @RequestMapping("/add")
    public void addMenu(MenuQueryVO menuQueryVO){
        System.out.println(MenuUtil.transformToMenuDO(menuQueryVO));
    }
}
