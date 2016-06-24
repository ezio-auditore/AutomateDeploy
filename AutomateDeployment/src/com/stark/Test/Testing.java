package com.stark.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;

public class Testing {

    
    public static void copyFile(final File sourceFile, final File destFile) throws IOException {
        if(!destFile.exists()) {
            destFile.createNewFile();
        }

        FileChannel source = null;
        FileChannel destination = null;

        try {
            source = new FileInputStream(sourceFile).getChannel();
            destination = new FileOutputStream(destFile).getChannel();
            destination.transferFrom(source, 0, source.size());
        }
        finally {
            if(source != null) {
                source.close();
            }
            if(destination != null) {
                destination.close();
            }
        }
    }
    
    public static void main(final String[] args) throws Exception {
        /*File source = new File("D:\\soft\\7z920-x64.exe");
        File Destination = new File("D:\\New folder (2)");
        Testing.copyFile(source, Destination);*/
        /*Testing.check();*/
        /*Path src= Paths.get("D:\\soft");
      System.out.println(src.getNameCount()); */
        File f = new File("D:\\BUILD&SYNC\\BUILD\\UAT\\ITD_EFILING_LIB\\userlib");
        File fo = new File("D:\\appl\\tomcat\\common\\EFILING_USER_LIB");
        Testing.check(f,fo);
    }
    
    public static void check(final File file,final File fo) throws Exception{
     
     File fileList[] = file.listFiles();
     for(File foo:fileList){
         
         if(!foo.getName().startsWith("WEB")){
             Testing.copy(foo, fo);
         }
     }
        
    }
    public static void copy(final File file,final File fo) throws Exception{
        InputStream in = new FileInputStream(file.getAbsolutePath());
        OutputStream out = new FileOutputStream(fo.getAbsolutePath());
        byte[] buffer = new byte[1024];
        
        int length;
        while ((length = in.read(buffer)) > 0){
      
            out.write(buffer, 0, length);
     
        }
     
        in.close();
        out.close();
    }
}
