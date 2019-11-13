package jp.co.ammm.myideabox.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="collections")
public class Collection {
	@Id
	@Column(name="id")
	private Integer id;
	private String imagePath;
	private String title;
	private String text;
	
	//constructor
	public Collection() {}
	public Collection(int id, String imagePath, String title, String text) {
		this.id = id;
		this.imagePath = imagePath;
		this.title = title;
		this.text = text;
	}

	// getter/setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setSrc(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}