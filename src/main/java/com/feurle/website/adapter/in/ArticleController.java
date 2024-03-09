package com.feurle.website.adapter.in;

import com.feurle.website.usecase.in.ArticleQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ArticleController {


	private final ArticleQuery articleQuery;

    public ArticleController(ArticleQuery articleQuery) {
        this.articleQuery = articleQuery;
    }

    @GetMapping("/home")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "home";
	}

}