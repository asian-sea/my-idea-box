package jp.co.ammm.myideabox.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString(exclude = {"collection"})
@Table(name="files")
public class File {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="file_name")
	private String fileName;

	@OneToOne
	@JsonBackReference("file")
	@JoinColumn(name = "id")
	private Collection collection;

}