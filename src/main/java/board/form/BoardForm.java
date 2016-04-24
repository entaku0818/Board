package board.form;
import java.util.List;



import org.seasar.struts.annotation.Required;

import board.entity.Board;

public class BoardForm {
	
    public String keyword;

	public String id = "";

	public String name = "";

	public String memo = "";

	public String time = "";

	public List<Board> employees;
	
    public void initialize() {
        keyword = "";
    }


    
}