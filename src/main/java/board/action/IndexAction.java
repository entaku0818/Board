/*
 * Copyright 2004-2008 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package board.action;



import java.util.List;

import javax.annotation.Resource;

import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

import board.dto.UserDataDto;
import board.entity.Board;
import board.form.PagingForm;
import board.service.EmployeeService;






public class IndexAction {
	@Resource
	public UserDataDto userDataDto;
	
	
    @Execute(validator = false)
	public String index() {
        return "login.jsp";
	}

    


    

    @ActionForm
    @Resource
    protected PagingForm pagingForm;
 
    @Resource
    protected EmployeeService employeeService;
    
    //Employeeテーブル結果セット
    public List<Board>   empItems;
    
    //ページリンク文字列
    public String link;
    
    @Execute(validator = false, urlPattern = "turn/{pageno}")
    public String turn() {
        
        //1ページ当たりのレコード数
        final int PER_PAGE = 2;
        
        //レコードの総件数
        int totalRecNum = (int)employeeService.getCount();
        
        //ページリンク文字列作成
        link = makePagingLink(Integer.parseInt(pagingForm.pageno), totalRecNum, PER_PAGE);
        
        //対象ページ番号(pageno)に表示する分のレコードだけ取得
        //empItems = employeeService.select()
        //    .innerJoin("department")
        //   .orderBy("id")
        //    .limit(PER_PAGE)
        //    .offset((Integer.parseInt(pagingForm.pageno)-1)*PER_PAGE)
        //    .getResultList();
        empItems = employeeService.selectPerPage(pagingForm.pageno);
        
        return "index.jsp";
    }
    
    /**
     * ページリンク文字列(HTML)を返します。
     * @param currentPageNo カレントのページ番号(1 origin)
     * @param totalRecNum 総レコード数
     * @param perPage 1ページ当たりのレコード数
     * @return ページリンク文字列
     */
    private String makePagingLink(int currentPageNo, int totalRecNum, int perPage) {
 
        //総ページ数を求めます。
        int pageNum = totalRecNum / perPage;
        String[] links = new String[pageNum];
        
        for( int i=1; i<=pageNum; i++ ) {
            if( i==currentPageNo ) {
                links[i-1] = String.format("<span class='pagelink-fontsize'><b>%d</b></span>", currentPageNo);
            } else {
                links[i-1] = String.format("<a class='pagelink-fontsize' title='Page %d' href='/Board/paging/turn/%d'>%d</a>", i, i, i);
            }
        }
        return implode(" ", links);
    }
    
    /**
     * 配列要素を文字列により連結する
     * @param glue 連結文字列
     * @param pieces 連結したい文字列の配列。
     * @return すべての配列要素の順序を変えずに、各要素間に glue  文字列をはさんで 1 つの文字列にして返します。
     */
    private static String implode(String glue, String[] pieces) {
        StringBuffer buf = new StringBuffer();
        for( int i=0; ; i++ ) {
            buf.append(pieces[i]);
            if( i == pieces.length -1 ) {
                break;
            }
            buf.append(glue);
        }
        return buf.toString();
}
}