package example.app.Interface;

import example.app.form.StaffForm;

public interface AccountRepository{
	public StaffForm findByStaffCode(String code);

}
