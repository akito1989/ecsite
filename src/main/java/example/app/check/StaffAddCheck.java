package example.app.check;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import example.app.form.StaffAddForm;

@Component
public class StaffAddCheck {
	public Map<String, String> check(StaffAddForm staffAddForm){
		String name = staffAddForm.getName();
		String password = staffAddForm.getPassword();
		String password2 = staffAddForm.getPassword2();
		Map<String, String> errorMessage = new HashMap<>();

		if(name.equals("")){
			errorMessage.put("name", "名前の入力は必須です。");
		}
		String regex = "[a-z0-9]+";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(password);
		if(matcher.find() == false){
			errorMessage.put("password","パスワードが正しくありません");
		}else if(!password.equals(password2)){
			errorMessage.put("password2","パスワードが一致しません");
		}
		return errorMessage;
	}
}
