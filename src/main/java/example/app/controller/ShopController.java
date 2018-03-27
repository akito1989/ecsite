package example.app.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import example.app.check.ShopCheck;
import example.app.dao.ProductDao;
import example.app.dao.ShopDao;
import example.app.entity.MstProduct;
import example.app.entity.OrderInfo;
import example.app.form.CartForm;
import example.app.form.CustomerForm;
import example.app.form.DaysForm;
import example.app.form.SessionCartForm;
import example.app.form.ShopForm;
import example.app.form.TotleCartForm;

@Controller
@RequestMapping(value="shop")
public class ShopController {

	@Autowired
	ProductDao productDao;
	@Autowired
	ShopForm shopForm;
	@Autowired
	SessionCartForm sessionCartForm;
	@Autowired
	TotleCartForm totleCartForm;
	@Autowired
	ShopCheck shopCheck;
	@Autowired
	CustomerForm custmerForm;
	@Autowired
	ShopDao shopDao;
	@Autowired
	DaysForm daysForm;

	MstProduct mstProduct = new MstProduct();

	// 買い物ページのトップに遷移します。
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String shopTop(Model model){

		//アイテム一覧を取得し、modelにあげます。
		model.addAttribute("itemList",productDao.itemList());
		ShopForm shopForm = new ShopForm();
		model.addAttribute(shopForm);
		return "shop/shop_list";
	}

	@RequestMapping(value="refer", method=RequestMethod.POST)
	public String shopRefer(@Valid ShopForm shopForm,
			BindingResult result,
			Model model){

		//アイテム一覧を取得し、modelにあげます。
		mstProduct = productDao.item(shopForm.getCode());
		model.addAttribute("item",mstProduct);
		return "shop/shop_refer";
	}

	@RequestMapping(value="refer/{code}",method=RequestMethod.GET)
	@ResponseBody
	public byte[] getGazou(
			@PathVariable("code") int productCode,
			Model model){
		byte[] gazou =  mstProduct.getGazou();
		return gazou;
	}

	//カートに商品を追加します
	@RequestMapping(value="add",method=RequestMethod.POST)
	public String cartAdd(@Valid CartForm cartForm,Model model){
		totleCartForm = sessionCartForm.getTotleCartForm();
		for(CartForm cartList:totleCartForm.getCartList()){
			if(cartList.getCode().equals(cartForm.getCode())){
				model.addAttribute("message","商品は既にカートにあります");
				return "shop/shop_addDone";
			}
		}
		cartForm.setNumber("1");
		totleCartForm.getCartList().add(cartForm);
		sessionCartForm.setTotleCartForm(totleCartForm);
		System.out.println(sessionCartForm.getTotleCartForm().getCartList().get(0).getCode());
		System.out.println("test修了");
		return "shop/shop_addDone";
	}

//	カートの中身を見ます
	@RequestMapping(value="refer",params="cartLook",method=RequestMethod.POST)
	public String cartLook(Model model){
//		List<MstProduct> productList = new ArrayList<>();
//		List<CartForm> cartItems = sessionCartForm.getTotleCartForm().getCartList();
//		for(CartForm cartItem : cartItems){
//			productList.add(productDao.item(cartItem.getCode()));
//		}
//		model.addAttribute("productList",productList);
//		model.addAttribute("shopForm",shopForm);
//		return "shop/shop_cartLook";

		model.addAttribute("cartForm",new CartForm());
		return "shop/shop_cartLook";
	}

//	カートの中身を空にします
	@RequestMapping(value="refer",params="delete",method=RequestMethod.POST)
	public String deleteCart(){
		sessionCartForm.setTotleCartForm(null);;
		return "shop/shop_cartDeleteDone";
	}

//	カートの中身の数量を変更します
	@RequestMapping(value="refer",params="number",method=RequestMethod.POST)
	public String changeCart(
			@Valid CartForm cartForm,
			BindingResult result,
			Model model){

		// 入力された数値を検査します。
		Map<String,String> errorMessages = shopCheck.formNumberCheck(cartForm);
		if(errorMessages.size() != 0){
			model.addAttribute("errorMessages",errorMessages);
			return "shop/shop_cartLook";
		}

		int listNumber = cartForm.getNumbersList().size();
		for(int i = 0; i < listNumber ;i++){
			sessionCartForm.getTotleCartForm().getCartList().get(i).
			setNumber(cartForm.getNumbersList().get(i));
		}
		return "shop/shop_cartLook";
	}

	//顧客情報入力画面に遷移します
	@RequestMapping(value="shopForm", method=RequestMethod.GET)
	public String shopForm(Model model){
		model.addAttribute(custmerForm);
		return "shop/shop_form";
	}

	//顧客情報入力画面からの情報を受け取ります
	@RequestMapping(value="shopForm", method=RequestMethod.POST)
	public String shopFormInfo(
			@Valid CustomerForm customerForm,
			BindingResult bindingResult,
			Model model){
		if(bindingResult.hasErrors()){
			return "/shop/shop_form";
		}

		// 入力された顧客情報を検査します。
		Map<String,String> errorMessages = shopCheck.customerInfoCheck(customerForm);
		if(errorMessages.size() != 0){
			model.addAttribute("errorMessages",errorMessages);
			return "shop/shop_form";
		}

		//顧客情報確認画面に遷移します。
		model.addAttribute("custmerForm",customerForm);
		return "shop/shop_form_check";
	}

	@RequestMapping(value="shopFormDone",method=RequestMethod.POST)
	public String toShopFormDone(
			CustomerForm customerForm,
			Model model){
		shopDao.insertShoppingInfo(customerForm, sessionCartForm);
		return "shop/shop_form_done";

	}

	@RequestMapping(value="orderDownload",method=RequestMethod.GET)
	public String toOrderDownloadPage(Model model){
		model.addAttribute("daysForm",daysForm);
		return "order/order_download";
	}

	@RequestMapping(value="orderDownload",method=RequestMethod.POST)
	public String OrderInfoDownload(
			@Valid DaysForm daysForm,
			BindingResult bindingResult,
			Model model){
		List<OrderInfo> orderInfoList = shopDao.getOrderInfo(daysForm);
        try {

            // 出力ファイルの作成
//            FileWriter f = new FileWriter("C:\\sample\\sample.csv", false);
//            PrintWriter p = new PrintWriter(new BufferedWriter(f));
        	File file = new File("C:\\sample\\sample.csv");
        	PrintWriter p = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
        	        new FileOutputStream(file, false),"Shift_JIS")));

            // ヘッダーを指定する
            p.print("注文コード");
            p.print(",");
            p.print("注文日時");
            p.print(",");
            p.print("会員番号");
            p.print(",");
            p.print("お名前");
            p.print(",");
            p.print("メール");
            p.print(",");
            p.print("郵便番号");
            p.print(",");
            p.print("住所");
            p.print(",");
            p.print("TEL");
            p.print(",");
            p.print("商品コード");
            p.print(",");
            p.print("商品名");
            p.print(",");
            p.print("価格");
            p.print(",");
            p.print("数量");
            p.println();

            // 内容をセットする
            for(OrderInfo orderInfo:orderInfoList){
            	p.print(orderInfo.getCode());
                p.print(",");
            	p.print(orderInfo.getDate());
                p.print(",");
            	p.print(orderInfo.getCodeNumber());
                p.print(",");
            	p.print(orderInfo.getName());
                p.print(",");
            	p.print(orderInfo.getEmail());
                p.print(",");
            	p.print(orderInfo.getPostal1());
                p.print(",");
            	p.print(orderInfo.getPostal2());
                p.print(",");
            	p.print(orderInfo.getAddress());
                p.print(",");
            	p.print(orderInfo.getTel());
                p.print(",");
            	p.print(orderInfo.getCodeSales());
                p.print(",");
            	p.print(orderInfo.getCodeProduct());
                p.print(",");
            	p.print(orderInfo.getPrice());
                p.print(",");
            	p.print(orderInfo.getQuantity());
            	p.println();
            }
            // ファイルに書き出し閉じる
            p.close();

            System.out.println("ファイル出力完了！");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
		return "order/order_download";
	}
}
//Gitのテストです
