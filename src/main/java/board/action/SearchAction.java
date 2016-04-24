package board.action;



import javax.annotation.Resource;

import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

import board.dto.UserDataDto;
import board.form.BoardForm;
import board.service.EmployeeService;

public class SearchAction {
 
   @ActionForm
   @Resource
   protected BoardForm BoardForm;
   
   @Resource
   protected EmployeeService employeeService;
 
	@Resource
	public UserDataDto userDataDto;
   
   @Resource

   
   @Execute(validator = false)
   public String index() {
       BoardForm.initialize();
       return "index.jsp";
   }
   
   @Execute(validator = false)
   public String search() {
       BoardForm.employees = employeeService.findByMemo(BoardForm.keyword);

       return "result.jsp";
   }
}