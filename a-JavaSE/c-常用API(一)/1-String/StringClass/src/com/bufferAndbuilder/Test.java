package com.bufferAndbuilder;


/**
 * @Author: Mr.Q
 * @Date: 2019-11-28 20:48
 * @Description:
 */
public class Test {
    public int RectCover(int target) {
        if(target == 1) {
            return 1;
        }else if (target == 2) {
            return  2;
        }else {
            return RectCover(target - 1) + RectCover(target - 2);
        }
    }
}
