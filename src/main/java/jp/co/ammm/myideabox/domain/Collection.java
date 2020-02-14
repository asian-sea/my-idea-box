package jp.co.ammm.myideabox.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString(exclude = {"file"})
@Table(name="collections")
public class Collection {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;

	@Column(name="title")
	private String title;
	@Column(name="text")
	private String text;
	@Column(name="status")
	private Integer status;

	@OneToOne(mappedBy = "collection")
	@JsonManagedReference("Unit")
	private File file;
}