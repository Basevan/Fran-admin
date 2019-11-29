package com.basevan.goss.biz;

import com.basevan.goss.common.response.MenuDTO;
import com.basevan.goss.dao.entity.MenuDO;

import java.util.List;
import java.util.Map;

/**
 * <p></p>
 *
 * @Author: basevan.tang   2019/11/27
 */
public interface MenuService {

    MenuDO getMenuById(long id);

    List<Map<String,Object>> getAllData();

    List<Map<String, Object>> getAllDataDistinct();

    List<Map<String,Object>> getAllMenu(List<Map<String, Object>> paramList, String parentId);
}
