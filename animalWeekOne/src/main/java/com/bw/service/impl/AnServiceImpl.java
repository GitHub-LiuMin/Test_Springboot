package com.bw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bw.bean.Animal;
import com.bw.mapper.AnMapper;
import com.bw.service.AnService;

/**
 * 
 * <br>Title:TODO 类标题
 * <br>Description:TODO 业务层
 * <br>Author:杨国庆
 * <br>Date:2018年7月9日
 */
@Service
public class AnServiceImpl implements AnService {

  @Autowired
  private AnMapper anMapper;

  @Override
  public List<Animal> findAnimalList(Integer starts, Integer rows) {
    // TODO Auto-generated method stub
    return anMapper.findAnimalList(starts, rows);
  }

  @Override
  public Integer countAnimal() {
    // TODO Auto-generated method stub
    return anMapper.countAnimal();
  }

  @Override
  public List findRange() {
    // TODO Auto-generated method stub
    return anMapper.findRange();
  }

  @Override
  public void batchDelete(Integer id) {
    // TODO Auto-generated method stub
    anMapper.batchDeleteByA_R(id);
    anMapper.batchDeleteByAnimal(id);
  }

  @Override
  public void save(Animal a) {
    // TODO Auto-generated method stub
    anMapper.save(a);
  }

  @Override
  public void saveA_R(Integer aid, Integer rid) {
    // TODO Auto-generated method stub
    anMapper.saveA_R(aid, rid);
  }
}
