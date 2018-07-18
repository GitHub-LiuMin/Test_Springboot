package com.qing.mapper;

import com.qing.Bean.Company;
import com.qing.Bean.Guo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ConMapper {


    @Select("SELECT  c.*,group_concat(g.gid) gid,group_concat(g.gname) gname\n" +
            "  FROM company c LEFT JOIN c_g m on c.cid=m.cid\n" +
            "  LEFT JOIN guo g on g.gid=m.gid \n" +
            "GROUP BY c.cid limit #{starts},#{rows}")
    List<Company> findComList(@Param("starts") Integer starts, @Param("rows")Integer rows);

    @Select("SELECT  count(1)\n" +
            "FROM company c LEFT JOIN c_g m on c.cid=m.cid\n" +
            "  LEFT JOIN guo g on g.gid=m.gid")
    Integer countCom();

    @Select("SELECT  * from guo")
    List<Guo> findGuoList();

    @Insert("insert into company(cname,type) values(#{cname},#{type})")
    @Options(useGeneratedKeys = true,keyProperty = "cid")
    void save(Company com);

    @Insert("insert into c_g(cid,gid) values(#{cid},#{gid}) ")
    void saveMid(@Param("cid") Integer cid,@Param("gid") Integer gid);

    @Delete("delete from company where cid = #{id}")
    void deleteByComPany(@Param("id") Integer id);

    @Delete("delete from c_g where cid = #{id}")
    void deleteByC_G(@Param("id")Integer id);
}
