package jp.co.ammm.myideabox.repository;

import jp.co.ammm.myideabox.domain.Collection;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CollectionRepository extends JpaRepository<Collection, Integer> {

}
