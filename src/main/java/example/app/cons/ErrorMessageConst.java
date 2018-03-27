package example.app.cons;

import org.springframework.stereotype.Component;

//エラーメッセージの定数クラスです
@Component
public class ErrorMessageConst {

	public static String NUMBER_FORMAT_ERROR = "数字で入力して下さい。";
	public static String NUMBER_RANGE_ERROR = "数字は0から100の間で入力して下さい。";
	public static String EMPTY_ERROR = "入力は必須です。";
	public static String MAIL_FORMAT_ERROR = "メールアドレスを正しく入力して下さい。";
	public static String TEL_FORMAT_ERROR = "電話番号を正しく入力して下さい。";
	public static String PASSWORD_MATCH_ERROR = "再入力したパスワードと一致しません。";
}
