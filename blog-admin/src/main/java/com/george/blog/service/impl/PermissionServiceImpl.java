package com.george.blog.service.impl;

import com.george.blog.mapper.PermissionMapper;
import com.george.blog.pojo.PageDTO;
import com.george.blog.pojo.PageResultDTO;
import com.george.blog.pojo.PermissionPO;
import com.george.blog.pojo.ResultVO;
import com.george.blog.service.IPermissionService;

/**
 * @description 权限service实现类
 * @author georgeLin
 * @date 2022-02-27-22:19
 */
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public ResultVO listPermission(PageDTO pageDTO){
        Page<PermissionPO> page = new Page<>(pageDTO.getCurrentPage(),pageDTO.getPageSize());
        LambdaQueryWrapper<PermissionPO> queryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(pageDTO.getQueryString())) {
            queryWrapper.eq(PermissionPO::getName,pageDTO.getQueryString());
        }
        Page<PermissionPO> permissionPage = this.permissionMapper.selectPage(page, queryWrapper);
        PageResultDTO<PermissionPO> pageResult = new PageResultDTO<>();
        pageResult.setList(permissionPage.getRecords());
        pageResult.setTotal(permissionPage.getTotal());
        return ResultVO.success(pageResult);
    }

    @Override
    public ResultVO add(PermissionPO permission) {
        this.permissionMapper.insert(permission);
        return ResultVO.success(null);
    }

    @Override
    public ResultVO update(PermissionPO permission) {
        this.permissionMapper.updateById(permission);
        return ResultVO.success(null);
    }

    @Override
    public ResultVO delete(Long id) {
        this.permissionMapper.deleteById(id);
        return ResultVO.success(null);
    }
}
