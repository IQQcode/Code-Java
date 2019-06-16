package javaSe.EverydayTest;

import java.util.Scanner;

/**
 * abcd12345ed125ss123456789
 * 输出
 * 123456789
 */
public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = 0;  int temp = 0; int end = 0;
        while(input.hasNext()) {
            String str = input.nextLine();
            for(int i = 0; i < str.length(); i++) {
                if(str.charAt(i) >='0' && str.charAt(i) <= '9') {
                    count++;
                    if(temp < count) {
                        temp = count;
                        end = i;
                    }
                }else {
                    count = 0;
                }
            }
            System.out.println(str.substring(end + 1 - temp,end+1));
        }
    }
}