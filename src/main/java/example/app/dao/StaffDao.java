package example.app.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import example.app.entity.MstStaff;
import example.app.entity.MstStaffExample;
import example.app.entity.MstStaffMapper;
import example.app.form.StaffAddForm;
import example.app.form.StaffForm;

@Component
public class StaffDao{

	@Autowired
	JdbcTemplate jdbcTemplate;

	//全てのスタッフ情報を取得します
	public List<Map<String,Object>> staffList(){
		try{
			//スタッフ一覧
			List<Map<String,Object>> staffList  = new ArrayList<>();
			String sql= "SELECT * FROM mst_staff";
			staffList = jdbcTemplate.queryForList(sql);
			return staffList;
		}catch(DataAccessException e){
			System.out.println("データベース接続に失敗しました");
			return null;
		}
	}

	//指定されたスタッフ情報を取得します
	public List<Map<String,Object>> staffList(String code){
		try{
			List<Map<String,Object>> staffList  = new ArrayList<>();
			String sql= "SELECT * FROM shop.mst_staff where code = ?";
			staffList = jdbcTemplate.queryForList(sql,code);
			return staffList;
		}catch(DataAccessException e){
			System.out.println("データベース接続に失敗しました");
			return null;
		}
	}

	//スタッフ情報を追加します
	public void staffAdd(StaffAddForm staffAddForm){
		try{
			String sql = "INSERT INTO mst_staff(name,password) VALUES (?,?)";
			jdbcTemplate.update(
					sql,
					staffAddForm.getName(),
					staffAddForm.getPassword());
		}catch(Exception e){
			System.out.println("データベース接続に失敗しました");
		}
	}
	//スタッフ情報を更新します
	public void staffUpdate(StaffAddForm staffAddForm){
		try{
			String sql = "UPDATE mst_staff SET name=?,password=? where code = ?";
			jdbcTemplate.update(
					sql,staffAddForm.getName(),
					staffAddForm.getPassword(),
					staffAddForm.getCode());
		}catch(Exception e){
			System.out.println("データベース接続に失敗しました");
		}
	}

	//スタッフ情報を消去します
	public void staffDelete(StaffForm staffForm){
		try{
			String sql = "Delete from mst_staff where code = ?";
			jdbcTemplate.update(
					sql,
					staffForm.getCode());
		}catch(Exception e){
			System.out.println("データベース接続に失敗しました");
		}
	}

	//MyBatisを使ってログインチェックの為のデータを取得します
    public List<MstStaff> loginCheck(String code, String password) {

    	List<MstStaff> mpList = new ArrayList<>();
        // resources直下のmybatis-config.xmlを読み込みます(1)
        try (Reader r = org.apache.ibatis.io.Resources.getResourceAsReader("mybatis-config.xml");) {

            // 読み込んだ設定ファイルからSqlSessionFactoryを生成します(2)
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);

            // SQLセッションを取得します(3)
            try (SqlSession session = factory.openSession()) {

                // テーブルのMapperを取得します(4)
                MstStaffMapper map = session.getMapper(MstStaffMapper.class);

                //条件検索用のクラスを生成します
                MstStaffExample ex = new MstStaffExample();
                ex.createCriteria().andCodeEqualTo(Integer.parseInt(code)).andPasswordEqualTo(password);

                // テーブルから条件に合致するレコードがあるか検索します
                mpList = map.selectByExample(ex);
                return mpList;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
	}

	//MyBatisを使ってログインチェックの為のデータを取得します
    public MstStaff loginCheck(String code) {

    	// resources直下のmybatis-config.xmlを読み込みます(1)
        try (Reader r = org.apache.ibatis.io.Resources.getResourceAsReader("mybatis-config.xml");) {

            // 読み込んだ設定ファイルからSqlSessionFactoryを生成します(2)
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);

            // SQLセッションを取得します(3)
            try (SqlSession session = factory.openSession()) {

                // テーブルのMapperを取得します(4)
                MstStaffMapper map = session.getMapper(MstStaffMapper.class);

                // テーブルから条件に合致するレコードがあるか検索します
                return map.selectByPrimaryKey(Integer.parseInt(code));
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
	}

}
