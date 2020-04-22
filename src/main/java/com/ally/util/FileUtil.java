package com.ally.util;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class FileUtil {

	public static Map<String, String>  fileUp(MultipartFile file,String url,HttpServletRequest request){
		Map<String, String> map=new HashMap<String, String>();
		String realPath = request.getSession().getServletContext().getRealPath("resource/"+url);
		File uploadDirectory = new File(realPath);
		if (!uploadDirectory.exists()) {
			uploadDirectory.mkdirs();
		}
		String fileName = UUID.randomUUID().toString().replaceAll("-", "");
		try {
			file.transferTo(new File(realPath + "/" + fileName));
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.put("realPath", "resource/"+url+"/"+fileName);
        return map;
	}
}
