package com.iqqcode;


/**
 * @Author: Mr.Q
 * @Date: 2020-03-30 22:41
 * @Description: 使用substring()
 */
public class Method9 {
    private static String reverse(String str) {
        if (str == null || str.equals("")) {
            return str;
        }
        //substring()：从指定位置截取字符串
        /**
         * return E + A B C D  //EABCD
         * return ED + A B C   //EDABC
         * return EDC + A B    //EDCAB
         * return EDCB + A     //EDCBA
         * return EDCBA
         */
        System.out.println(str);
        return str.charAt(str.length() - 1) + reverse(str.substring(0, str.length() - 1));
    }

    public static void main(String[] args) {
        String str = "ABCDE";
        System.out.println(" input :: " + str);
        System.out.println(" output :: " + reverse(str));
    }
}
