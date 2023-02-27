package com.itheima.test;

import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBrandTest {

    @Test
    public void testselectAll() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        List<Brand> brands = brandMapper.selectAll();

        System.out.println(brands);
        sqlSession.close();

    }

    @Test
    public void testselectById() throws IOException {
        int id=1;
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        Brand brand = brandMapper.selectById(id);

        System.out.println(brand);
        sqlSession.close();

    }

    @Test
    public void testselectByCondition() throws IOException {
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

        //处理参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.获取Mapper接口的代理对象

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = brandMapper.selectByCondition(status, companyName, brandName);

        System.out.println(brands);
        sqlSession.close();

    }

    @Test
    public void testSelectByConditionSingle() throws IOException {
//接收参数
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";
// 处理参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";
//封装对象
        Brand brand = new Brand();
//brand.setStatus(status);
        brand.setCompanyName(companyName);
//brand.setBrandName(brandName);
//1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
//3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
//4. 执行方法
        List<Brand> brands = brandMapper.selectByConditionSingle(brand);
        System.out.println(brands);
//5. 释放资源
        sqlSession.close();
    }

    @Test
    public void testAdd() throws IOException {
//接收参数
        int status = 1;
        String companyName = "波导手机";
        String brandName = "波导";
        String description= "手机中的战斗机";
        int ordered = 100;
// 处理参数

//封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(ordered);
        //brand.setBrandName(brandName);
        //1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //4. 执行方法
        brandMapper.add(brand);
        //提交事务
        sqlSession.commit();
        //5. 释放资源
        sqlSession.close();
    }

    @Test
    public void testUpdate() throws IOException {
    //接收参数
        int status = 0;
        String companyName = "波导手机";
        String brandName = "波导";
        String description= "手机中的战斗机";
        int ordered = 200;
        int id = 6;
    // 处理参数

    //封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
       //brand.setCompanyName(companyName);
        //brand.setBrandName(brandName);
        //brand.setDescription(description);
        //brand.setOrdered(ordered);
        //brand.setBrandName(brandName);
        brand.setId(id);
        //1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //4. 执行方法
        int count = brandMapper.update(brand);
        System.out.println(count);
        //5. 释放资源
        sqlSession.close();
    }

    @Test
    public void testDelete() throws IOException {
    //接收参数
        int id = 5;
    // 处理参数

    //封装对象
        Brand brand = new Brand();
        //brand.setCompanyName(companyName);
        //brand.setBrandName(brandName);
        //brand.setDescription(description);
        //brand.setOrdered(ordered);
        //brand.setBrandName(brandName);
        brand.setId(id);
        //1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //4. 执行方法
        brandMapper.deleteById(id);
        //提交事务
        sqlSession.commit();
        //5. 释放资源
        sqlSession.close();
    }

    @Test
    public void testDeleteIds() throws IOException {
        //接收参数
        int[] ids = {1,2,3};
        // 处理参数

        //封装对象
        Brand brand = new Brand();
        //brand.setCompanyName(companyName);
        //brand.setBrandName(brandName);
        //brand.setDescription(description);
        //brand.setOrdered(ordered);
        //brand.setBrandName(brandName);
        //1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //4. 执行方法
        brandMapper.deleteByIds(ids);
        //提交事务
        sqlSession.commit();
        //5. 释放资源
        sqlSession.close();
    }
}
