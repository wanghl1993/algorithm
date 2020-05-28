package com.wanghl.algorithm.solution.ToLongString;

import java.util.HashMap;
import java.util.Map;

public class LongString {

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(),ans = 0;
        Map<Character,Integer> map = new HashMap<>();
        for(int end = 0,start = 0;end < n;end++){
            char alpha = s.charAt(end);
            if(map.containsKey(alpha)){
                start = Math.max(map.get(alpha),start);
            }
            ans = Math.max(ans,end - start + 1);
            map.put(s.charAt(end),end + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }


}
