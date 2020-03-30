package com.sql.cahnge;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @Author: Mr.Q
 * @Date: 2019-10-08 15:07
 * @Description:
 */
class ImageUtil {
    private static File file=null;

    public static FileInputStream getImageByte(String infile) throws FileNotFoundException {
        FileInputStream imageByte=null;
        file=new File(infile);
        imageByte=new FileInputStream(file);
        return imageByte;
    }
}
