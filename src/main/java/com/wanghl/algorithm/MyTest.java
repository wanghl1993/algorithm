package com.wanghl.algorithm;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyTest {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int len1 = m - 1;
        int len2 = n - 1;
        int len = m + n - 1;
        while(len1 >= 0 && len2 >= 0){
            //注意一符号在后面, 表示先进行计算再减一, 这种缩写缩短了代码
            nums1[len--] = nums1[len1] > nums2[len2] ? nums1[len1--]:nums2[len2--];
        }
        // 表示将nums2数组从下标0位置开始,拷贝到nums1数组中, 从下标0位置开始,
        // 长度为len2+1
        System.arraycopy(nums2,0,nums1,0,len2+1);
        System.out.println(nums1.toString()  + "===" + nums2.toString());
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,0,0,0};
        int[] b = {2,5,6};
        merge(a,3,b,3);
//        System.arraycopy(b,0,a,0,3);
//        System.out.println(b.toString()+ "==" + a.toString());
        System.out.println("aaa");
    }

    public static int toHash(String key) {
        int arraySize = 11113; // 数组大小一般取质数
        int hashCode = 0;
        for (int i = 0; i < key.length(); i++) { // 从字符串的左边开始计算
            int letterValue = key.charAt(i) - 96;// 将获取到的字符串转换成数字，比如a的码值是97，则97-96=1
            // 就代表a的值，同理b=2；
            hashCode = ((hashCode << 5) + letterValue) % arraySize;// 防止编码溢出，对每步结果都进行取模运算
        }
        return hashCode;
    }



}
