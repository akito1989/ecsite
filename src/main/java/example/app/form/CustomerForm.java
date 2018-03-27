package example.app.form;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Component
public class CustomerForm {

	@NotEmpty
	private String name;
	@NotEmpty
	private String email;
	@NotEmpty
	private String postal1;
	@NotEmpty
	private String postal2;
	@NotEmpty
	private String address;
	@NotEmpty
	private String tel;

//	会員登録する場合の情報
	private String chumon;
	private String password;
	private String password2;
	private String danjyo;
	private String birth;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPostal1() {
		return postal1;
	}
	public void setPostal1(String postal1) {
		this.postal1 = postal1;
	}
	public String getPostal2() {
		return postal2;
	}
	public void setPostal2(String postal2) {
		this.postal2 = postal2;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getChumon() {
		return chumon;
	}
	public void setChumon(String chumon) {
		this.chumon = chumon;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String getDanjyo() {
		return danjyo;
	}
	public void setDanjyo(String danjyo) {
		this.danjyo = danjyo;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
}
