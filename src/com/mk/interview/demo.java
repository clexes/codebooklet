package com.mk.interview;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class demo {

    public static void main(String[] args) throws IOException {
        String zipPath = "/Users/mac/Desktop/ceShi.zip";
//        ZipContraMultiFile(zipPath,"/Users/mac/Desktop/iop/");
        File file = new File(zipPath);
        unZipFiles(file,"/Users/mac/Desktop/iop/");
        String md5Path = "/Users/mac/Desktop/test.txt";
        File md5File = new File(md5Path);
        md5(md5File);
    }

    /**
     * 解压文件
     *
     * @param zipFile：需要解压缩的文件
     * @param descDir：解压后的目标目录
     */
    public static void unZipFiles(File zipFile, String descDir) throws IOException {
        File destFile = new File(descDir);
        if (!destFile.exists()) {
            destFile.mkdirs();
        }
        // 解决zip文件中有中文目录或者中文文件
        ZipFile zip = new ZipFile(zipFile, Charset.forName("GBK"));
        for (Enumeration entries = zip.entries(); entries.hasMoreElements(); ) {
            ZipEntry entry = (ZipEntry) entries.nextElement();
            InputStream in = zip.getInputStream(entry);
            String curEntryName = entry.getName();
            // 判断文件名路径是否存在文件夹
            int endIndex = curEntryName.lastIndexOf('/');
            // 替换
            String outPath = (descDir + curEntryName).replaceAll("\\*", "/");
            if (endIndex != -1) {
                File file = new File(outPath.substring(0, outPath.lastIndexOf("/")));
                if (!file.exists()) {
                    file.mkdirs();
                }
            }

            // 判断文件全路径是否为文件夹,如果是上面已经上传,不需要解压
            File outFile = new File(outPath);
            if (outFile.isDirectory()) {
                continue;
            }
            OutputStream out = new FileOutputStream(outPath);
            byte[] buf1 = new byte[1024];
            int len;
            while ((len = in.read(buf1)) > 0) {
                out.write(buf1, 0, len);
            }
            in.close();
            out.close();
        }
        System.out.println("解压{}成功" + zipFile.getName());
    }

    public static String md5(File file){
        return null;
    }

    /*public static void ZipContraMultiFile(String zippath ,String outzippath){
        try {
            File file = new File(zippath);
            File outFile = null;
            ZipFile zipFile = new ZipFile(file);
            ZipInputStream zipInput = new ZipInputStream(new FileInputStream(file));
            ZipEntry entry = null;
            InputStream input = null;
            OutputStream output = null;
            while((entry = zipInput.getNextEntry()) != null){
                System.out.println("解压缩" + entry.getName() + "文件");
                outFile = new File(outzippath + File.separator + entry.getName());
                if(!outFile.getParentFile().exists()){
                    outFile.getParentFile().mkdir();
                }
                if(!outFile.exists()){
                    outFile.createNewFile();
                }
                input = zipFile.getInputStream(entry);
                output = new FileOutputStream(outFile);
                int temp = 0;
                while((temp = input.read()) != -1){
                    output.write(temp);
                }
                input.close();
                output.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

}
