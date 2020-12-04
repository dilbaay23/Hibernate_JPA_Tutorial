package udemy_hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="t_image")
public class Image extends BaseEntity{
	
	@Column(name="file_path")
	private String filePAth;
	
	@Column(name="height")
	private int height;
	
	@Column(name="width")
	private int width;

	public String getFilePAth() {
		return filePAth;
	}

	public void setFilePAth(String filePAth) {
		this.filePAth = filePAth;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
	
	

}
