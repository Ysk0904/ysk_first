package com.itheima.mapper;

import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {

    /*
    *查询所有
     */
    List<Brand> selectAll();

    /*
    查看详情
     */
    Brand selectById( int id);

    /*
    条件查询
    @
     */

    List<Brand> selectByCondition(@Param("status") int status, @Param("companyName") String
            companyName, @Param("brandName") String brandName);


    List<Brand> selectByConditionSingle(Brand brand);

    void add(Brand brand);

    int update(Brand brand);

    /*
    根据id删除
     */
    void deleteById(int id);

    /*
    批量删除
     */
    void deleteByIds(int[] ids);
}
