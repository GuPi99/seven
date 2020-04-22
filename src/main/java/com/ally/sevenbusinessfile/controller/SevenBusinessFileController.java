package com.ally.sevenbusinessfile.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ally.sevenbusinessfile.bean.SevenBusinessFile;
import com.ally.sevenbusinessfile.service.SevenBusinessFileService;
import com.ally.util.ArchivesLog;
import com.ally.util.FileUtil;

@Controller
@RequestMapping("/sevenBusinessFile")
public class SevenBusinessFileController {

	@Autowired
	private SevenBusinessFileService sevenBusinessFileService;
	
	/*
	 * 添加业务需求文件
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "添加业务需求文件")
	@RequestMapping(value = "/addBusinessFile", method = RequestMethod.POST)
	public Map<String, Object> addBusinessFile(SevenBusinessFile sevenBusinessFile,HttpServletRequest request,@RequestParam(value = "file") MultipartFile file) {
		Map<String, Object> map=new HashedMap<>();
		Map<String, String> queryMap = FileUtil.fileUp(file, "sevenBusinessFile", request);
		String pfName = file.getOriginalFilename();
		sevenBusinessFile.setBusinessName(pfName);
		sevenBusinessFile.setBusinessUrl(queryMap.get("realPath"));
		sevenBusinessFile.setBusinessType(pfName.substring(pfName.lastIndexOf(".") + 1));
		Boolean result=sevenBusinessFileService.addBusinessFile(sevenBusinessFile);
		if (result) {
			map.put("status", 0);
			map.put("msg", "文件上传成功");
			map.put("id", sevenBusinessFile.getId());
			map.put("type", sevenBusinessFile.getBusinessType());
			return map;
		} else {
			map.put("status", 3);
			map.put("msg", "文件上传失败");
			return map;
		}
	}
}
