package jp.co.ammm.myideabox.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.ammm.myideabox.domain.Collection;
import jp.co.ammm.myideabox.repository.CollectionRepository;

/**
 * status
 * 1: デフォルト, 0: 削除
 */

@Service
public class CollectionService {
	
	@Autowired
	private CollectionRepository repository;

	@Transactional
	public List<Collection> showCollections() {
		return repository.findCollection();
	}

	public Collection addCollection(Collection collection) {
		return repository.save(collection);
	}

	public void delete(Integer id) {
		repository.delete(id);
	}
}