package jp.co.ammm.myideabox.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/myideabox")
public class AllCollectionController {

	@RequestMapping(value="/collection/all", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("msg", "画像たち");
		return "index";
	}
}