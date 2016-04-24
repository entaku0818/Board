package board.form;
 
import org.seasar.struts.annotation.IntegerType;
import org.seasar.struts.annotation.Required;
 
public class PagingForm {
    //ページ番号
    @Required
    @IntegerType
    public String pageno;
}