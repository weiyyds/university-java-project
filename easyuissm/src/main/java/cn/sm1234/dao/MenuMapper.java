package cn.sm1234.dao;

import cn.sm1234.entity.Menu;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MenuMapper {
    List<Menu> selAll();
    List<Menu> selByPwd(int pwd);
    //这里查询一级菜单
    List<Menu> selByPid(@Param("pwd") int pwd);
    //这里查询二级菜单
    List<Menu> selByPidRid(@Param("pid") int pid,@Param("roleid") int roleid);
}
