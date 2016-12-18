package com.github027.app.main.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github027.core.action.BaseAction;
import com.github027.web.ViewPath;

@Controller
public class MainAction extends BaseAction {

	@Autowired
	protected HttpServletRequest request;

	@RequestMapping("/main")
	public String goMainPage(Model model) {
		model.addAttribute("content", ViewPath.dashboard.with("/content"));

		return ViewPath.mainLayout.getPath();
	}

}
