package cn.sm1234.service;

import cn.sm1234.dao.MenuMapper;
import cn.sm1234.dao.RoleMapper;
import cn.sm1234.entity.EasyUIDatagrid;

import cn.sm1234.entity.Menu;
import cn.sm1234.entity.Role;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{
    @Resource
    private RoleMapper roleMapper;
    @Resource
    private MenuMapper menuMapper;
    @Override
    public EasyUIDatagrid showRole(int pageSize, int pageNumber) {
        EasyUIDatagrid datagrid=new EasyUIDatagrid();
        datagrid.setRows(roleMapper.selByPage(pageSize*(pageNumber-1),pageSize));
        datagrid.setTotal(roleMapper.selCount());
        return datagrid;
    }

    @Override
    public int updateRole(Role role) {
        return roleMapper.updateRole(role);
    }

    @Override
    public List<Menu> showPrivilege(int roleid) {
        List<Menu> listParent = menuMapper.selByPidRid(0, roleid);
        List<Menu> listRole =new ArrayList<>();
        for (Menu menu:listParent){
            listRole.addAll(menuMapper.selByPidRid(menu.getId(),roleid));

        }
        List<Menu> listAll = menuMapper.selAll();
        for (Menu menu:listAll){
            //一级菜单
           /* for (Menu parent:listParent) {
                if (parent.getId()==menu.getId()){
                    menu.setChecked(true);
                }
            }*/
            //二级菜单
            List<Menu> listChildren = menuMapper.selByPid(menu.getId());
            for (Menu menu1:listChildren) {
                for (Menu menu2:listRole){
                    if (menu2.getId()==menu1.getId()){
                        menu1.setChecked(true);
                    }
                }
            }
            menu.setChildren(listChildren);


        }
        return listAll;
    }
}
