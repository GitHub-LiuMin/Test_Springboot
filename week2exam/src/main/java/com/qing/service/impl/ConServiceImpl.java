package com.qing.service.impl;

import com.google.gson.Gson;
import com.qing.Bean.Company;
import com.qing.Bean.Guo;
import com.qing.Provider;
import com.qing.mapper.ConMapper;
import com.qing.service.ConService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: week2exam
 * @description: 业务层
 * @author: 杨国庆
 * @create：2018-07-16 08:48
 **/
@Service
public class ConServiceImpl implements ConService {

    @Autowired(required = false)
    private ConMapper conMapper;

    @Override
    public List<Company> findComList(Integer starts, Integer rows) {
        return conMapper.findComList(starts,rows);
    }

    @Override
    public Integer countCom() {
        return conMapper.countCom();
    }

    @Override
    public List<Guo> findGuoList() {
        return conMapper.findGuoList();
    }


    @Override
    public void batchDelete(Integer id) {
        conMapper.deleteByComPany(id);
        conMapper.deleteByC_G(id);
    }

    @Override
    public void addcom(Company com) {
        Gson gson = new Gson();
        String co = gson.toJson(com);
        Provider.send(co);
    }

}
