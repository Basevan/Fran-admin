package com.basevan.goss.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * <p></p>
 *
 * @Author: basevan.tang   2019/11/27
 */
@TableName("menu")
@Data
public class MenuDO {
    private long id;
    private long pid;
    private int sort;
    private int type;
    private String domain;
    private String uri;
    private String name;
    private String icon;
}
