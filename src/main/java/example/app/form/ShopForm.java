package example.app.form;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class ShopForm {
	private String code;
	private String name;
	private String price;
	private String number;
	private MultipartFile gazou;

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
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public MultipartFile getGazou() {
		return gazou;
	}
	public void setGazou(MultipartFile gazou) {
		this.gazou = gazou;
	}
}
