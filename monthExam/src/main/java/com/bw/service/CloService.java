package com.bw.service;

import java.util.List;

import com.bw.bean.Brand;
import com.bw.bean.Clothing;

public interface CloService {

	List<Clothing> findCloList(String query, Integer starts, Integer rows);

	Integer countCloList();

	List<Brand> findBrandList();

	void saveClo(Clothing clo);

	Clothing findOneByCid(Integer cid);

	void batchDelete(Integer id);

}
