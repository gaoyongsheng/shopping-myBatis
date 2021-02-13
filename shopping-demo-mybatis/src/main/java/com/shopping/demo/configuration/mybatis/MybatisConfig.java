package com.shopping.demo.configuration.mybatis;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

//@Configuration
//@MapperScan("com.shopping.demo.mapper")    // 扫描DAO
public class MybatisConfig {

  @Autowired
  private DataSource dataSource;

  @Bean
  public SqlSessionFactory sqlSessionFactory() throws Exception {
    SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
    sessionFactory.setDataSource(dataSource);
    sessionFactory.setTypeAliasesPackage("com.shopping.demo.entity");    // 扫描Model
    
    PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
    //    classpath：只会到你的class路径中查找找文件;
    //    classpath*：不仅包含class路径，还包括jar文件中(class路径)进行查找.
    sessionFactory.setMapperLocations(resolver.getResources("classpath:com/shopping/demo/mapper/*.xml"));    // 扫描映射文件
    
    return sessionFactory.getObject();
  }
}