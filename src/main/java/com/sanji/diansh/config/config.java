package com.sanji.diansh.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.QueryLookupStrategy.Key;

/**
 * 修改查询策略
 * @author lixiaoyan
 *
 */
@Configuration
@EnableJpaRepositories(basePackages = {"com.sanji.diansh.repository"},queryLookupStrategy =Key.USE_DECLARED_QUERY)
public class config {

}
