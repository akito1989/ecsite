package example.app.form;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionCartForm implements Serializable {

	private static final long serialVersionUID = 1L;

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
