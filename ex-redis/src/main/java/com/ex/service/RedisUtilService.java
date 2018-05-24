package com.ex.service;


import java.util.Map;
public interface RedisUtilService {


    public void remove(final String... keys);
    /**
     * 批量删除key
     *
     * @param pattern
     */
    public void removePattern(final String pattern);
    /**
     * 删除对应的value
     *
     * @param key
     */
    public void remove(final String key);
    /**
     * 判断缓存中是否有对应的value
     *
     * @param key
     * @return
     */
    public boolean exists(final String key);
    /**
     * 读取缓存
     *
     * @param key
     * @return
     */
    public String get(final String key);
    /**
     * 写入缓存
     *
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, Object value);
    /**
     * 写入缓存
     *
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, Object value, Long expireTime);

    public  boolean hmset(String key, Map<String, String> value);

    public  Map<String,String> hmget(String key) ;
}
