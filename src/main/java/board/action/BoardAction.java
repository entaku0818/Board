package board.action;

import javax.annotation.Resource;

import org.seasar.framework.beans.util.Beans;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

import java.util.List;

import org.seasar.extension.jdbc.JdbcManager;

import board.dto.UserDataDto;
import board.entity.Board;
import board.service.BoardService;
import board.form.BoardForm;

public class BoardAction {

	@Resource
	protected UserDataDto userDataDto;
	
    public List<Board> boardItems;
    
    @ActionForm
    @Resource
    protected BoardForm boardForm;

    @Resource
    protected BoardService boardService;

    public JdbcManager jdbcManager;

    @Execute(validator = false)
    public String index() {
        boardItems = boardService.findAll();

        return "list.jsp";
    }





    @Execute(validator = false, urlPattern = "show")
    public String show() {
        Board entity = boardService.findById();
        Beans.copy(entity, boardForm).dateConverter("yyyy-MM-dd").execute();
        return "show.jsp";
    }

    @Execute(validator = false, urlPattern = "edit")
    public String edit() {
        Board entity = boardService.findById();
        Beans.copy(entity, boardForm).dateConverter("yyyy-MM-dd").execute();
        return "edit.jsp";
    }

    @Execute(validator = false)
    public String create() {
        return "create.jsp";
    }

    @Execute(validator = false, urlPattern = "delete", redirect = true)
    public String delete() {
        Board entity = Beans.createAndCopy(Board.class, boardForm).dateConverter("yyyy-MM-dd").execute();
        boardService.delete(entity);
        return "/board/";
    }
    @Execute(input = "create.jsp", redirect = true)
    public String insert() {
        Board entity = Beans.createAndCopy(Board.class, boardForm).dateConverter("yyyy-MM-dd").execute();
        boardService.insert(entity);
        return "/paging/turn/1";
    }

    @Execute(input = "edit.jsp", redirect = true)
    public String update() {
        Board entity = Beans.createAndCopy(Board.class, boardForm).dateConverter("yyyy-MM-dd").execute();
        boardService.update(entity);
        return "/board/";
    }
}