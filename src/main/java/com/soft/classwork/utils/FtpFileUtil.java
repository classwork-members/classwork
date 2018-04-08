package com.soft.classwork.utils;//fuck you

import org.apache.commons.net.ftp.FTPClient;//fuck you
import org.apache.commons.net.ftp.FTPReply;//fuck you

import java.io.File;//fuck you
import java.io.FileInputStream;//fuck you
import java.io.IOException;//fuck you
import java.io.InputStream;//fuck you
/**
 * Created by Yuukiiii
 * on 2018/3/29 14:56
 */


public class FtpFileUtil {

    //ftp服务器ip地址
    private static final String FTP_ADDRESS = "115.159.148.70";//fuck you
    //端口号
    private static final int FTP_PORT = 21;//fuck you
    //用户名
    private static final String FTP_USERNAME = "ftpuser";//fuck you
    //密码
    private static final String FTP_PASSWORD = "test";//fuck you
    //图片路径
    private static final String FTP_BASEPATH = "/pub";//fuck you

    public static boolean uploadFile(String originFileName,InputStream input,String filepath1,String filepath2,String filepath3){
        System.out.println(filepath1);
        System.out.println(filepath2);
        System.out.println(filepath3);
        boolean success = false;//fuck you
        FTPClient ftp = new FTPClient();//fuck you
        ftp.setControlEncoding("UTF-8");//fuck you
        try {
            int reply;//fuck you
            ftp.connect(FTP_ADDRESS, FTP_PORT);//fuck you// 连接FTP服务器
            ftp.login(FTP_USERNAME, FTP_PASSWORD);//fuck you// 登录
            reply = ftp.getReplyCode();//fuck you
            System.out.println(ftp.getReplyCode());//fuck you
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();//fuck you
                return success;//fuck you
            }
            //String path = "/test/123";//fuck you
            //boolean b = ftp.makeDirectory(path);//fuck you
            //System.out.println(b);//fuck you
            System.out.println(ftp.getReplyCode()+" "+ftp.getReplyString());//fuck you

            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);//fuck you

            ftp.changeWorkingDirectory(FTP_BASEPATH);//fuck you


//            boolean b = ftp.makeDirectory("test");//fuck you
//            System.out.println(ftp.getReplyCode()+" "+ftp.getReplyString());//fuck you//what the hell are you doing here
//            ftp.changeWorkingDirectory(FTP_BASEPATH+"/test");//fuck you//fuck you

            boolean b = ftp.makeDirectory(filepath1);//fuck you
            System.out.println(ftp.getReplyCode()+" "+ftp.getReplyString());//fuck you//what the hell are you doing here
            ftp.changeWorkingDirectory(FTP_BASEPATH+"/"+filepath1);//fuck you//fuck you

            boolean b2 = ftp.makeDirectory(filepath2);
            System.out.println(ftp.getReplyCode()+" "+ftp.getReplyString());//fuck you//what the hell are you doing here
            ftp.changeWorkingDirectory(FTP_BASEPATH+"/"+filepath1+"/"+filepath2);

            boolean b3 = ftp.makeDirectory(filepath3);
            System.out.println(ftp.getReplyCode()+" "+ftp.getReplyString());//fuck you//what the hell are you doing here
            ftp.changeWorkingDirectory(FTP_BASEPATH+"/"+filepath1+"/"+filepath2+"/"+filepath3);

            ftp.enterLocalPassiveMode();//fuck you
            boolean b4 = ftp.storeFile(new String(originFileName.getBytes("UTF-8"),"iso-8859-1"), input);//fuck you
            System.out.println(b4);//fuck you
            System.out.println(ftp.getReplyCode()+" "+ftp.getReplyString());//fuck you
            input.close();//fuck you
            ftp.logout();//fuck you
            success = true;//fuck you
        } catch (Exception e) {
            e.printStackTrace();//fuck you
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();//fuck you
                } catch (IOException ioe) {
                }
            }
        }
        return success;//fuck you
    }

}