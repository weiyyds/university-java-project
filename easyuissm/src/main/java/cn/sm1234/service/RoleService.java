package cn.sm1234.service;

import cn.sm1234.entity.EasyUIDatagrid;
import cn.sm1234.entity.Menu;
import cn.sm1234.entity.Role;

import java.util.List;

public interface RoleService {
    EasyUIDatagrid showRole(int pageSize,int pageNumber);

    //修改角色信息
    int updateRole(Role role);

    List<Menu> showPrivilege(int roleid);
}
