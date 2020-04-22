package com.ally.util;

import java.io.File;

public class DeleteFile {

	public static boolean deleteFile(String path) {
		File file=new File(path);
		if (path!=null) {
			if (file.isFile()&&file.exists()) {
				file.delete();
				return true;
			} 
		}
		return true;
	}
}
