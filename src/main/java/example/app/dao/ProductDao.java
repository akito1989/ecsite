package example.app.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import example.app.entity.MstProduct;
import example.app.entity.MstProductMapper;
import example.app.form.ProductForm;

@Component
public class ProductDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	//すべての商品情報を取得します
	public List<Map<String,Object>> productList(){
		try{
			//商品一覧
			List<Map<String,Object>> productList  = new ArrayList<>();
			String sql = "SELECT code,name,price,gazou from shop.mst_product";
			return productList = jdbcTemplate.queryForList(sql);
		}catch(DataAccessException e){
			System.out.println("データベース接続に失敗しました");
			return null;
		}
	}

	//指定された商品情報を取得します
	public List<Map<String,Object>> productList(String code){
		try{
			//商品一覧
			List<Map<String,Object>> productList  = new ArrayList<>();
			String sql = "SELECT code,name,price,gazou from shop.mst_product where code=?";
			return productList = jdbcTemplate.queryForList(sql,Integer.parseInt(code));
		}catch(DataAccessException e){
			System.out.println("データベース接続に失敗しました");
			return null;
		}
	}

	//商品情報を登録します
	public void productAdd(MstProduct productEntity){
		try{
			String sql =
					"INSERT INTO shop.mst_product(name,price,gazou)"
					+ "VALUES(?,?,?)";
			jdbcTemplate.update(
					sql,
					productEntity.getName(),
					productEntity.getPrice(),
					productEntity.getGazou()
					);
		}catch(DataAccessException e){
			System.out.println("データベース接続に失敗しました");
		}
	}


	//商品情報を更新します
	public void productUpdate(MstProduct productEntity){
		try{
			String sql = "UPDATE mst_product SET name=?,price=?,gazou=? where code = ?";
			jdbcTemplate.update(
					sql,productEntity.getName(),
					productEntity.getPrice(),
					productEntity.getGazou(),
					productEntity.getCode());
		}catch(DataAccessException e){
			System.out.println("データベース接続に失敗しました");
		}
	}

	//指定された商品情報を削除します
	public void productDelete(ProductForm productForm){
		try{
			String sql = "DELETE FROM mst_product where code = ?";
			jdbcTemplate.update(
					sql,productForm.getCode());
		}catch(DataAccessException e){
			System.out.println("データベース接続に失敗しました");
		}
	}

	//MyBatisを使ってアイテムデータを取得します
    public List<MstProduct> itemList() {

    	List<MstProduct> mpList = new ArrayList<>();
        // resources直下のmybatis-config.xmlを読み込みます(1)
        try (Reader r = Resources.getResourceAsReader("mybatis-config.xml");) {

            // 読み込んだ設定ファイルからSqlSessionFactoryを生成します(2)
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);

            // SQLセッションを取得します(3)
            try (SqlSession session = factory.openSession()) {

                // ActorテーブルのMapperを取得します(4)
                MstProductMapper map = session.getMapper(MstProductMapper.class);
                // Actorテーブルの主キー（actor_id)が１であるレコードを検索します(5)
                mpList = map.selectAll();

          // 取得した内容を確認します
            for(MstProduct product : mpList){
                System.out.println("actor.getActorId    = " + product.getCode());
                System.out.println("actor.getFirstName  = " + product.getName());
                System.out.println("actor.getLastName   = " + product.getPrice());
                System.out.println("actor.getLastUpdate = " + product.getGazou());
            }
                return mpList;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

	//MyBatisを使ってアイテムデータを取得します
    public MstProduct item(String code) {

        // resources直下のmybatis-config.xmlを読み込みます(1)
        try (Reader r = Resources.getResourceAsReader("mybatis-config.xml");) {

            // 読み込んだ設定ファイルからSqlSessionFactoryを生成します(2)
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);

            // SQLセッションを取得します(3)
            try (SqlSession session = factory.openSession()) {

                // mst_productテーブルのMapperを取得します(4)
                MstProductMapper map = session.getMapper(MstProductMapper.class);

                // 引数で渡されたアイテムのコードに一致するレコードを検索します(5)
                return map.selectByPrimaryKey(Integer.parseInt(code));
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
