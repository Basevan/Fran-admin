package com.basevan.goss.controller.utils;

import com.basevan.goss.common.request.MenuQueryVO;
import com.basevan.goss.common.utils.BeanUtil;
import com.basevan.goss.dao.entity.MenuDO;

/**
 * <p></p>
 *
 * @Author: basevan.tang   2019/12/7
 */
public class MenuUtil {

    public static MenuDO transformToMenuDO(MenuQueryVO menuQueryVO){
        if (null == menuQueryVO){
            return null;
        }
        MenuDO menuDO = new MenuDO();
        BeanUtil.copyProperties(menuQueryVO,menuDO);
        return menuDO;
    }
}
