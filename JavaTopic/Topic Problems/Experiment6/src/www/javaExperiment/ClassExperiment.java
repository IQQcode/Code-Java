package www.javaExperiment;

import  java.util.Date;
import java.text.SimpleDateFormat;

/**
 * 显示当前时间
 *
 */

public class ClassExperiment {
    public static void main(String[] args) {
        DateDisplay();
        Date date = new Date();
        System.out.println("\nThe current Time is: " + date.toString());
    }

    public static void DateDisplay() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat =
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Normal Type Date time is: " +
                simpleDateFormat.format(date));
    }
}

