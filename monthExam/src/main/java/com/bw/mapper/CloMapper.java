package com.bw.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bw.bean.Brand;
import com.bw.bean.Clothing;

public interface CloMapper {
	
	List<Clothing> findCloList(@Param("query")String query,@Param("starts") Integer starts,@Param("rows") Integer rows);

	Integer countCloList();

	List<Brand> findBrandList();
	
	void saveClo(Clothing clo);

	Clothing findOneByCid(@Param("cid")Integer cid);
	
	void batchDelete(@Param("id")Integer id);
}
