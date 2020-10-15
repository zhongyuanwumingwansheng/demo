package com.example.demo.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LocalMemoryCache {

    private String namespace;

    private Map<String, Object> cache = new ConcurrentHashMap<>();

    public Object get(String key){
        return this.cache.get(resolveKey(key));
    }

    public <K, V> boolean put(K key, V value){
        this.cache.put(resolveKey(key), value);
        return true;
    }

    public boolean delete(String key){
        this.cache.remove(resolveKey(key));
        return true;
    }

    private String resolveKey(Object k) {
        return this.namespace + "_" + k;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public Map<String, Object> getCache() {
        return cache;
    }

    public void setCache(Map<String, Object> cache) {
        this.cache = cache;
    }
}
