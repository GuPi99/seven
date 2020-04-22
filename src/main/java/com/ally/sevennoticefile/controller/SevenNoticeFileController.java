package com.ally.sevennoticefile.controller;

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

import com.ally.sevennoticefile.bean.SevenNoticeFile;
import com.ally.sevennoticefile.service.SevenNoticeFileService;
import com.ally.util.ArchivesLog;
import com.ally.util.FileUtil;

@Controller
@RequestMapping("/sevenNoticeFile")
public class SevenNoticeFileController {

	@Autowired
	private SevenNoticeFileService sevenNoticeFileService;
	/*
	 * 添加公告文件
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "添加公告文件")
	@RequestMapping(value = "/addNoticeFile", method = RequestMethod.POST)
	public Map<String, Object> addNoticeFile(SevenNoticeFile sevenNoticeFile,HttpServletRequest request,@RequestParam(value = "file") MultipartFile file) {
		Map<String, Object> map=new HashedMap<>();
		Map<String, String> queryMap = FileUtil.fileUp(file, "sevenNoticeFile", request);
		String pfName = file.getOriginalFilename();
		sevenNoticeFile.setNoticeName(pfName);
		sevenNoticeFile.setNoticeUrl(queryMap.get("realPath"));
		sevenNoticeFile.setNoticeType(pfName.substring(pfName.lastIndexOf(".") + 1));
		Boolean result=sevenNoticeFileService.addNoticeFile(sevenNoticeFile);
		if (result) {
			map.put("status", 0);
			map.put("msg", "文件上传成功");
			map.put("id", sevenNoticeFile.getId());
			map.put("type", sevenNoticeFile.getNoticeType());
			return map;
		} else {
			map.put("status", 3);
			map.put("msg", "文件上传失败");
			return map;
		}
	}
}
