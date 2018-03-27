package example.app.form;

import java.io.Serializable;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

// スタッフ追加フォームのデータを受け取るFormクラスです。
public class StaffAddForm implements Serializable {

	private static final long serialVersionId = 1L;

	@NotEmpty
	private String code;

	@NotEmpty
	private String name;

	@NotEmpty
	@Pattern(regexp="[a-zA-Z0-9]*")
	private String password;

	@NotEmpty
	@Pattern(regexp="[a-zA-Z0-9]*")
	private String password2;


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

}
