package com.stark.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class CopyFile {
	
	public static boolean copyFile(String srcDirectory,String destDiretory) throws Exception{
		boolean flag=false;
		
		String fileList[]=getFileListFromDirectory(srcDirectory);
		for (String string : fileList) {
			File srcTemp=new File(srcDirectory+string);
			File destTemp= new File(destDiretory+string);
			copyFileUsingChannel(srcTemp, destTemp);
			flag=true;
		}
		return flag;
	}
	
	private static void copyFileUsingChannel(File source, File dest) throws IOException {
        FileChannel sourceChannel = null;
        FileChannel destChannel = null;
        
            sourceChannel = new FileInputStream(source).getChannel();
            destChannel = new FileOutputStream(dest).getChannel();
            destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
           
    }
	public static String[]  getFileListFromDirectory(String directory){
		File d=new File(directory);
		String[] fileList=null;
		if(d.exists()&&d.list().length>0){
		 fileList = d.list();
		}
		return fileList;
		
	}

}
