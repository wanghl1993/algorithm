package com.wanghl.algorithm.solution.stringUtils;

import java.io.IOException;

public  class StringUtils implements Appendable, CharSequence {

    static char[] value;

    static int count;

    public static void main(String[] args) {

        String a = "abcdefg";
        System.out.println(a.substring(1));

        StringBuilder sb = new StringBuilder();
        sb.append(a);

        System.out.println(sb.deleteCharAt(sb.length() - 1));
        System.out.println(sb);
//        System.arraycopy(value, index+1, value, index, count-index-1);
    }

    @Override
    public Appendable append(CharSequence csq) throws IOException {
        return null;
    }

    @Override
    public Appendable append(CharSequence csq, int start, int end) throws IOException {
        return null;
    }

    @Override
    public Appendable append(char c) throws IOException {
        return null;
    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public char charAt(int index) {
        return 0;
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return null;
    }
}
