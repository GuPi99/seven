/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-04-14 10:03:08 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view.sevenCensus;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class xq_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("\t\t<link rel=\"shortcut icon\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/img/favicon.ico\" />\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/fonts/iconfont.css\"/>\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/js/common/layui/css/layui.css\" />\r\n");
      out.write("<style>\r\n");
      out.write("\t\t\t#app{\r\n");
      out.write("\t\t\t\twidth: 1200px;\r\n");
      out.write("\t\t\t\tmargin: 0 auto;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t.left{\r\n");
      out.write("\t\t\t\tfloat: left;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t.right{\r\n");
      out.write("\t\t\t\tfloat: right;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t.clear{\r\n");
      out.write("\t\t\t\tclear: both;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t*{\r\n");
      out.write("\t\t\t\tpadding: 0;\r\n");
      out.write("\t\t\t\tmargin: 0;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\ta{\r\n");
      out.write("\t\t\t\ttext-decoration: none;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tli{\r\n");
      out.write("\t\t\t\tlist-style:none\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t.header{\r\n");
      out.write("\t\t\t\theight: 36px;\r\n");
      out.write("\t\t\t\tline-height: 36px;\r\n");
      out.write("\t\t\t\tbackground: #E3E3E3;\r\n");
      out.write("\t\t\t\tpadding: 5px 0;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t.iconBlock{\r\n");
      out.write("\t\t\t\tpadding-left: 20px;\r\n");
      out.write("\t\t\t\tpadding-right: 10px;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t.icon-jihua{\r\n");
      out.write("\t\t\t\tfont-size: 24px;\r\n");
      out.write("\t\t\t\tcolor: #0183E6;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t.layui-form-item{\r\n");
      out.write("\t\t\t\theight: 28px;\r\n");
      out.write("\t\t\t\twidth: 300px;\r\n");
      out.write("\t\t\t\tclear: initial;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t.layui-input-block{\r\n");
      out.write("\t\t\t\tmin-height: 28px;\r\n");
      out.write("\t\t\t\theight: 28px;\r\n");
      out.write("\t\t\t\tmargin-left: 30px;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t.tooler input{\r\n");
      out.write("\t\t\t\theight: 28px;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t.rili{\r\n");
      out.write("\t\t\t\tposition:relative\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t#test1{\r\n");
      out.write("\t\t\t\tpadding-left: 30px\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t.riliIcon{\r\n");
      out.write("\t\t\t\tposition: absolute;\r\n");
      out.write("\t\t\t\ttop: 7px;\r\n");
      out.write("\t\t\t\tleft: 10px;\r\n");
      out.write("\t\t\t\tcolor: #1C9EFE;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t.tooler{\r\n");
      out.write("\t\t\t\tpadding: 30px 0;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t.searchBlock{\r\n");
      out.write("\t\t\t\tmargin-left: 30px;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t.searchBlock .layui-btn{\r\n");
      out.write("\t\t\t\theight: 28px;\r\n");
      out.write("\t\t\t\tline-height: 28px;\r\n");
      out.write("\t\t\t\tdisplay: block;\r\n");
      out.write("\t\t\t\tborder-radius: 8px;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t.addBtn .layui-btn{\r\n");
      out.write("\t\t\t\theight: 28px;\r\n");
      out.write("\t\t\t\tline-height: 28px;\r\n");
      out.write("\t\t\t\tdisplay: block;\r\n");
      out.write("\t\t\t\tborder-radius: 8px;\r\n");
      out.write("\t\t\t\tmargin-right: 100px;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t.icon-chazhao{\r\n");
      out.write("\t\t\t\tpadding-left: 5px;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t.layui-table-view,\r\n");
      out.write("\t\t\t.layui-table-header{\r\n");
      out.write("\t\t\t\tborder: 0;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t.layui-table-view th{\r\n");
      out.write("\t\t\t\tborder: 0;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t.layui-table thead tr{\r\n");
      out.write("\t\t\t\tbackground: #DEF1FB;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t.layui-table-tool{\r\n");
      out.write("\t\t\t\tborder: 0;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t.layui-table tbody td{\r\n");
      out.write("\t\t\t\tborder-right: 0;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"tooler\">\r\n");
      out.write("\t\t\t<form class=\"layui-form\" action=\"\">\r\n");
      out.write("\t\t\t\t<div class=\"layui-form-item left\">\r\n");
      out.write("\t\t\t\t\t<div class=\"layui-input-block\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"rTitle\" placeholder=\"请输入项目名称\" autocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"searchBlock left\">\r\n");
      out.write("\t\t\t\t\t<button lay-filter=\"formDemo\" lay-submit class=\"layui-btn layui-btn-normal\">\r\n");
      out.write("\t\t\t\t\t\t搜索<i class=\"iconfont icon-chazhao\"></i>\r\n");
      out.write("\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"clear\"></div>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"tabler\">\r\n");
      out.write("\t\t\t<table id=\"demo\" lay-filter=\"test\"></table>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/js/common/jquery.min.js\"></script>\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/js/common/layui/layui.all.js\"></script>\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\tlayui.use(['laydate','form','table','layer'], function(){\r\n");
      out.write("\t\t\tvar laydate = layui.laydate;\r\n");
      out.write("\t\t\tvar form    = layui.form;\r\n");
      out.write("\t\t\tvar table   = layui.table;\r\n");
      out.write("\t\t\tvar layer   = layui.layer;\r\n");
      out.write("\t\t\tlaydate.render({\r\n");
      out.write("\t\t\t\telem: '#test1' //指定元素\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\tform.on('submit(add)',function(data){\r\n");
      out.write("\t\t\t\tlayer.open({\r\n");
      out.write("\t\t\t\t\ttype: 2,\r\n");
      out.write("\t\t\t\t\tcontent:'add.html',\r\n");
      out.write("\t\t\t\t\tarea : ['1200px', '800px'],\r\n");
      out.write("\t\t\t\t\tmaxmin : true,\r\n");
      out.write("\t\t\t\t\ttitle : '添加报告'\r\n");
      out.write("\t\t\t\t})\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t\tvar url='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/sevenBusiness/getSevenBusinessList';\r\n");
      out.write("\t\t\tsearch(url);\r\n");
      out.write("\t\t\tfunction search(url){\r\n");
      out.write("\t\t\t\ttable.render({\r\n");
      out.write("\t\t\t\t\telem: '#demo'\r\n");
      out.write("\t\t\t\t\t,height: 418\r\n");
      out.write("\t\t\t\t\t,url:url\r\n");
      out.write("\t\t\t\t\t,page: true\r\n");
      out.write("\t\t\t\t\t,cols: [[ //表头\r\n");
      out.write("\t\t\t\t\t\t\t{field: 'id', title: '资料种类', width:'5%', sort: true}\r\n");
      out.write("\t\t\t\t\t\t\t,{field: 'title', title: '公文标题', width:'20%'}\r\n");
      out.write("\t\t\t\t\t\t\t,{field: 'dispathNumber', title: '发文工号', width:'15%'}\r\n");
      out.write("\t\t\t\t\t\t\t,{field: 'draftName', title: '拟稿人', width:'20%'} \r\n");
      out.write("\t\t\t\t\t\t\t,{field: 'draftDate', title: '拟稿日期', width: '20%'}\r\n");
      out.write("\t\t\t\t\t\t\t,{field: 'readStatus', title: '查看状态', width: '20%'}\r\n");
      out.write("\t\t\t\t\t\t]]\r\n");
      out.write("\t\t\t\t})\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t})\r\n");
      out.write("\t</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
