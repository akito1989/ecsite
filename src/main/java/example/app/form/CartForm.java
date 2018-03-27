package example.app.form;

import java.util.List;

public class CartForm {
	String code;
	String name;
	String price;
	String number;
	List<String> numbersList;
	String[] check;
	Boolean checks;
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
	public List<String> getNumbersList() {
		return numbersList;
	}
	public void setNumbersList(List<String> numbersList) {
		this.numbersList = numbersList;
	}
	public String[] getCheck() {
		return check;
	}
	public void setCheck(String[] check) {
		this.check = check;
	}
	public Boolean getChecks() {
		return checks;
	}
	public void setChecks(Boolean checks) {
		this.checks = checks;
	}

}
