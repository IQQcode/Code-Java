package tw;

import java.io.*;
import java.util.*;
import java.util.regex.*;

/**
 * @Author: iqqcode
 * @Date: 2020-11-04 10:20
 * @Description:
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        //根据字符统计
        getCharKindByChar(s);

        //根据ASCLL码统计
        getCharKindByASCLLCode(s);

        //根据正则统计
        getCharKindByRegex();
    }

    //1、根据字符统计
    public static void getCharKindByChar(String s) {
        int charCount = 0, numberCout = 0, blankCount = 0, otherCount = 0;
        for (int i = 0; i < s.length(); i++) {
            //英文字母
            char temp = s.charAt(i);
            if (('a' <= temp && temp <= 'z') || ('A' <= temp && temp <= 'Z')) {
                charCount++;
                //数字类型
            } else if ('0' <= temp && temp <= '9') {
                numberCout++;
                //空格类型(不全)
            } else if (temp == '\t' || temp == '\n' || temp == ' ') {
                blankCount++;
                //其它类型
            } else {
                otherCount++;
            }
        }
        System.out.println("**********");
        System.out.println("英文字母出现的次数：" + charCount);
        System.out.println("数字出现的次数：" + numberCout);
        System.out.println("空格字符出现的次数：" + blankCount);
        System.out.println("其它字符：" + otherCount);
    }

    //2、根据ASCLL码统计
    public static void getCharKindByASCLLCode(String s) {
        int charCount = 0, numberCout = 0, blankCount = 0, otherCount = 0;
        for (int i = 0; i < s.length(); i++) {
            //英文字母
            char temp = s.charAt(i);
            if ((65 <= temp && temp <= 90) || (97 <= temp && temp <= 122)) {
                charCount++;
                //数字类型
            } else if (48 <= temp && temp <= 57) {
                numberCout++;
                //空格类型
            } else if (temp <= 32) {
                blankCount++;
                //其它类型
            } else {
                otherCount++;
            }
        }
        System.out.println("**********");
        System.out.println("英文字母出现的次数：" + charCount);
        System.out.println("数字出现的次数：" + numberCout);
        System.out.println("空格字符出现的次数：" + blankCount);
        System.out.println("其它字符：" + otherCount);
    }

    //3、根据正则表达式匹配
    public static void getCharKindByRegex() {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        System.out.println("请输入字符串：");
        String string = "";

        try {
            string = bufferedReader.readLine();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Pattern letterPattern = Pattern.compile("[a-zA-Z]");
        Pattern numberPattern = Pattern.compile("[0-9]");
        Pattern blandPattern = Pattern.compile("[\\s|\r|\n|\t]");//不全

        Matcher letterMatcher = letterPattern.matcher(string);
        Matcher numberMatcher = numberPattern.matcher(string);
        Matcher blandMatcher = blandPattern.matcher(string);

        StringBuffer stringBufferLetter = new StringBuffer();
        StringBuffer stringBufferNumber = new StringBuffer();
        StringBuffer stringBufferBlank = new StringBuffer();

        while (letterMatcher.find()) {
            stringBufferLetter.append(letterMatcher.group(0));
        }
        while (numberMatcher.find()) {
            stringBufferNumber.append(numberMatcher.group(0));
        }
        while (blandMatcher.find()) {
            stringBufferBlank.append(blandMatcher.group(0));
        }

        int otherNumber = string.length() - stringBufferLetter.length() - stringBufferNumber.length() - stringBufferBlank.length();

        System.out.println("**********");
        System.out.println("字母类型：" + stringBufferLetter.length() + "个");
        System.out.println("数字类型：" + stringBufferNumber.length() + "个");
        System.out.println("空格类型：" + stringBufferBlank.length() + "个");
        System.out.println("其它类型：" + otherNumber + "个");
    }
}
