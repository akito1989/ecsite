package example.app.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import example.app.form.StaffForm;

public class AccountUserDetails implements UserDetails {

	private final StaffForm staffForm;
	private final Collection<GrantedAuthority> authorities;


	public AccountUserDetails(StaffForm staffForm, Collection<GrantedAuthority> authorities) {
		super();
		this.staffForm = staffForm;
		this.authorities = authorities;
	}

	@Override
	public String getUsername() {

		return staffForm.getCode();
	}

	@Override
	public String getPassword() {

		return staffForm.getPassword();
	}

	@Override
	public boolean isEnabled() {

		return staffForm.isEnabled();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {

		return true;
	}

	@Override
	public boolean isAccountNonLocked() {

		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}

	public StaffForm getStaffForm() {
		return staffForm;
	}

}
