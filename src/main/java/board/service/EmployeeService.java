package board.service;
 
import java.util.List;

import board.entity.Board;
 
public class EmployeeService extends AbstractService<Board> {
    
    public List<Board> selectPerPage(String pageno) {
        final int PER_PAGE = 5;
         return select()
                 .orderBy("id")
                 .limit(PER_PAGE)
                 .offset((Integer.parseInt(pageno)-1)*PER_PAGE)
                 .getResultList();
    }
    public List<Board> findByMemo(String keyword) {
        return select()
        		.where("memo LIKE '%" + keyword + "%'")
                .orderBy("id")
                .getResultList();
    }
}