package com.qing;

import com.google.gson.Gson;
import com.qing.Bean.Company;
import com.qing.mapper.ConMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: week2exam
 * @description: 消费者
 * @author: 杨国庆
 * @create：2018-07-16 08:47
 **/

public class Consumer {

    @Autowired(required = false)
    private ConMapper conMapper;

    public void read(Object message){

        Gson gson = new Gson();
        Company com = gson.fromJson(message.toString(), Company.class);
        System.out.println(com);
        //添加主表信息
        conMapper.save(com);
        //添加主表返回信息
        System.out.println("添加主表返回==========="+com);
        String[] split = com.getGid().split(",");
        for (String gids  : split) {
            Integer gid = Integer.parseInt(gids);
            System.out.println(gid);
            Integer cid = com.getCid();
            System.out.println(cid);
            conMapper.saveMid(cid,gid);
        }
    }
}
