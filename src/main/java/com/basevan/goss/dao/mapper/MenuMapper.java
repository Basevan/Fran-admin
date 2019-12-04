package com.basevan.goss.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.basevan.goss.dao.entity.MenuDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p></p>
 *
 * @Author: basevan.tang   2019/11/27
 */
@Mapper
@Repository
public interface MenuMapper extends BaseMapper<MenuDO> {

}
