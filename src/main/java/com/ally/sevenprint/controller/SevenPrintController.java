package com.ally.sevenprint.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ally.sevenaccount.bean.SevenAccount;
import com.ally.sevenprint.bean.SevenPrint;
import com.ally.sevenprint.service.SevenPrintService;
import com.ally.util.ArchivesLog;
import com.ally.util.DeleteFile;
import com.ally.util.FileUtil;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/sevenPrint")
public class SevenPrintController {

	@Autowired
	private SevenPrintService sevenPrintService;

	/*
	 * 跳转到添加页
	 */
	@RequestMapping("/toAdd")
	public String toAdd() {
		return "view/sevenPrint/sevenPrint-add";
	}

	/*
	 * 添加图片
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "添加图片或者修改")
	@RequestMapping(value = "/addSevenPrint", method = RequestMethod.POST)
	public Map<String, Object> addSevenPrint(SevenPrint sevenPrint, @RequestParam(value = "file") MultipartFile file,
			HttpServletRequest request,HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		SevenAccount sevenAccount = (SevenAccount) session.getAttribute("account");
		if (sevenPrint.getId() != null) {
			if (file != null) {
				Map<String, String> queryMap = FileUtil.fileUp(file, "sevenPrint", request);
				sevenPrint.setpAid(sevenAccount.getId());
				sevenPrint.setpName(file.getOriginalFilename());
				sevenPrint.setpUrl(queryMap.get("realPath"));
				Boolean result = sevenPrintService.updateSevenPrint(sevenPrint);
				if (result) {
					map.put("status", 0);
					map.put("msg", "修改成功");
					map.put("data", sevenPrint.getId());
					map.put("src", sevenPrint.getpUrl());
				} else {
					map.put("status", 3);
					map.put("msg", "修改失败");
				}
			} else {
				Boolean result = sevenPrintService.updateSevenPrint(sevenPrint);
				if (result) {
					map.put("status", 0);
					map.put("msg", "修改成功");
				} else {
					map.put("status", 3);
					map.put("msg", "修改失败");
				}
			}
		} else {
			if (file != null) {
				Map<String, String> queryMap = FileUtil.fileUp(file, "sevenPrint", request);
				sevenPrint.setpUrl(queryMap.get("realPath"));
				sevenPrint.setpAid(sevenAccount.getId());
				sevenPrint.setpName(file.getOriginalFilename());
				Boolean result = sevenPrintService.addSevenPrint(sevenPrint);
				if (result) {
					map.put("status", 0);
					map.put("msg", "添加成功");
					map.put("data", sevenPrint.getId());
					map.put("src", sevenPrint.getpUrl());
				} else {
					map.put("status", 3);
					map.put("msg", "添加失败");
				}
			} else {
				sevenPrint.setpAid(sevenAccount.getId());
				Boolean result = sevenPrintService.addSevenPrint(sevenPrint);
				if (result) {
					map.put("status", "success");
					map.put("msg", "添加成功");
				} else {
					map.put("status", "error");
					map.put("msg", "添加失败");
				}
			}
		}
		return map;
	}

	/*
	 * 删除图片
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "删除图片")
	@RequestMapping(value = "/deletesevenPrint/{id}", method = RequestMethod.DELETE)
	public Map<String, String> deletesevenPrint(@PathVariable("id") Integer id, HttpServletRequest request) {
		Map<String, String> map = new HashMap<>();
		String path = sevenPrintService.selectSevenPrint(id).getpUrl();
		String realPath = request.getSession().getServletContext().getRealPath(path);
		if (path != null && path != "") {
			boolean flag = DeleteFile.deleteFile(realPath);
			if (flag) {
				Boolean result = sevenPrintService.deletesevenPrint(id);
				if (result) {
					map.put("status", "success");
					map.put("msg", "删除成功");
				} else {
					map.put("status", "error");
					map.put("msg", "删除失败");
				}
			}
		} else {
			Boolean result = sevenPrintService.deletesevenPrint(id);
			if (result) {
				map.put("status", "success");
				map.put("msg", "删除成功");
			} else {
				map.put("status", "error");
				map.put("msg", "删除失败");
			}
		}
		return map;
	}

	/*
	 * 查看图片信息
	 */
	@ResponseBody
	@RequestMapping(value = "/selectSevenPrintById/{id}", method = RequestMethod.GET)
	public SevenPrint selectSevenPrintById(@PathVariable("id") Integer id) {
		return sevenPrintService.selectSevenPrint(id);
	}

}
