package lfucache;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

class LFUCache {

    int capacity;

    Map<Integer, Integer> cache = new HashMap<>();
    Map<Integer, Integer> freqKey = new HashMap<>();
    Map<Integer, LinkedHashSet<Integer>> freqMap = new HashMap<>();
    int minFreq = -1;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        freqMap.put(1, new LinkedHashSet<>());
    }

    public int get(int key) {
        if (!cache.containsKey(key)) { return -1; }

        incFreq(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        if (capacity == 0) { return; }

        if (cache.containsKey(key)) {
            cache.put(key, value);
            incFreq(key);
            return;
        }

        if (cache.size() == capacity) { deleteCacheUnit(); }

        createCacheUnit(key, value);
    }

    private void createCacheUnit(int key, int value) {
        cache.put(key, value);
        freqKey.put(key, 1);
        minFreq = 1;
        freqMap.get(1).add(key);
    }

    private void incFreq(int key) {
        int freq = freqKey.get(key);

        freqMap.get(freq).remove(key);

        if (freq == minFreq && freqMap.get(freq).size() == 0) {
            minFreq++;
        }

        freqKey.put(key, ++freq);

        if(!freqMap.containsKey(freq)) {
            freqMap.put(freq, new LinkedHashSet<>());
        }

        freqMap.get(freq).add(key);
    }

    private void deleteCacheUnit() {
        int delKey = freqMap.get(minFreq).iterator().next();

        freqMap.get(minFreq).remove(delKey);
        cache.remove(delKey);
        freqKey.remove(delKey);
    }
}