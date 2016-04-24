package board.action;

import javax.annotation.Resource;

import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

import board.dto.UserDataDto;
import board.form.LoginForm;
import board.service.LoginService;

public class LoginAction {
	@Resource
	@ActionForm
	public LoginForm loginForm;

	@Resource
	protected UserDataDto userDataDto;

	@Execute(validator = true, input = "/login/index.jsp")
	public String index() {
		// 認証を行うクラス
		LoginService ls = new LoginService();
		String authorisedId=ls.authMethod(loginForm.userId,loginForm.password);

		// Dtoに入れるだけでセッヨンに自動で保持される。
		userDataDto.userId=authorisedId;

		return "/paging/turn/1/?redirect=true";
	}
}