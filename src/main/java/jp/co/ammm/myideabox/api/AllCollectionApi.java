package jp.co.ammm.myideabox.api;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jp.co.ammm.myideabox.domain.Collection;
import jp.co.ammm.myideabox.service.CollectionService;
import jp.co.ammm.myideabox.web.AddItemForm;

@RestController
@RequestMapping("/api")
public class AllCollectionApi {
	@Autowired
	private CollectionService collectionService;

	// @Autowired
	// private FileUploadService fileService;

	/**
	 * READ API
	 * @return List<Collection>
	 */
	@CrossOrigin
	@GetMapping("/collections")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Collection>> getItems() {
		return new ResponseEntity<List<Collection>>(collectionService.showCollections(), HttpStatus.OK);
	}

	/**
	 * CREATE API
	 * @param id
	 * @return
	 */
	@CrossOrigin
	@PostMapping("/create")
	public ResponseEntity<Collection> create(
		@RequestBody Collection collection,
		// @RequestBody File file,
		AddItemForm form
		// @RequestParam("fileName")
		// MultipartFile upfile
		) {

			// /* File Upload */
			// if(!upfile.isEmpty()) {
			// 	try{
			// 		String filename = upfile.getOriginalFilename();
			// 		Files.copy(upfile.getInputStream(), Paths.get("src/main/app/public/img/", filename));
			// 		file.setFileName(filename);
			// 		fileService.save(file);
			// 	} catch (IOException | RuntimeException e) {
			// 		e.printStackTrace();
			// 	}
			// }

			/* Add Title & Text */
			BeanUtils.copyProperties(form, collection);
			// collection.setFile(file);
			collection.setStatus(1);
			collectionService.addCollection(collection);

			return new ResponseEntity<Collection>(HttpStatus.CREATED);
		}

	/**
	 * DELETE API
	 * @param id
	 * @return
	 */
	@CrossOrigin
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Collection> delete(@PathVariable Integer id) {
		collectionService.delete(id);
		return new ResponseEntity<Collection>(HttpStatus.OK); 
	}
}