package com.basevan.goss.common.request;

import lombok.Data;

import java.io.Serializable;

/**
 * <p></p>
 *
 * @Author: basevan.tang   2019/11/27
 */
@Data
public class MenuQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 0目录 1菜单
     */
    private Integer type;

    /**
     * 完整的域名
     */
    private String domain;

    /**
     * 路由/权限限定符，子菜单需要包含父路由
     */
    private String uri;

    private String name;

    /**
     * icon地址
     */
    private String icon;
}
