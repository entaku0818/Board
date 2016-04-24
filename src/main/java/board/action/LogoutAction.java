package board.action;

import org.seasar.framework.aop.annotation.RemoveSession;
import org.seasar.struts.annotation.Execute;

public class LogoutAction {

	@Execute(validator = false)
	@RemoveSession(name = "userDataDto")
	public String index() {
        return "/?redirect=true";
	}
}
