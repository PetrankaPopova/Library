package library.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "sizes")
public class Size extends BaseEntity implements Serializable {

	private int length;
	private int width;
	private int height;
	private int weight;

	public Size() {
	}

	@Column(name = "length")
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	@Column(name = "width")
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	@Column(name = "heigth")
	public int getHeight() {
		return height;
	}

	public void setHeight(int heigth) {
		this.height = heigth;
	}

	@Column(name = "weight")
	public int getWeight() {
		return weight;
	}

	public void setWeight(int weith) {
		this.weight = weith;
	}

}
