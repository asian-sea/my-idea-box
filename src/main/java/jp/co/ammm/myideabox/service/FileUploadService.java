package jp.co.ammm.myideabox.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.ammm.myideabox.domain.File;
import jp.co.ammm.myideabox.repository.FileUploadRepository;

@Service
/**
 * FileUploadService
 */
public class FileUploadService {

	@Autowired
	private FileUploadRepository repository;

	public File save(File file) {
		return repository.save(file);
	}
}