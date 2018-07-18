package com.qing.service;

import com.qing.Bean.Company;
import com.qing.Bean.Guo;

import java.util.List;

public interface ConService {
    List<Company> findComList(Integer starts, Integer rows);

    Integer countCom();

    List<Guo> findGuoList();


    void batchDelete(Integer id);

    void addcom(Company com);
}
