package example.app.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import example.app.Interface.AccountRepository;
import example.app.form.StaffForm;

@Service
public class AccountUserDetailsService implements UserDetailsService {
	@Autowired
	AccountRepository accountRepository;
//	AccountRepository accountRepository = new AccountRepositoryService();

	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String code) throws UsernameNotFoundException {
		System.out.println(code);
		System.out.println(accountRepository == null);
		StaffForm staffForm = Optional.ofNullable(accountRepository.findByStaffCode(code))
				.orElseThrow(() -> new UsernameNotFoundException("user not found"));
		return new AccountUserDetails(staffForm, getAuthoriites(staffForm));
	}

	private Collection<GrantedAuthority> getAuthoriites(StaffForm staffForm){
		if(staffForm.isAdmin()){
			return AuthorityUtils.createAuthorityList("ROLE_USER","ROLE_ADMIN");
		}else{
			return AuthorityUtils.createAuthorityList("ROLE_USER");
		}
	}
}
