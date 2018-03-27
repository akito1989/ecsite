package example.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import example.app.check.StaffAddCheck;
import example.app.check.StaffLoginCheck;
import example.app.dao.StaffDao;
import example.app.form.StaffAddForm;
import example.app.form.StaffForm;
import example.app.service.EncryptonService;

@Controller
@RequestMapping("staff")
public class StaffController {

	@Autowired
	StaffAddCheck staffAddCheck;
	@Autowired
	StaffDao staffDao;
	@Autowired
	EncryptonService encryptonService;
	@Autowired
	DriverManagerDataSource dataSource;
	@Autowired
	StaffLoginCheck staffLoginCheck;

	//データ格納用のリスト
	List<Map<String,Object>> staffList = new ArrayList<>();

	//スタッフログイン画面へ遷移
	@RequestMapping(path="/login", method = RequestMethod.GET)
	public String staff(Model model){
		StaffForm staffForm = new StaffForm();
		model.addAttribute(staffForm);
		return "staff/staff_login";
	}

//	//スタッフログイン処理
//	@RequestMapping(path="/login", method = RequestMethod.POST)
//	public String staffLogin(
//			@Valid StaffForm staffForm,
//			BindingResult result,
//			Model model)
//	{
//		boolean checkResult = staffLoginCheck.Check(staffForm);
//		if(!checkResult){
//			return "staff/staff_login";
//		}
//		StaffForm sf = new StaffForm();
//		model.addAttribute(sf);
//
//		//スタッフトップ画面に遷移します。
//		return "staff/staff_top";
//	}

//	ログアウト処理
	@RequestMapping( path="logoutSuccess", method = RequestMethod.GET)
	public String logoutSuccess(){
		return "staff/staff_logout";
	}

	//スタッフトップ画面に遷移します。
	@RequestMapping(path="", method = RequestMethod.GET)
	public String staffTop(){
		return "staff/staff_top";
	}
	//スタッフリスト画面へ遷移します
	@RequestMapping(path="list", method = RequestMethod.GET)
	public String staffList(Model model){
		//スタッフ一覧を取得します
		StaffForm  staffForm = new StaffForm();
		model.addAttribute(staffForm);
		model.addAttribute("staffList",staffDao.staffList());
		return "staff/staff_List";
	}

	//スタッフ追加画面に遷移します
	@RequestMapping(params="add", path="edit", method = RequestMethod.POST)
	public String staffAddInput(Model model, StaffForm staffForm){
		StaffAddForm  staffAddForm = new StaffAddForm();
		model.addAttribute(staffAddForm);
		return "staff/staff_add";
	}

//	スタッフ追加処理を行います
	@RequestMapping(path="add", method = RequestMethod.POST)
	public String staffAddReg(
			@Valid StaffAddForm staffAddForm,
			BindingResult result, Model model ){

		//バリデーションチェックをします。
//		if(result.hasErrors()){
//			return "staff/staff_add";
//		}

		//サーバーサイドでも入力内容をチェックします
		Map<String, String> checkResult =  staffAddCheck.check(staffAddForm);
		if(checkResult.size() != 0){
			String message = "エラー発生";
			model.addAttribute(message);
			return "staff/staff_add";
		}

		//パスワードを暗号化します
		String encryptedPass = encryptonService.BcryptEncode(staffAddForm.getPassword());
		System.out.println(encryptedPass);
		staffAddForm.setPassword(encryptedPass);
		staffAddForm.setPassword2(encryptedPass);

		//スタッフ情報を登録します。
		staffDao.staffAdd(staffAddForm);
		return "redirect:list";
	}

//	スタッフ情報修正処理を行います。
	@RequestMapping(params="update",path="edit", method = RequestMethod.POST)
	public String staffListUpdate(Model model,StaffForm staffForm){

		StaffAddForm staffAddForm = new StaffAddForm();
		//指定したスタッフ情報を取得します
		String code = staffForm.getCode();
		if(code == null){
			return "redirect:list";
		}
		staffForm.setName((String)staffDao.staffList(code).get(0).get("name"));
		model.addAttribute(staffForm);
		model.addAttribute(staffAddForm);
		return "staff/staff_update";
	}

	@RequestMapping(path="update", method = RequestMethod.POST)
	public String staffListUpdateExecute(
			@Valid StaffAddForm staffAddForm,
			BindingResult result){

		//バリデーションチェックをします。
		if(result.hasErrors()){
			result = null;
			return "staff/staff_add";
		}

		//サーバーサイドでも入力内容をチェックします
		Map<String, String> checkResult =  staffAddCheck.check(staffAddForm);
		if(checkResult.size() != 0){
			String message = "エラー発生";
			return "staff/staff_add";
		}

		//パスワードを暗号化します
		String encryptedPass = encryptonService.encrypton(staffAddForm.getPassword());
		staffAddForm.setPassword(encryptedPass);
		staffAddForm.setPassword2(encryptedPass);

		//入力したスタッフ情報を登録します。
		staffDao.staffUpdate(staffAddForm);
		return "staff/staff_update_done";
	}

//	スタッフ情報削除処理を行います。
	@RequestMapping(params="delete", path="edit", method = RequestMethod.POST)
	public String staffListDelete(Model model,StaffForm staffForm){
		//指定したスタッフ情報を取得します
		String code = staffForm.getCode();
		if(code == null){
			return "redirect:list";
		}
		staffForm.setName((String)staffDao.staffList(code).get(0).get("name"));
		model.addAttribute(staffForm);
		return "staff/staff_delete";
	}

	@RequestMapping(path="edit/delete", method = RequestMethod.POST)
	public String staffListDeleteExecute(StaffForm staffForm){

		//従業員情報を消去します。
		staffDao.staffDelete(staffForm);
		return "staff/staff_delete_done";
	}

	@RequestMapping(params="refer", path="edit", method = RequestMethod.POST)
	public String staffInfoRefer(Model model, StaffForm staffForm){

		//選択された授業員情報を取得します
		staffList=staffDao.staffList(staffForm.getCode());
		model.addAttribute("staffList",staffList);
		return "staff/staff_refer";
	}


}
