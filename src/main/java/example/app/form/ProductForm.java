package example.app.form;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class ProductForm {

	@NotEmpty
	private String code;

	@NotEmpty
	private String name;

	@NotEmpty
	@Pattern(regexp = "^[0-9]+$",message="{price}")
	private String price;

	private MultipartFile gazou;

	private byte[] byteGazou;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public MultipartFile getGazou() {
		return gazou;
	}

	public void setGazou(MultipartFile gazou) {
		this.gazou = gazou;
	}

	public byte[] getByteGazou() {
		return byteGazou;
	}

	public void setByteGazou(byte[] byteGazou) {
		this.byteGazou = byteGazou;
	}
}
