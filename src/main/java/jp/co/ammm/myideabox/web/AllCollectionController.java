package jp.co.ammm.myideabox.web;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import jp.co.ammm.myideabox.domain.Collection;
import jp.co.ammm.myideabox.service.CollectionService;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/myideabox")
public class AllCollectionController {
	@Autowired
	CollectionService service;

	@ModelAttribute
	public AddItemForm setUpForm() {
		return new AddItemForm();
	}

	@RequestMapping(value = "/collections", method = RequestMethod.GET)
	public String index(Model model) {
		List<Collection> list = service.findAll();
		model.addAttribute("list", list);
		return "index";
	}

	/* Add Item */
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(@ModelAttribute AddItemForm form) {
		Collection collection = new Collection();
		BeanUtils.copyProperties(form, collection);
		service.save(collection);
		return "redirect:/myideabox/collections";
	}

	/* Show Item Detail */
	@RequestMapping(value="/detail/{id}")
	public String showDetail(@PathVariable Integer id, Model model) {
		Collection collection = service.findById(id);
		model.addAttribute("collectionRequest", collection);
		return "redirect:/myideabox/detail/{id}";
	}

	/* Delete Item */
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		service.delete(id);
		return "redirect:/myideabox/collections";
	}
}