package com.soft.classwork.utils;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by Yuukiiii
 * on 2018/3/29 17:50
 */

public class FileUtil {
    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
    }
}
