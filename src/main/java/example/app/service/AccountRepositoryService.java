package example.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import example.app.Interface.AccountRepository;
import example.app.dao.StaffDao;
import example.app.entity.MstStaff;
import example.app.form.StaffForm;

@Repository
public class AccountRepositoryService implements AccountRepository {
//	@Autowired
//	StaffDao staffDao;
	StaffDao staffDao = new StaffDao();
	@Override
	public StaffForm findByStaffCode(String code) {
		MstStaff mstStaff = staffDao.loginCheck(code);
		StaffForm staffForm = new StaffForm();
		staffForm.setCode(String.valueOf(mstStaff.getCode()));
		staffForm.setName(mstStaff.getName());
		staffForm.setPassword(mstStaff.getPassword());
		return staffForm;
		}
}
