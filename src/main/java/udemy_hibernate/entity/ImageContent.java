package udemy_hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_image_content")
public class ImageContent  {
	
	@Id
	private Long id;
	
	@OneToOne
	@MapsId               // with this annotation , PK(id) of Image instance will be id of ImageContent instance
	private Image image;
	
	
	@Lob
	private byte[] content;

	public byte[] getContent() {
		return content;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}
	
	

}
