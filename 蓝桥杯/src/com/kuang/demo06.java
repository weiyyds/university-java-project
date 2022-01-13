package com.kuang;

import java.util.Scanner;

public class demo06 {
    public static void main(String[] args) {
        /**
         *     1：两个字符串长度不等。比如 Beijing 和 Hebei
         * 　　2：两个字符串不仅长度相等，而且相应位置上的字符完全一致(区分大小写)，比如 Beijing 和 Beijing
         * 　　3：两个字符串长度相等，相应位置上的字符仅在不区分大小写的前提下才能达到完全一致（也就是说，它并不满足情况2）。比如 beijing 和 BEIjing
         * 　　4：两个字符串长度相等，但是即使是不区分大小写也不能使这两个字符串一致。比如 Beijing 和 Nanjing
         * 　　编程判断输入的两个字符串之间的关系属于这四类中的哪一类，给出所属的类的编号。
         */
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2=sc.next();
        if (str1.length()!=str2.length()){
            System.out.println("1");
        }
        if (str1.length()==str2.length()&&str1.equals(str2)){
            System.out.println("2");
        }
        if (str1.length()==str2.length()&&!str1.equals(str2)){
            System.out.println("3");
        }
        if (str1.length()==str2.length()){
            System.out.println("4");
        }


    }
}
