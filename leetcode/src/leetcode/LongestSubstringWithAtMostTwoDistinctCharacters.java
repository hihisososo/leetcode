package leetcode;

import java.util.HashMap;

public class LongestSubstringWithAtMostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Character,Integer> hashMap = new HashMap();
        int distinctCnt = 0;
        int startIdx = 0;
        int maxLength = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(hashMap.containsKey(c)){
                hashMap.put(c, hashMap.get(c)+1);
            }else{
                hashMap.put(c,1);
                distinctCnt++;
            }

            if(distinctCnt > 2){
                while(true){
                    int val = hashMap.get(s.charAt(startIdx));
                    hashMap.put(s.charAt(startIdx), val-1);
                    if(hashMap.get(s.charAt(startIdx)) == 0){
                        hashMap.remove(s.charAt(startIdx));
                        distinctCnt--;
                        startIdx++;
                        break;
                    }
                    startIdx++;
                }
            }else if(distinctCnt == 2 || distinctCnt == 1){
                maxLength = Math.max(i - startIdx + 1, maxLength);
            }
        }
        return maxLength;
    }
}
