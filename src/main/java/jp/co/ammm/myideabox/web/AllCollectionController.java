package jp.co.ammm.myideabox.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.ammm.myideabox.domain.Collection;
import jp.co.ammm.myideabox.repository.CollectionRepository;

import org.springframework.ui.Model;

@Controller
@RequestMapping(value="/myideabox")
public class AllCollectionController {
	@Autowired
	CollectionRepository repository;
	@RequestMapping(value = "/collections", method = RequestMethod.GET)
	public String index(Model model) {
		List<Collection> list=repository.findAll();
		model.addAttribute("list", list);
		return "index";
	}
}


// @RequestMapping("/myideabox")
// public class AllCollectionController {

// 	@RequestMapping(value="/collection/all", method = RequestMethod.GET)
// 	public String index(Model model) {
// 		model.addAttribute("msg", "画像たち");
// 		return "index";
// 	}
// }