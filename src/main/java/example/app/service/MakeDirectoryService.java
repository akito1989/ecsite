package example.app.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class MakeDirectoryService {
	public File mkdirs(StringBuffer filePath){
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		File uploadDir = new File(filePath.toString(),sdf.format(now));
		//既に存在する場合はプレフィックスをつける
		int prefix = 0;
		while(uploadDir.exists()){
			prefix++;
			uploadDir =
					new File(filePath.toString()+sdf.format(now)+"-" + String.valueOf(prefix) );

		}

		//フォルダ作成
		uploadDir.mkdirs();

		System.out.println("ディレクトリ:" +uploadDir.getPath());
		return uploadDir;

	}
}
