package jp.co.ammm.myideabox.web;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.PathVariable;

import jp.co.ammm.myideabox.domain.Collection;
import jp.co.ammm.myideabox.domain.File;
import jp.co.ammm.myideabox.service.CollectionService;
import jp.co.ammm.myideabox.service.FileUploadService;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/myideabox")
public class AllCollectionController {
	@Autowired
	private CollectionService collectionService;

	@Autowired
	private FileUploadService fileService;

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String index(Model model) {
		List<Collection> list = collectionService.showCollections();
		model.addAttribute("list", list);
		return "main";
	}

	/* Add Item */
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(AddItemForm form, @RequestParam("fileName") MultipartFile upfile) {
		
		/* File Upload */
		File file = new File();
		if (!upfile.isEmpty()) {
			try {
				String filename = upfile.getOriginalFilename();
				Files.copy(upfile.getInputStream(), Paths.get("src/main/resources/static/img/", filename));
				file.setFileName(filename);
				fileService.save(file);
			} catch (IOException | RuntimeException e) {
				e.printStackTrace();
			}
		}
		
		/* Add Title & Text */
		Collection collection = new Collection();
		BeanUtils.copyProperties(form, collection);
		collection.setFile(file);
		collection.setStatus(1);
		collectionService.addCollection(collection);
		return "redirect:/myideabox/collections";
	}

	// /* Show Item Detail */
	// @RequestMapping(value="/detail/{id}")
	// public String showDetail(@PathVariable Integer id, Model model) {
	// 	Collection collection = service.findById(id);
	// 	model.addAttribute("collectionRequest", collection);
	// 	return "redirect:/myideabox/detail/{id}";
	// }

	/* Delete Item */
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		collectionService.delete(id);
		return "redirect:/myideabox/collections";
	}
}
