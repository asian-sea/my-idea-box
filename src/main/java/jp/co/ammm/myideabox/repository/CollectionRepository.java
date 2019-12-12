package jp.co.ammm.myideabox.repository;

import jp.co.ammm.myideabox.domain.Collection;

import org.springframework.stereotype.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Transactional
@Repository
public interface CollectionRepository extends JpaRepository<Collection, Integer> {

	
	/* Find All Collections */
	@Transactional
	@Query("SELECT c FROM Collection c JOIN FETCH c.file WHERE c.status=1 ORDER BY c.id DESC")
	public List<Collection> findCollection();
	
	// /* 
	// * Add Collection
	// * status = 1
	// */
	// @Modifying
	// @Transactional
	// @Query(value="INSERT INTO mydb.collections (title, text, status) VALUES(:title, :text, 1)", nativeQuery = true)
	// public Collection save(@Param("title") String title, @Param("text") String text);
	
	/* Delete Collection
	 * status = 0
	 */
	@Modifying
	@Transactional
	@Query(value="UPDATE mydb.collections SET status=0 WHERE id=:id", nativeQuery = true)
	public void delete(@Param("id") Integer id);

}
