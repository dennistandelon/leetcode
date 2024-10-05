class AllOne {
    private Map<String, Integer> countMap;
    private TreeMap<Integer, Set<String>> sortedMap;

    public AllOne() {
        countMap = new HashMap<>();
        sortedMap = new TreeMap<>();
    }
    
    public void inc(String key) {
        int count = countMap.getOrDefault(key, 0);
        
        if (count > 0) {
            Set<String> keysAtCount = sortedMap.get(count);
            keysAtCount.remove(key);
            if (keysAtCount.isEmpty()) {
                sortedMap.remove(count);
            }
        }
        
        count++;
        countMap.put(key, count);
        
        sortedMap.computeIfAbsent(count, k -> new HashSet<>()).add(key);
    }
    
    public void dec(String key) {
        int count = countMap.get(key);
        
        Set<String> keysAtCount = sortedMap.get(count);
        keysAtCount.remove(key);
        if (keysAtCount.isEmpty()) {
            sortedMap.remove(count);
        }
        
        // Decrement the count
        if (count == 1) {
            countMap.remove(key); 
        } else {
            count--;
            countMap.put(key, count);
            sortedMap.computeIfAbsent(count, k -> new HashSet<>()).add(key);
        }
    }
    
    public String getMaxKey() {
        if (sortedMap.isEmpty()) return "";
        return sortedMap.lastEntry().getValue().iterator().next();
    }
    
    public String getMinKey() {
        if (sortedMap.isEmpty()) return "";
        return sortedMap.firstEntry().getValue().iterator().next();
    }
}
