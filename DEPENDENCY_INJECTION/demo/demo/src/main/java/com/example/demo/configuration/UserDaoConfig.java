package com.example.demo.configuration;

import com.example.demo.dao.UserDao;
import com.example.demo.model.User;
import org.redisson.Redisson;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.io.File;
import java.io.IOException;

@Configuration
public class UserDaoConfig {

    private static final String REDISSON_R_MAP_NAME = "pritish-free-db";

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public RedissonClient getRedissonClient() throws IOException {
        Config config = Config.fromJSON(new File("config/RedisConfig.json"));
        return Redisson.create(config);
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public RMap<String, User> getRedissonRMap(final RedissonClient redissonClient) {
        return redissonClient.getMap(REDISSON_R_MAP_NAME);
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public UserDao getUserDao(final RMap<String, User> rMap) {
        return new UserDao(rMap);
    }
}
