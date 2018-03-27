package example.app.check;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import example.app.cons.ErrorMessageConst;
import example.app.form.CartForm;
import example.app.form.CustomerForm;

@Component
public class ShopCheck {
	@Autowired
	ErrorMessageConst errorMessageConst;
	Map<String,String> errorMessages = new HashMap<>();

	//フォームに入力された数字を検査します
	public Map<String,String> formNumberCheck(CartForm cartForm){
		errorMessages.clear();
		List<String> numbersList = cartForm.getNumbersList();

		for(String number:numbersList){
			if(!numberCheck(number)){
				errorMessages.put("number",ErrorMessageConst.NUMBER_FORMAT_ERROR);
			}else{
				int intNum = Integer.parseInt(number);
				if (intNum < 0 || intNum > 100){
					errorMessages.put("numberRange",ErrorMessageConst.NUMBER_RANGE_ERROR);
				}
			}
		}
		return errorMessages;
	}

	//お客様情報が正しく入力されているかを検査します
	public Map<String,String> customerInfoCheck(CustomerForm customerForm){
		errorMessages.clear();
		String name = customerForm.getName();
		String email = customerForm.getEmail();
		String postal1 = customerForm.getPostal1();
		String postal2 = customerForm.getPostal2();
		String address = customerForm.getAddress();
		String tel = customerForm.getTel();
		String chumon = customerForm.getChumon();
		String password = customerForm.getPassword();
		String password2 = customerForm.getPassword2();
		String danjyo = customerForm.getDanjyo();
		String birth = customerForm.getBirth();


		//名前を検査します
		if(name.equals("")){
			errorMessages.put("name",ErrorMessageConst.EMPTY_ERROR);
		}

		//メールアドレスを検査します
		if(email.equals("")){
			errorMessages.put("mail",ErrorMessageConst.EMPTY_ERROR);
		}else if(!emailCheck(email)){
			errorMessages.put("mail",ErrorMessageConst.MAIL_FORMAT_ERROR);
		}

		//郵便番号1を検査します
		if(postal1.equals("")){
			errorMessages.put("postal1",ErrorMessageConst.EMPTY_ERROR);
		}else if(!numberCheck(postal1)){
			errorMessages.put("postal1",ErrorMessageConst.NUMBER_FORMAT_ERROR);
		}

		//郵便番号2を検査します
		if(postal1.equals("")){
			errorMessages.put("postal2",ErrorMessageConst.EMPTY_ERROR);
		}else if(!numberCheck(postal2)){
			errorMessages.put("postal2",ErrorMessageConst.NUMBER_FORMAT_ERROR);
		}

		//住所を検査します
		if(address.equals("")){
			errorMessages.put("address",ErrorMessageConst.EMPTY_ERROR);
		}

		//電話番号を検査します
		if(tel.equals("")){
			errorMessages.put("tel",ErrorMessageConst.EMPTY_ERROR);
		}else if(!telCheck(tel)){
			errorMessages.put("tel",ErrorMessageConst.TEL_FORMAT_ERROR);
		}

		//会員登録する場合の検査です
		if(chumon != null && chumon.equals("2")){
			if(password.equals("")){
				errorMessages.put("password",ErrorMessageConst.EMPTY_ERROR);
			}
			if(!password.equals(password2)){
				errorMessages.put("password",ErrorMessageConst.PASSWORD_MATCH_ERROR);
			}
		}
		return errorMessages;

	}

	//入力内容が数字か検査します
	boolean numberCheck(String number){
		String regex = "^[0-9]+$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(number);
		if(m.matches()){
			return true;
		}
		return false;
	}

	//入力内容が正しいメールアドレスか検査します。
	boolean emailCheck(String email){
		String regex = "^[\\w\\.-]+@[\\w\\.-]+.[a-zA-Z]+$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(email);
		if(m.matches()){
			return true;
		}
		return false;
	}

	//入力内容が正しい電話番号か検査します。
	boolean telCheck(String tel){
		String regex = "^0\\d{1,4}-?\\d{1,4}-?\\d{4}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(tel);
		if(m.matches()){
			return true;
		}
		return false;
	}

}
