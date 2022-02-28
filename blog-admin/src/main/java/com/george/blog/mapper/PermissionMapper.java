package com.george.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.george.blog.pojo.PermissionPO;

import java.util.List;

/**
 * @description 权限mapper
 * @author georgeLin
 * @date 2022-02-27-22:21
 */
public interface PermissionMapper  extends BaseMapper<PermissionPO> {
    /**
     * 根据后台用户id查询出所拥有的权限
     * @date 2022.02.28
     * @author linzhuangze
     * @param adminId
     * @return
     */
    List<PermissionPO> findPermissionsByAdminId(Long adminId);
}
