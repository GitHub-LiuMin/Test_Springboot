package com.bw.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bw.bean.Brand;
import com.bw.bean.Clothing;
import com.bw.service.CloService;
import com.bw.utils.FreeMarkerUtil;
import com.bw.utils.RedisUtil;

@Controller
@RequestMapping("qing")
public class CloController {

	@Resource
	private CloService cloService;
	
	
	/**
	 * 
	 * @return  初始化
	 */
	@RequestMapping("init")
	public String init() {
		
		return "list";
	}
	
	
	@RequestMapping("/list")
	@ResponseBody
	public Map list(String query,Integer page,Integer rows) {
		if(query==null) {
			query="";
		}
		if(page==null) {
			page=1;
		}
		if(rows==null) {
			rows=10;
		}
		Integer starts = (page-1)*rows;
		System.out.println("当前页是============"+starts);
		
		List<Clothing> list = cloService.findCloList(query,starts,rows);
		System.out.println("列表数据============"+list);
		
		Integer total = cloService.countCloList();
		System.out.println("列表条数============"+total);
		
		Map m = new HashMap<>();
		
		m.put("total", total);
		m.put("rows", list);
		
		return m;
	}
	
	@RequestMapping("toSave")
	@ResponseBody
	public List toSave() {
		Object obj = RedisUtil.getRedis("brandList");
		if(obj==null) {
			System.out.println("品牌数据从数据库查询==");
			List<Brand> list = cloService.findBrandList();
			RedisUtil.setRedis("brandList", list);
			return  list ;
		}else {
			System.out.println("品牌数据从redis查询==");
			return (List) obj;
		}
	}
	
	
	
	/**
	 * 
	 * @param clo
	 * @return 添加
	 */
	@RequestMapping("save")
	@ResponseBody
	public boolean save(Clothing clo,HttpServletRequest req) {
		cloService.saveClo(clo);
		System.out.println("添加的数据为======"+clo);
		Clothing c = cloService.findOneByCid(clo.getCid());
		System.out.println("查询一条的数据为======"+c);
		Map m = new HashMap<>();
		m.put("id", c.getCid());
		m.put("cname", c.getCname());
		m.put("price", c.getPrice());
		m.put("bname", c.getBname());
		FreeMarkerUtil.generateHtml(req.getServletContext(), "html", "clo.ftl", m);
		return true;
	}
	
	/**
	 * 
	 * @param ids
	 * @return 批量删除
	 */
	@RequestMapping("batchDelete")
	@ResponseBody
	public boolean batchDelete(String ids) {
		System.out.println("要删除的ids是===="+ids);
		String[] split = ids.split(",");
		for (String id2 : split) {
			Integer id = Integer.parseInt(id2);
			cloService.batchDelete(id);
		}
		return true;
	}
	
	
}
