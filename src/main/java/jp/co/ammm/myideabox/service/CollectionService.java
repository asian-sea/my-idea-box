package jp.co.ammm.myideabox.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.ammm.myideabox.domain.Collection;
import jp.co.ammm.myideabox.repository.CollectionRepository;

@Service
public class CollectionService {
	@Autowired
	private CollectionRepository repository;

	public List<Collection> findAll() {
		return repository.findAll();
	}

	public Collection save(Collection collection) {
		return repository.save(collection);
	}

	public Collection findById(Integer id) {
		return repository.findById(id).get();
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}
}