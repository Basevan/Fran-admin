package com.basevan.goss.common.response;

import lombok.Data;

import java.util.List;

/**
 * <p></p>
 *
 * @Author: basevan.tang   2019/11/25
 */
@Data
public class NavigationBarDTO {
    private int index;
    private String address;
    private String name;
    private List<NavigationBarDTO> children;
}
