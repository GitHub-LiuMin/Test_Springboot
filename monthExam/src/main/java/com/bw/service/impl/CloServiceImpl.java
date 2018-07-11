package com.bw.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bw.bean.Brand;
import com.bw.bean.Clothing;
import com.bw.mapper.CloMapper;
import com.bw.service.CloService;

@Service
public class CloServiceImpl implements CloService {

	@Resource
	private CloMapper cloMapper;

	@Override
	public List<Clothing> findCloList(String query, Integer starts, Integer rows) {
		// TODO Auto-generated method stub
		return cloMapper.findCloList(query, starts, rows);
	}

	@Override
	public Integer countCloList() {
		// TODO Auto-generated method stub
		return cloMapper.countCloList();
	}
	@Override
	public List<Brand> findBrandList() {
		// TODO Auto-generated method stub
		return cloMapper.findBrandList();
	}

	@Override
	public void saveClo(Clothing clo) {
		// TODO Auto-generated method stub
		cloMapper.saveClo(clo);
	}
	@Override
	public Clothing findOneByCid(Integer cid) {
		// TODO Auto-generated method stub
		return cloMapper.findOneByCid(cid);
	}
	@Override
	public void batchDelete(Integer id) {
		// TODO Auto-generated method stub
		cloMapper.batchDelete(id);
	}
}
