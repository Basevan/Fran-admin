package com.basevan.goss.biz.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.basevan.goss.biz.MenuService;
import com.basevan.goss.dao.entity.MenuDO;
import com.basevan.goss.dao.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p></p>
 *
 * @Author: basevan.tang   2019/11/27
 */
@Service
public class MenuServiceImpl implements MenuService {

    private JdbcTemplate jdbcTemplate;
    private MenuMapper menuMapper;

    @Autowired
    public MenuServiceImpl(MenuMapper menuMapper,JdbcTemplate jdbcTemplate){
        this.menuMapper = menuMapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 根据id查询
     * @param id 菜单id
     */
    @Override
    public MenuDO getMenuById(long id) {
        return menuMapper.selectById(1);
    }

    @Override
    public List<Map<String, Object>> getAllData() {
        List<Map<String,Object>> list = menuMapper.selectMaps(null);
        return list;
    }

    @Override
    public List<Map<String, Object>> getAllDataDistinct() {
        //获取全部数据，并转化成List<Map<>>形式
        List<Map<String,Object>> list = menuMapper.selectMaps(null);
        //删除不是目录无父结点的项
        list.removeIf(map -> (long)map.get("pid") == 0 && (boolean)map.get("type") == true );
        return list;
    }

    /**
     * 查询所有菜单
     * @return
     */
    @Override
    public List<Map<String, Object>> getAllMenu(List<Map<String, Object>> paramList, String parentId) {
        List<Map<String,Object>> resultList = new ArrayList<>();
        for (Map<String,Object> map : paramList ) {
            String pid = map.get("pid") == null ? "" : map.get("pid").toString();
            if( parentId.equals(pid)){
                Map<String, Object> childNode = new HashMap<String, Object>();
                childNode.put("index", map.get("id"));
                childNode.put("domain", map.get("domain"));
                childNode.put("icon", map.get("icon"));
                childNode.put("name", map.get("name"));
                childNode.put("uri", map.get("uri"));
                childNode.put("type",map.get("type"));
                childNode.put("children", getAllMenu(paramList, map.get("id").toString()));
                resultList.add(childNode);
            }
        }
        return JSONObject.parseObject(JSON.toJSONString(resultList).replace(",\"children\":[]", ""), new TypeReference<List<Map<String, Object>>>(){});
    }
}
