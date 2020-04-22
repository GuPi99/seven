package com.ally.sevenprojectschedule.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ally.sevenprojectschedule.bean.SevenProjectSchedule;
import com.ally.sevenprojectschedule.service.SevenProjectScheduleService;
import com.ally.util.ArchivesLog;
import com.ally.util.FileUtil;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/sevenProjectSchedule")
public class SevenProjectScheduleController {

	@Autowired
	private SevenProjectScheduleService sevenProjectScheduleService;
	/*
	 * 跳转到添加页
	 */
	@RequestMapping("/toAdd")
	public String toAdd() {
		return "view/sevenProjectSchedule/sevenProjectSchedule-add";
	}
	
	/*
	 * 跳转到首页页
	 */
	@RequestMapping("/index")
	public String index() {
		return "view/sevenProjectSchedule/index";
	}
	
	@ResponseBody
	@ArchivesLog(operteContent = "添加项目进度文件")
	@RequestMapping(value = "/addSevenProjectSchedule", method = RequestMethod.POST)
	public Map<String, Object> addSevenProjectFile(SevenProjectSchedule sevenProjectSchedule,
			@RequestParam(value = "file") MultipartFile file, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		Map<String, String> queryMap = FileUtil.fileUp(file, "sevenProjectSchedule", request);
		sevenProjectSchedule.setPsUrl(queryMap.get("realPath"));
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = dFormat.format(System.currentTimeMillis());
		try {
			sevenProjectSchedule.setPsTime(dFormat.parse(format));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Boolean result = sevenProjectScheduleService.addSevenProjectSchedule(sevenProjectSchedule);
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
	 * 分页查询项目进度信息
	 */
	@ResponseBody
	@RequestMapping(value = "/getSevenProjectScheduleList", method = RequestMethod.GET)
	public Map<String, Object> getSevenProjectScheduleList(@RequestParam(required = true, defaultValue = "1") Integer page,
			Integer limit,Integer psPid) {
		Map<String, Object> map = new HashMap<>();
		PageInfo<SevenProjectSchedule> list = null;
		if (psPid==null) {
			map.put("data", null);
			map.put("total", null);
		}else {
			list=sevenProjectScheduleService.getSevenProjectScheduleList(page, limit, psPid);
			map.put("data", list.getList());
			map.put("total", list.getTotal());
		}
		map.put("status", 0);
		map.put("message", "成功");
		return map;
	}
}
