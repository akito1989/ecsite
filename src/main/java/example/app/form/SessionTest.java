package example.app.form;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionTest {
	private TotleCartForm totleCartForm;

	public TotleCartForm getTotleCartForm() {
		if(totleCartForm == null){
			return new TotleCartForm();
		}
		return totleCartForm;
	}

	public void setTotleCartForm(TotleCartForm totleCartForm) {
		this.totleCartForm = totleCartForm;
	}

}
