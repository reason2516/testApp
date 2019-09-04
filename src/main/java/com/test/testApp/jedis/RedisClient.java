package com.test.testApp.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisClient {
    private static String HOST = "127.0.0.1";
    private static int PORT = 6379;
    private Jedis jedis; // 非切片客户端
    private JedisPool jedisPool; // 非切片连接池

    public RedisClient() {
        initPool();
    }

    private void initPool() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxWaitMillis(1000l);
        config.setTestOnBorrow(false);
        config.setMaxIdle(5);
        config.setMaxTotal(20);

        this.jedisPool = new JedisPool(config, HOST, PORT);
        jedis = this.jedisPool.getResource();
    }

    public Jedis getResource() {
        return this.jedis;
    }
}
