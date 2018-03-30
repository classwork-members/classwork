package com.soft.classwork.utils;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
/**
 * Created by Yuukiiii
 * on 2018/3/29 14:56
 */


public class FtpFileUtil {

    //ftp服务器ip地址
    private static final String FTP_ADDRESS = "115.159.148.70";
    //端口号
    private static final int FTP_PORT = 21;
    //用户名
    private static final String FTP_USERNAME = "ftpuser";
    //密码
    private static final String FTP_PASSWORD = "test";
    //图片路径
    private static final String FTP_BASEPATH = "/pub/illness/qwr/";

    public  static boolean uploadFile(String originFileName,InputStream input){
        boolean success = false;
        FTPClient ftp = new FTPClient();
        ftp.setControlEncoding("UTF-8");
        try {
            int reply;
            ftp.connect(FTP_ADDRESS, FTP_PORT);// 连接FTP服务器
            ftp.login(FTP_USERNAME, FTP_PASSWORD);// 登录
            reply = ftp.getReplyCode();
            System.out.println(ftp.getReplyCode());
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return success;
            }
            System.out.println(1);
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftp.makeDirectory(FTP_BASEPATH );
            ftp.changeWorkingDirectory(FTP_BASEPATH);
            ftp.enterLocalPassiveMode();
            boolean b = ftp.storeFile(new String(originFileName.getBytes("UTF-8"),"iso-8859-1"), input);
            System.out.println(b);
            System.out.println(ftp.getReplyCode());
            input.close();
            ftp.logout();
            success = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return success;
    }

}