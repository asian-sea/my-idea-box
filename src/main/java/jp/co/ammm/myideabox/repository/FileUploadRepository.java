package jp.co.ammm.myideabox.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.ammm.myideabox.domain.File;

@Transactional
@Repository
/**
 * FileUploadRepository
 */
public interface FileUploadRepository extends JpaRepository<File, Integer> {

}