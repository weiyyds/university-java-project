package cn.sm1234.service;

import cn.sm1234.dao.MenuMapper;
import cn.sm1234.entity.Attributes;
import cn.sm1234.entity.Menu;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService{
    @Resource
    private MenuMapper menuMapper;

    @Override
    public List<Menu> selAll() {
        List<Menu> list=menuMapper.selAll();
        for (Menu menu:list){
            List<Menu> listChildren=menuMapper.selByPwd(menu.getId());
            for (Menu child:listChildren) {
                Attributes attr = new Attributes();
                attr.setFileName(child.getFileName());
                child.setAttributes(attr);
            }
            menu.setChildren(listChildren);
        }
        return list;
    }


}
