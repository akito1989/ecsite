package example.app.controller;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import example.app.check.ProductAddCheck;
import example.app.dao.ProductDao;
import example.app.entity.MstProduct;
import example.app.entity.MstProductExample;
import example.app.entity.MstProductMapper;
import example.app.form.ProductForm;
import example.app.service.ByteService;
import example.app.service.EncryptonService;
import example.app.service.MakeDirectoryService;


@Controller
@RequestMapping("product")
public class ProductController {

	@Autowired
	ProductAddCheck productAddCheck;
	@Autowired
	ProductDao productDao;
	@Autowired
	EncryptonService encryptonService;
	@Autowired
	DriverManagerDataSource dataSource;
	@Autowired
	MakeDirectoryService mkDirService;
	@Autowired
	ByteService byteService;

	//データ格納用のリスト
	List<Map<String,Object>> productList = new ArrayList<>();

	//商品一覧を表示するメソッド
	@RequestMapping(path="list", method = RequestMethod.GET)
	public String productList(Model model){
		//商品一覧を取得します
//		ProductForm  productForm = new ProductForm();
//		model.addAttribute(productForm);
//		model.addAttribute("productList",productDao.productList());
//		return "product/product_list";

		ProductForm  productForm = new ProductForm();
		model.addAttribute(productForm);
		model.addAttribute("productList",productDao.itemList());
		return "product/product_list";
	}

	//商品情報を追加するページに飛ばすメソッド
	@RequestMapping(params="add", path="edit", method = RequestMethod.POST)
	public String productAddInput(Model model, ProductForm productForm){
		ProductForm  ProductForm = new ProductForm();
		model.addAttribute(productForm);
		return "product/product_add";
	}

	//商品情報を追加するメソッド
	@RequestMapping(path="add", method = RequestMethod.POST)
	public String productAddReg(
			@Valid ProductForm productForm,
			BindingResult result, Model model ){

////		バリデーションチェックをします
//		if(result.hasErrors()){
//			return "product/product_add";
//		}

		//サーバーサイドでも入力内容をチェックします
		Map<String, String> checkResult =  productAddCheck.check(productForm);
		if(checkResult.size() != 0){
			String message = "エラー発生";
			model.addAttribute(message);
			return "product/product_add";
		}

//		//画像情報をアップロードします
//		MultipartFile gazou = productForm.getGazou();
//		String gazouType = gazou.getContentType();
//		String parameterName = gazou.getName();
//		String originalGazouName = gazou.getOriginalFilename();
//		long fileSize = gazou.getSize();
//
//		StringBuffer gazouPath = new StringBuffer("/uploadfile").
//				append(File.separator).append(gazouType);
//
//		File uploadDir = mkDirService.mkdirs(gazouPath);
//
//		try(InputStream content = gazou.getInputStream()){
//
//			// アップロードファイルを置く
//            File uploadFile =
//                    new File(uploadDir.getPath() + "/" + originalGazouName);
//            byte[] bytes = gazou.getBytes();
//            BufferedOutputStream uploadFileStream =
//                    new BufferedOutputStream(new FileOutputStream(uploadFile));
//            uploadFileStream.write(bytes);
//            uploadFileStream.close();
//            System.out.println(uploadDir.getPath() + "/" + originalGazouName);
//            System.out.println("ファイルアップロード成功しました");
//        }
//		catch(Exception e){
//			return "product/product_add";
//		}

//		try{
//			StringBuffer data = new StringBuffer();
//			MultipartFile gazou = productForm.getGazou();
//			InputStream content = gazou.getInputStream();
//			ByteArrayOutputStream os = new ByteArrayOutputStream();
//			byte[] indata = new byte[10240*16];
//	        int siz;
//
//	        //バイト配列に変換
//	        while( ( siz = content.read(indata, 0, indata.length) ) > 0 ) {
//	            os.write( indata, 0, siz );
//	        }
//
//	        //画像データをbase64エンコードする
//	        String base64 = new String(Base64.getEncoder().encodeToString(os.toByteArray()));
//
//	        //画像タイプはJPEG固定
//	        data.append("data:image/jpeg;base64,");
//	        data.append(base64);
//	        System.out.println("Base64:"+data.toString());
//
//			//Entityに商品情報を格納します。
//			ProductEntity productEntity = new ProductEntity();
//			productEntity.setName(productForm.getName());
//			productEntity.setPrice(Integer.parseInt(productForm.getPrice()));
//			productEntity.setGazou(base64.toString());
//
//			//商品情報を登録します。
//			productDao.productAdd(productEntity);
//			return "redirect:list";
//		}catch(Exception e){
//			return "redirect:list";
//		}

		MultipartFile gazou = productForm.getGazou();
		MstProduct entity = new MstProduct();
        entity.setName(productForm.getName());
        entity.setPrice(Integer.parseInt(productForm.getPrice()));
        entity.setGazou(byteService.byteService(gazou));
        productDao.productAdd(entity);
        model.addAttribute("product", entity);
		return "redirect:list";
	}

	@RequestMapping(params="update",path="edit", method = RequestMethod.POST)
	public String productListUpdate(Model model,ProductForm productForm){

		//指定した商品情報を取得します
		String code = productForm.getCode();
		if(code == null){
			return "redirect:list";
		}

		//データ格納用のリスト
		List<Map<String,Object>> productList = new ArrayList<>();
		productList = productDao.productList(code);
		productForm.setName(productList.get(0).get("name").toString());
		productForm.setPrice(productList.get(0).get("price").toString());
		model.addAttribute(productForm);
		model.addAttribute(productForm);
		return "product/product_update";
	}

	@RequestMapping(path="update", method = RequestMethod.POST)
	public String productListUpdateExecute(
			@Valid ProductForm productForm,
			BindingResult result){

		//バリデーションチェックをします。
		if(result.hasErrors()){
			return "product/product_add";
		}

		//サーバーサイドでも入力内容をチェックします
		Map<String, String> checkResult = productAddCheck.check(productForm);
		if(checkResult.size() != 0){
			String message = "エラー発生";
			return "product/product_add";
		}
		MultipartFile gazou = productForm.getGazou();

		//Entityに商品情報を格納します。
		MstProduct productEntity = new MstProduct();
		productEntity.setCode(Integer.parseInt(productForm.getCode()));
		productEntity.setName(productForm.getName());
		productEntity.setPrice(Integer.parseInt(productForm.getPrice()));
		productEntity.setGazou(byteService.byteService(productForm.getGazou()));

		//入力した商品情報を登録します。
		productDao.productUpdate(productEntity);
		return "product/product_update_done";
	}

	@RequestMapping(params="delete", path="edit", method = RequestMethod.POST)
	public String productListDelete(Model model,ProductForm productForm){
		//指定した商品情報を取得します
		String code = productForm.getCode();
		if(code == null){
			return "redirect:list";
		}
		productForm.setName((String)productDao.productList(code).get(0).get("name"));
		model.addAttribute(productForm);
		return "product/product_delete";
	}

	@RequestMapping(path="edit/delete", method = RequestMethod.POST)
	public String productListDeleteExecute(ProductForm productForm){

		//商品情報を消去します。
		productDao.productDelete(productForm);
		return "product/product_delete_done";
	}

	@RequestMapping(params="refer", path="edit", method = RequestMethod.POST)
	public String productInfoRefer(Model model, ProductForm productForm){

		//選択された商品情報を取得します
		String code = productForm.getCode();
		if(code == null){
			return "redirect:list";
		}
		productList=productDao.productList(code);
		model.addAttribute("productList",productList);
		model.addAttribute("code",code);
		return "product/product_refer";
	}

    @RequestMapping(value = "/edit/{code}", method = RequestMethod.GET)
    @ResponseBody
    public byte[] getCover (@PathVariable("code") int productCode) {
//		jdbcテンプレートを使った場合
//    	productList = productDao.productList(String.valueOf(productCode));
//    	return productList.get(0).get("gazou");

//		Mybatisを使った場合
    	// resources直下のmybatis-config.xmlを読み込みます
        try (Reader r = org.apache.ibatis.io.Resources.getResourceAsReader("mybatis-config.xml");) {

            // 読み込んだ設定ファイルからSqlSessionFactoryを生成します
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);

            // SQLセッションを取得します
            try (SqlSession session = factory.openSession()) {

                // mst_productテーブルのMapperを取得します
                MstProductMapper map = session.getMapper(MstProductMapper.class);
                // mst_productテーブルから指定されたcodeに該当するレコードを取得します
                MstProduct mstProduct = map.selectByPrimaryKey(productCode);

                MstProductExample mstProductExample = new MstProductExample();
                mstProductExample.createCriteria().andNameLike("ト%");
                return mstProduct.getGazou();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
}

