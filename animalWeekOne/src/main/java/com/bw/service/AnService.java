package com.bw.service;

import java.util.List;

import com.bw.bean.Animal;

/**
 * 
 * <br>Title:TODO Service接口
 * <br>Description:TODO 类功能描述
 * <br>Author:杨国庆
 * <br>Date:2018年7月9日
 */
public interface AnService {

  List<Animal> findAnimalList(Integer starts, Integer rows);

  Integer countAnimal();

  List findRange();

  void batchDelete(Integer id);

  void save(Animal a);

  void saveA_R(Integer aid, Integer rid);

}
