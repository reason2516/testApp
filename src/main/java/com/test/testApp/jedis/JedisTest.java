package com.test.testApp.jedis;

public class JedisTest {
    public static void main(String[] args) {
        RedisLock redisLock = new RedisLock();
        String key = "testLock";
        String requestId = String.valueOf(System.currentTimeMillis());
        Long expireTime = 10000L;
        // true
        boolean t1 = redisLock.tryGetLock(key, requestId, expireTime);

        // false 锁被占用
        boolean t2 = redisLock.tryGetLock(key, requestId, expireTime);

        // false requestId不对
        boolean d1 = redisLock.tryDelLock(key, requestId + "AAAA");

        // true
        boolean d2 = redisLock.tryDelLock(key, requestId);

        // false 锁已经被删除
        boolean d3 = redisLock.tryDelLock(key, requestId);

        System.out.println(t1);
        System.out.println(t2);
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d3);
    }
}
