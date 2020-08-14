package com.tongji.service;

import com.tongji.dao.AdminDao;
import com.tongji.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ryan
 * @date 2020/8/13 18:56
 */
@Service
public class AdminService {
    @Autowired()
    private AdminDao adminDao;

    public List<Admin> findAll(){
        return adminDao.selectList(null);
    }

}
