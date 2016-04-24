package board.form;

import org.seasar.struts.annotation.Required;

public class LoginForm {
	//idを受け取る
	@Required
	public String userId;

	//パスワードを受け取る
	@Required
	public String password;
}