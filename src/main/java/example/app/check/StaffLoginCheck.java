package example.app.check;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import example.app.dao.StaffDao;
import example.app.form.StaffForm;
import example.app.service.EncryptonService;

@Component
public class StaffLoginCheck {
	@Autowired
	StaffDao staffDao;
	@Autowired
	EncryptonService encryptonService;
	public boolean Check(StaffForm staffForm){
		String code = staffForm.getCode();
		String password = encryptonService.encrypton(staffForm.getPassword());
		if(staffDao.loginCheck(code, password).size() != 0){
			return true;
		}
		return false;
	}
}
