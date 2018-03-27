package example.app.form;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class TotleCartForm {
	private List<CartForm> cartList;

	public List<CartForm> getCartList() {
		if(cartList == null){
			cartList = new ArrayList<CartForm>();
		}
		return cartList;
	}

	public void setCartList(List<CartForm> cartList) {
		this.cartList = cartList;
	}

	public void clearCart(){
		cartList = null;
	}
}
