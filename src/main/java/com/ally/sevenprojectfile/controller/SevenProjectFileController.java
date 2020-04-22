package com.ally.sevenprojectfile.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ally.sevenprojectfile.bean.SevenProjectFile;
import com.ally.sevenprojectfile.service.SevenProjectFileService;
import com.ally.sevenprojectgoods.bean.SevenProjectGoods;
import com.ally.util.ArchivesLog;
import com.ally.util.FileUtil;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/sevenProjectFile")
public class SevenProjectFileController {

	@Autowired
	private SevenProjectFileService sevenProjectFileService;

	/*
	 * 跳转到添加页
	 */
	@RequestMapping("/toAdd")
	public String toAdd() {
		return "view/sevenProjectFile/sevenProjectFile-add";
	}

	/*
	 * 跳转到添加页
	 */
	@RequestMapping("/index")
	public String index() {
		return "view/sevenProjectFile/index";
	}

	/*
	 * 添加项目文件
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "添加项目文件")
	@RequestMapping(value = "/addSevenProjectFile", method = RequestMethod.POST)
	public Map<String, Object> addSevenProjectFile(SevenProjectFile sevenProjectFile,
			@RequestParam(value = "file") MultipartFile file, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		Map<String, String> queryMap = FileUtil.fileUp(file, "sevenProjectFile", request);
		if (StringUtils.isEmpty(sevenProjectFile.getPfName())) {
			map.put("status", 3);
			map.put("msg", "文件名称不能为空");
			return map;
		}
		String pfName = file.getOriginalFilename();
		sevenProjectFile.setPfUrl(queryMap.get("realPath"));
		sevenProjectFile.setPfType(pfName.substring(pfName.lastIndexOf(".") + 1));
		Boolean result = sevenProjectFileService.addSevenProjectFile(sevenProjectFile);
		if (result) {
			map.put("status", 0);
			map.put("msg", "添加成功");
			return map;
		} else {
			map.put("status", 3);
			map.put("msg", "添加失败");
			return map;
		}
	}

	/*
	 * 分页查询项目文件
	 */
	@ResponseBody
	@RequestMapping(value = "/getSevenProjectFileList", method = RequestMethod.GET)
	public Map<String, Object> getSevenProjectFileList(@RequestParam(required = true, defaultValue = "1") Integer page,
			Integer limit, Integer pfPid) {
		Map<String, Object> map = new HashMap<>();
		PageInfo<SevenProjectGoods> list = null;
		if (pfPid == null) {
			list = null;
			map.put("data", null);
			map.put("total", null);
		} else {
			list = sevenProjectFileService.getSevenProjectFileList(page, limit, pfPid);
			map.put("data", list.getList());
			map.put("total", list.getTotal());
		}
		map.put("status", 0);
		map.put("message", "成功");
		return map;
	}
}
