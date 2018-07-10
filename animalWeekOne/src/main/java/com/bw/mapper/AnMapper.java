package com.bw.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bw.bean.Animal;

/**
 * 
 * <br>Title:TODO 类标题
 * <br>Description:TODO 持久层
 * <br>Author:杨国庆
 * <br>Date:2018年7月9日
 */
public interface AnMapper {

  List<Animal> findAnimalList(@Param("starts") Integer starts, @Param("rows") Integer rows);

  Integer countAnimal();

  List findRange();

  void batchDeleteByAnimal(Integer id);

  void batchDeleteByA_R(Integer id);

  void save(Animal a);

  void saveA_R(@Param("aid") Integer aid, @Param("rid") Integer rid);
}
