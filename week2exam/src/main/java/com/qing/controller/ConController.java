package com.qing.controller;

import com.qing.Bean.Company;
import com.qing.Bean.Guo;
import com.qing.service.ConService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: week2exam
 * @description: 控制层
 * @author: 杨国庆
 * @create：2018-07-16 08:46
 **/

@Controller
@RequestMapping("qing")
public class ConController {


    @Autowired
    private ConService conService;


    /** 
      * @Description: 初始化页面 
      * @Param:  
      * @return:  
      * @Author: Mr.Yang
      * @Date: 2018/7/16 
      */ 
    @RequestMapping("init")
    public String init(){

        return "list";
    }

    /**
      * @Description: 列表
      * @Param:  page,rows
      * @return: list
      * @Author: Mr.Yang
      * @Date: 2018/7/16
      */
    @RequestMapping("list")
    @ResponseBody
    public Map findConList(Integer page,Integer rows){
        if (page == null) {
            page=1;
        }
        if (rows == null) {
            rows=10;
        }
        Integer starts = (page-1)*rows;
        List<Company> list = conService.findComList(starts,rows);
        Integer total = conService.countCom();
        Map m = new HashMap<String, Object>();
        m.put("rows", list);
        m.put("total", total);
        return m;

    }


    /**
      * @Description: 查询所有的国家
      * @Param:
      * @return:  list
      * @Author: Mr.Yang
      * @Date: 2018/7/16
      */
    @ResponseBody
    @RequestMapping("toSave")
    public List<Guo> findGuoList(){

        List<Guo> list = conService.findGuoList();
        return list;
    }


    /**
      * @Description: 添加
      * @Param:  com
      * @return:  boolean
      * @Author: Mr.Yang
      * @Date: 2018/7/16
      */
    @ResponseBody
    @RequestMapping("save")
    public boolean save(Company com){

        conService.addcom(com);
        return true;
    }

    /**
      * @Description: 批量删除
      * @Param:  ids
      * @return:  boolean
      * @Author: Mr.Yang
      * @Date: 2018/7/16
      */
    @ResponseBody
    @RequestMapping("batchDelete")
    public boolean batchDelete(String ids){
        System.out.println("删除的数据为==============="+ids);
        String[] split = ids.split(",");
        for (String s : split) {
            Integer id = Integer.parseInt(s);
            System.out.println("删除的id为========="+id);
            conService.batchDelete(id);
        }
        return true;
    }
}
