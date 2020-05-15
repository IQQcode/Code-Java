package com.gui.demo;

import com.gui.red.OpenMode;

import java.util.ArrayList;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-15 15:44
 * @Description:普通红包
 */
public class NormalMode implements OpenMode {
    @Override
    public ArrayList<Integer> divide(final int totalMoney, final int totalCount) {
        ArrayList<Integer> list = new ArrayList <>();

        int avg = totalMoney / totalCount;
        int mod = totalMoney % totalCount;  //余数

        for (int i = 0; i < totalCount - 1; i++) {
            list.add(avg);
        }

        list.add(avg + mod);
        return list;
    }
}
