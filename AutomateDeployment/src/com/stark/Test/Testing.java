package com.stark.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.AclEntry;
import java.nio.file.attribute.AclFileAttributeView;
import java.util.List;

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
    
    public static void main2(final String[] args) throws Exception {
        /*File source = new File("D:\\soft\\7z920-x64.exe");
        File Destination = new File("D:\\New folder (2)");
        Testing.copyFile(source, Destination);*/
        /*Testing.check();*/
        /*Path src= Paths.get("D:\\soft");
      System.out.println(src.getNameCount()); */
        File f = new File("E:\\New folder (3)\\");
        File fo = new File("E:\\New folder (4)\\");
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
    public static void main3(String[] args) {
    	Path originalDirectory = FileSystems.getDefault().
    			getPath("E:\\New folder (3)\\");
    			 
    			Path newDirectory = FileSystems.getDefault().
    			getPath("E:\\New folder (4)\\");

    			try{


    			Files.copy(originalDirectory, newDirectory);

    			System.out.println("Directory copied successfully!");
    			}

    			catch (IOException e){


    			e.printStackTrace();
    			}
    			
}
    
	private static void copyFileUsingChannel(File source, File dest) throws IOException {
        FileChannel sourceChannel = null;
        FileChannel destChannel = null;
        
            sourceChannel = new FileInputStream(source).getChannel();
            destChannel = new FileOutputStream(dest).getChannel();
            destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
           
    }
    public static void main(String[] args) throws Exception {
    	
    	File f = new File("E:\\New folder (3)\\");
        File fo = new File("E:\\New folder (4)\\");
        String fileList[] = f.list();
        for (String file : fileList) {
        	File bar=new File("E:\\New folder (3)\\"+file);
        	File lo=new File("E:\\New folder (4)\\"+file);
			copyFileUsingChannel(bar,lo);
		}
        

	}
}
