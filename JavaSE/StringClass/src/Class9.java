public class Class9 {
    public static void main(String[] args) {

        //1.字符数组 => 字符串
        char[] data = {'H','e','l','l','o'};
        String str = new String(data);
        String str1 = new String(data,2,3);
        System.out.println("字符串为：" + str);
        System.out.println("字符串部分内容为：" + str1);

        //2.字符串  => 字符数组
        String sen = "Hello";
        char mem = sen.charAt(1);
        char[] arr = sen.toCharArray();
        System.out.println(mem);
        System.out.println(arr.length);

        //3.字节数组 => 字符串

        //4.字符串 => 字节数组

    }
}
