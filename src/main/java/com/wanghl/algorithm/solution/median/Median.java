package com.wanghl.algorithm.solution.median;

import java.util.Arrays;

public class Median {
    public static String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return "";
        }

        char[] str = s.toCharArray();
        int [] range = new int[2];

        for(int i =0; i < str.length;i++){
            i = findCenterIndex(str,i,range);
        }

        return s.substring(range[0],range[1]+1);
    }


    private static int findCenterIndex(char[] str,int low,int[] range){
        int hight = low;
        while(hight < str.length -1 && str[hight+1]== str[low]){
            hight++;
        }

        int ans = hight;

        while(low > 0 && hight < str.length -1 && str[low -1] == str[hight+1] ){
            hight++;
            low--;
        }

        if(hight - low > range[1] - range[0]){
            range[0] = low;
            range[1] = hight;
        }

        return ans;
    }
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abcba"));
    }

}
