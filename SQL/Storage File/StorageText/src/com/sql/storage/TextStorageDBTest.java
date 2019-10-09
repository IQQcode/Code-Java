package com.sql.storage;

/**
 * @Author: Mr.Q
 * @Date: 2019-10-09 21:32
 * @Description:
 */
public class TextStorageDBTest {
    public static void main(String[] args) {
        try {
            DataGather gather = new DataGather ();
            gather.loadFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
