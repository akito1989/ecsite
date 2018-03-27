package example.app.check;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import example.app.form.ProductForm;

@Component
public class ProductAddCheck {
	public Map<String, String> check(ProductForm productForm){
		String name = productForm.getName();
		String price = productForm.getPrice();
		Map<String, String> errorMessage = new HashMap<>();

		if(name.equals("")){
			errorMessage.put("name", "商品名の入力は必須です。");
		}
		String regex = "^[0-9]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(price);
		if(matcher.find() == false){
			errorMessage.put("price","価格は半角数字で入力して下さい");
		}
		return errorMessage;
	}
}
