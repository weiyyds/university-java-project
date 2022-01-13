package cn.sm1234.dao;

import cn.sm1234.entity.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public interface RoleMapper {
    List<Role> selByPage(@Param("pageStart")int pageStart,@Param("rows")int pageSize);

    int selCount();

    //修改角色信息
    int updateRole(Role role);
}
