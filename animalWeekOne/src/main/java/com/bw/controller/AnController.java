package com.bw.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bw.bean.Animal;
import com.bw.service.AnService;

@RequestMapping("qing")
@Controller
/**
 * 
 * <br>Title:TODO 控制层
 * <br>Description:TODO 类功能描述
 * <br>Author:杨国庆
 * <br>Date:2018年7月9日
 */
public class AnController {

  @Autowired
  private AnService anService;

  @RequestMapping("init")
  public String init() {

    return "list";
  }

  /**
   * 
   * <br>Description:TODO 列表
   * <br>Author:杨国庆
   * <br>Date:2018年7月9日
   * @param page
   * @param rows
   * @return
   */
  @RequestMapping("list")
  @ResponseBody
  public Map findAnimalList(Integer page, Integer rows) {
    Map map = new HashMap<>();
    if (page != null) {
      page = 1;
    }
    if (rows != null) {
      rows = 10;
    }
    Integer starts = (page - 1) * rows;

    List<Animal> list = anService.findAnimalList(starts, rows);

    Integer total = anService.countAnimal();
    map.put("rows", list);
    map.put("total", total);
    return map;
  }

  /**
   * 
   * <br>Description:TODO 查询范围表用来动态生成
   * <br>Author:杨国庆
   * <br>Date:2018年7月9日
   * @return
   */
  @ResponseBody
  @RequestMapping("toSave")
  public List findRange() {

    return anService.findRange();
  }

  /**
   * 
   * <br>Description:TODO 保存
   * <br>Author:杨国庆
   * <br>Date:2018年7月9日
   * @param a
   * @return
   */
  @ResponseBody
  @RequestMapping("save")
  public boolean saveAnimal(Animal a) {

    System.out.println("接到的数据为====" + a);
    anService.save(a);
    System.out.println("添加Animal后接到的数据为====" + a);
    String rids = a.getRid();
    String[] split = rids.split(",");
    for (String ids : split) {
      Integer rid = Integer.parseInt(ids);
      Integer aid = a.getAid();
      anService.saveA_R(aid, rid);
    }
    return true;
  }

  /**
   * 
   * <br>Description:TODO 批量删除
   * <br>Author:杨国庆
   * <br>Date:2018年7月9日
   * @param ids
   * @return
   */
  @ResponseBody
  @RequestMapping("batchDelete")
  public boolean batchDelete(String ids) {

    if (ids != null) {
      System.out.println("接到的数据为====" + ids);
      String[] split = ids.split(",");
      for (String idss : split) {
        Integer id = Integer.parseInt(idss);
        anService.batchDelete(id);
      }
    }

    return true;
  }

}
