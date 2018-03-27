package example.app.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

//画像データをバイト列に変換します。

@Component
public class ByteService {
	public byte[] byteService(MultipartFile gazou){
        if (!gazou.isEmpty()) {
            InputStream is = null;
            try {
                is = gazou.getInputStream();
              byte[] gazouContent = IOUtils.toByteArray(is);
              return gazouContent;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            } finally {
                IOUtils.closeQuietly(is);
            }
        }
        return null;
	}
}
