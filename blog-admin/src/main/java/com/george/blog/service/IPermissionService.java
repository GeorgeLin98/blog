package com.george.blog.service;

import com.george.blog.pojo.PageDTO;
import com.george.blog.pojo.PermissionPO;
import com.george.blog.pojo.ResultVO;

/**
 * @description 权限service接口
 * @author georgeLin
 * @date 2022-02-27-22:19
 */
public interface IPermissionService {
    /**
     * @description 查询权限列表
     * @author linzuangze
     * @date 2022.02.27
     * @param pageDTO
     * @return
     */
    ResultVO listPermission(PageDTO pageDTO);

    /**
     * @descripion 新增权限
     * @author linzuangze
     * @date 2022.02.27
     * @param permission
     * @return
     */
    ResultVO add(PermissionPO permission);

    /**
     * @description 更新权限
     * @author linzuangze
     * @date 2022.02.27
     * @author linzuangze
     * @date 2022.02.27
     * @param permission
     * @return
     */
    ResultVO update(PermissionPO permission);

    /**
     * @description 删除权限
     * @author linzuangze
     * @date 2022.02.27
     * @param id
     * @return
     */
    ResultVO delete(Long id);
}
