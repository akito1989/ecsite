package example.app.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import example.app.entity.DatSales;
import example.app.entity.DatSalesMapper;
import example.app.entity.DatSalesProduct;
import example.app.entity.DatSalesProductMapper;
import example.app.entity.OrderInfo;
import example.app.entity.OrderInfoMapper;
import example.app.form.CartForm;
import example.app.form.CustomerForm;
import example.app.form.DaysForm;
import example.app.form.SessionCartForm;

@Repository
public class ShopDao {

	DatSales dat_sales = new DatSales();
	DatSalesProduct dat_sales_Product = new DatSalesProduct();

	public void insertShoppingInfo(
			CustomerForm customerForm,
			SessionCartForm sessionCartForm){
		dat_sales.setCodeNumber(0);
		dat_sales.setName(customerForm.getName());
		dat_sales.setEmail(customerForm.getEmail());
		dat_sales.setPostal1(customerForm.getPostal1());
		dat_sales.setPostal2(customerForm.getPostal2());
		dat_sales.setAddress(customerForm.getAddress());
		dat_sales.setTel(customerForm.getTel());

		// resources直下のmybatis-config.xmlを読み込みます(1)
        try (Reader r = Resources.getResourceAsReader("mybatis-config.xml");) {

            // 読み込んだ設定ファイルからSqlSessionFactoryを生成します(2)
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);

            // SQLセッションを取得します
            try (SqlSession session = factory.openSession()) {

                // mst_productテーブルのMapperを取得します
                DatSalesMapper datSalesMapper = session.getMapper(DatSalesMapper.class);

                // mst_productテーブルのMapperを取得します
                DatSalesProductMapper datSalesProductMapper = session.getMapper(DatSalesProductMapper.class);

                // 購入者情報をDBに登録します
                datSalesMapper.insertAndGetCode(dat_sales);
                session.commit(); //更新系操作をした後はこれが必要


                //上記で登録した購入者情報のcodeを取得します
                int lastInsCode = dat_sales.getCode();

                List<CartForm> cartItemList = sessionCartForm.getTotleCartForm().getCartList();

                for(CartForm cartForm :cartItemList){
                	dat_sales_Product.setCodeSales(lastInsCode);
                	dat_sales_Product.setCodeProduct(Integer.parseInt(cartForm.getCode()));
                	dat_sales_Product.setPrice(Integer.parseInt(cartForm.getPrice()));
                	dat_sales_Product.setQuantity(Integer.parseInt(cartForm.getNumber()));
                	datSalesProductMapper.insertSelective(dat_sales_Product);
                    session.commit();

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	public List<OrderInfo> getOrderInfo(DaysForm daysForm){

		String year = daysForm.getYear();
		String month = daysForm.getMonth();
		String day = daysForm.getDay();

		// resources直下のmybatis-config.xmlを読み込みます(1)
        try (Reader r = Resources.getResourceAsReader("mybatis-config.xml");) {

            // 読み込んだ設定ファイルからSqlSessionFactoryを生成します(2)
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);

            // SQLセッションを取得します
            try (SqlSession session = factory.openSession()) {

            OrderInfoMapper orderInfoMapper = session.getMapper(OrderInfoMapper.class);

            List<OrderInfo> orderInfoList =  orderInfoMapper.getOrederInfo(year, month, day);
            return orderInfoList;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}

