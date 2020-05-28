package com.wanghl.algorithm.solution.ToLongString;

public class MaxArea {

    public static int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int max = 0;
        while (l < r) {
            int min = height[l] < height[r] ? height[l]:height[r];
            max = Math.max(max, min * (r-l));
            while (l<r && height[l] <= min) l++;
            while (l<r && height[r] <= min) r--;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] area = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(area));
    }
}
