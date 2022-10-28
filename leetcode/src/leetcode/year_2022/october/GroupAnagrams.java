class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
    
        StringBuilder sb = new StringBuilder();
         String[] cp = Arrays.copyOf(strs,strs.length);
        for(int i=0;i<strs.length;i++){     char[] arr = cp[i].toCharArray();
            Arrays.sort(arr);
            cp[i] = new String(arr);  
       }
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        
        for(int i=0;i<cp.length;i++){
            map.putIfAbsent(cp[i],new ArrayList<String>());
          
            map.get(cp[i]).add(strs[i]);
        }

        
        List<List<String>> keyList = map.values().stream()
        .collect(Collectors.toCollection(ArrayList::new));
        return keyList;
    }
    
}
