package com.sql.storage;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

/**
 * @Author: Mr.Q
 * @Date: 2019-10-09 20:26
 * @Description:数据采集类
 */
public class DataGather {
    private static final String PATH = "D:/test.txt";
    public static final String openFileStyle = "r";
    public static final String fieldLimitChar = ",";
    public static final int fieldAllCount = 9;
    private int count;  //
    private String FltNum;
    private String FltLine;
    private String FltDate;
    private String PsgName;
    private String PsgType;
    private String PsgSex;
    private String PsgCab;
    private String PsgSeatNo;
    private String PsgInfo;

    /**
     * 解析文本文件
     * @throws FileNotFoundException
     */
    public void loadFile() throws FileNotFoundException {
        RandomAccessFile raf = new RandomAccessFile(PATH, openFileStyle);
        try {
            String line_record = raf.readLine();
            while (line_record != null) {
                //解析每一条记录
                parseRecord(line_record);
                line_record = raf.readLine();
            }
            System.out.println("合法数据共有" + count + "条");
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 存储拆分记录
     * @param oldstr
     * @return
     */
    private String tranStr(String oldstr) {
        String newstr = "";
        try {
            newstr = new String(oldstr.getBytes("ISO-8859-1"), "GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return newstr;
    }

    private  void parseRecord(String line_record) throws SQLException {
        //拆分记录
        String[] fields = line_record.split(fieldLimitChar);
        if(fields.length == fieldAllCount) {
            FltNum = tranStr(fields[0]);
            FltLine = tranStr(fields[1]);
            FltDate = tranStr(fields[2]);
            PsgName = tranStr(fields[3]);
            PsgType = tranStr(fields[4]);
            PsgSex = tranStr(fields[5]);
            PsgCab = tranStr(fields[6]);
            PsgSeatNo = tranStr(fields[7]);
            PsgInfo = tranStr(fields[8]);
            System.out.println(FltNum + " " + FltLine + " " + FltDate + " "
                    + PsgName + " " + PsgType + " " + PsgSex + " " + PsgCab
                    + " " + PsgSeatNo + " " + PsgInfo);
            DBUtil db = new DBUtil();
            db.insertText(FltNum, FltLine, FltDate, PsgName, PsgType, PsgSex,
                    PsgCab, PsgSeatNo, PsgInfo);
            count++;
        }
    }
}
