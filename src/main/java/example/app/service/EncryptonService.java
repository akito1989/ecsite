package example.app.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class EncryptonService {
	public String encrypton(String password){
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			byte[] hashBytes = md.digest();
			int[] hashInts = new int[hashBytes.length];
			StringBuilder sb = new StringBuilder();
			for(int i=0; i < hashBytes.length; i++){
				hashInts[i] = (int)hashBytes[i] & 0xff;
				if(hashInts[i] <=15){
					sb.append("0");
				}
				sb.append(Integer.toHexString(hashInts[i]));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return null;
		}
	}

	public String BcryptEncode(String password){
		BCryptPasswordEncoder encorder = new BCryptPasswordEncoder();
		return encorder.encode(password);
	}
}
