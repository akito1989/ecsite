package example.app.check;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class ShopCheckTest {

	@Test
	public void numberCheckTest() {
		ShopCheck shopCheck = new ShopCheck();
		assertThat("数字じゃないよ！",shopCheck.numberCheck("12f456"), is(true));
	}

}
