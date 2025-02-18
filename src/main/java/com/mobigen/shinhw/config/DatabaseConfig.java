package com.mobigen.shinhw.config;

import java.beans.ConstructorProperties;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.GeneralSecurityException;
import java.text.ParseException;

import javax.sql.DataSource;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@MapperScan(
    basePackages = "com.mobigen.shinhw",
    sqlSessionFactoryRef = "sqlSessionFactory"
)
@EnableTransactionManagement
public class DatabaseConfig {

    @Bean(name="dataSource")
	public DataSource dataSource() {
		return new HikariDataSource(hikariConfig());
	}

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.hikari")
	public HikariConfig hikariConfig() {
		return new HikariConfig();
	}

	@Bean(name="sqlSessionFactoryBean")
	public SqlSessionFactoryBean sqlSessionFactoryBean(@Qualifier("dataSource") DataSource datasource) throws Exception{
		SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
		sessionFactoryBean.setDataSource(datasource);
		sessionFactoryBean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:sql/config/sql-mapper-config.xml"));
		sessionFactoryBean.setTypeAliasesPackage("com.mobigen.**.model");
		sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:sql/mapper/**/*-mapper.xml"));
		return sessionFactoryBean;
	}

	@Bean(name="sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory(@Qualifier("sqlSessionFactoryBean") SqlSessionFactoryBean sqlSessionFactoryBean) throws Exception{
		return sqlSessionFactoryBean.getObject();
	}

	@Bean(name="sqlSessionFactoryBatch")
	public SqlSessionTemplate sqlSessionFactoryBatch(@Qualifier("sqlSessionFactoryBean") SqlSessionFactoryBean sqlSessionFactoryBean) throws Exception {
		return new SqlSessionTemplate(sqlSessionFactoryBean.getObject(), ExecutorType.BATCH);
	}

	@Bean(name="transactionManager")
	public PlatformTransactionManager transactionManager(@Qualifier("dataSource") DataSource datasource) throws URISyntaxException, GeneralSecurityException, ParseException, IOException {
		DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
		dataSourceTransactionManager.setDataSource(dataSource());
		return dataSourceTransactionManager;
	}
}
