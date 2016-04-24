package org.apache.jsp.WEB_002dINF.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class readboard_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(1);
    _jspx_dependants.add("/WEB-INF/view/common/common.jsp");
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\n");
      out.write(" \n");
      out.write("\n");
      out.write("<!-- CSS -->\n");
 String contextRoot = request.getContextPath(); 
      out.write("\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(contextRoot);
      out.write("/css/pager.css\" type=\"text/css\" media=\"all\" />\n");
      out.write("\n");
      out.write("<!-- ページャーリンク押下時動作関数 -->\n");
      out.write("<script type=\"text/javascript\" >\n");
      out.write("function pageLinkClick(val) {\n");
      out.write("document.getElementById(\"pageNo\").value = val;\n");
      out.write("document.pageForm.submit();\n");
      out.write("}\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("<!-- ページャー実装 -->\n");
 
int total = totalCnt;
String curpageStr;
if (request.getParameter("pageNo") != null) {
curpageStr = request.getParameter("pageNo");
} else {
curpageStr = "1";
}
int curpage = Integer.parseInt(curpageStr);
int perpage = 1;
int range = 10;
double start_page = 0;
if (curpage >= Math.ceil(range / 2)) {
start_page = curpage - Math.floor(range / 2);
}
if (start_page < 1) {
start_page = 1;
}
int prev = 0;
if (curpage > start_page) {
prev = curpage - 1;
} else {
prev = 0;
}
int next = 0;
if (curpage < total) {
next = curpage + 1;
} else {
next = 0;
}
double total_pages = Math.ceil(total / perpage);
double start = 0;
double end = 0;
if (curpage > Math.ceil(total_pages - range / 2)) {
start = total_pages - curpage + (Math.ceil(curpage - (range - 1)));
} else {
start = Math.ceil(curpage - (range - 1) / 2) > 1
? Math.ceil(curpage - (range - 1) / 2) : 1;
}
if (total_pages > range) {
end = start + range - 1;
} else {
end = total_pages;
}
java.util.List<String> pageArr = new java.util.ArrayList<String>();
for (int i = (int)start; i <= (int)end; i++) {
if (i > 0) {
pageArr.add(String.valueOf(i));
}
}
 
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else log(t.getMessage(), t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
