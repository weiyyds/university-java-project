package com.kuang.dao;

import com.kuang.entity.Admin;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDao extends BaseDao {

    public Admin login(String name , String password){
        String sql = "select * from admin where name = '" + name + "' and password = '" + password + "'";
        ResultSet resultSet = query(sql);
        try {
            if(resultSet.next()){
                Admin admin = new Admin();
                admin.setAid(resultSet.getInt("aid"));
                admin.setName(resultSet.getString("name"));
                admin.setPassword(resultSet.getString("password"));
                admin.setStatus(resultSet.getInt("status"));
                return admin;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    public boolean editPassword(Admin admin,String newPassword) {
        // TODO Auto-generated method stub
        String sql = "update admin set password = '"+newPassword+"' where id = " + admin.getAid();
        return update(sql);
    }
}

