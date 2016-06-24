package com.stark.operations;

import com.stark.entities.SearchCriteria;
import com.stark.utilities.CopyFile;

public class BuildOperation {
	
	public static void main(String[] args) throws Exception {
		
	
		
		String src="E:\\New folder (3)\\";
		String dest="E:\\New folder (4)\\";
		SearchCriteria sc = new SearchCriteria("New", "");
		doOperation(sc, src, dest);
		
	}
	
	public static void doOperation(SearchCriteria sc,String srcDirectory,String destDirectory) throws Exception{
		
		System.out.println(sc.getStartWith()+" "+sc.getEndsWith());
		String[]fileList= CopyFile.getFileListFromDirectory(srcDirectory);
		for (String string : fileList) {
			if(!string.startsWith("WEB")){
				CopyFile.copyFile(srcDirectory, destDirectory);
			}
		}
		System.out.println("Copied Successfully");
	}
}
