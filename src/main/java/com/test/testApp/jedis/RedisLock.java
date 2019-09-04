package com.test.testApp.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

public class RedisLock {
    private String LOCK_SUCCESS = "OK";
    private Long RELEASE_SUCCESS = 1L;

    private Jedis jedis;

    public RedisLock() {
        RedisClient redisClient = new RedisClient();
        this.jedis = redisClient.getResource();
    }

    public boolean tryGetLock(String key, String requestId, long expireTime) {
        SetParams setParams = new SetParams();
        setParams.nx();
        setParams.px(expireTime);
        String lock = jedis.set(key, requestId, setParams);

        System.out.println(requestId + " tryLock: " + lock);
        return LOCK_SUCCESS.equals(lock);
    }

    public boolean tryDelLock(String key, String requestId) {
        String eval = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Object result = jedis.eval(eval, Collections.singletonList(key), Collections.singletonList(requestId));

        System.out.println(requestId + " tryDelLock " + result.toString());
        return result.equals(RELEASE_SUCCESS);
    }
}
