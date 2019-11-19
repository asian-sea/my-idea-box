package jp.co.ammm.myideabox.web;

import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AddItemForm {
	private Integer id;
	@Column(name="image_path")
	private String imagePath;
	private String title;
	private String text;
}