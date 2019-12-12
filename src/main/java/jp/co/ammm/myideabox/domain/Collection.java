package jp.co.ammm.myideabox.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.Data;

@Entity
@Data
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
	private File file;
}