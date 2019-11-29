package com.basevan.goss.common.response;

import com.baomidou.mybatisplus.annotation.TableName;
import com.basevan.goss.dao.entity.MenuDO;
import com.basevan.goss.dao.entity.NavigationBar;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p></p>
 *
 * @Author: basevan.tang   2019/11/25
 */
@Data
public class MenuDTO implements Serializable {

    public static final long serialVersionUID = 1L;

    private long id;
    private long pid;
//    private int sort;
//    private int type;
    private String domain;
    private String uri;
    private String name;
//    private String icon;
    private static List<MenuDTO> menu = new ArrayList<>();

    public MenuDTO(MenuDO menuDO){
        this.id = menuDO.getId();
        this.pid = menuDO.getPid();
        this.domain = menuDO.getDomain();
        this.name = menuDO.getName();
        this.uri = menuDO.getUri();
    }

//    public MenuDTO(MenuDTO menuDTO){
//        this.menu.add(menuDTO);
//    }
//
    public void addChildren(MenuDTO menuDTO){
        this.menu.add(menuDTO);
    }


}
