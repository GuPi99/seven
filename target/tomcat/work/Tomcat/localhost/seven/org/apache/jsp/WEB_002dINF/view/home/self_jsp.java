/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-03-10 07:12:39 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view.home;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class self_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write(" \r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<meta name=\"robots\" content=\"noindex, nofollow\">\r\n");
      out.write("\t\t<meta charset=\"utf-8\">\r\n");
      out.write("\t\t<link rel=\"shortcut icon\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/img/favicon.ico\" />\r\n");
      out.write("\t\t<title>我的主页</title>\r\n");
      out.write("\t\t<meta name=\"renderer\" content=\"webkit\">\r\n");
      out.write("\t\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\r\n");
      out.write("\t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">\r\n");
      out.write("\t\t<!-- 图标文件引入 -->\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"http://at.alicdn.com/t/font_1242623_rd4735gfmt.css\" />\r\n");
      out.write("\t\t<!-- css公共样式文件 -->\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/css/common/common.css\" />\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/css/common/page.css\" />\r\n");
      out.write("\t\t<!-- layui框架css文件 -->\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/js/common/layui/css/layui.css\" />\r\n");
      out.write("\t\t<!-- 表单公共样式文件 -->\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/css/form/staff.css\" />\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/css/form/form.css\" />\r\n");
      out.write("\t\t<style>\r\n");
      out.write("\t\t\thtml,body{\r\n");
      out.write("\t\t\t\tbackground-color: #fff;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t#app{\r\n");
      out.write("\t\t\t\tpadding: 15px;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t.layui-form-item{\r\n");
      out.write("\t\t\t\tposition: relative;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t.layui-form-item .zyc_verify{\r\n");
      out.write("\t\t\t\tposition: absolute;\r\n");
      out.write("\t\t\t\ttop: 0;\r\n");
      out.write("\t\t\t\tleft: 350px;\r\n");
      out.write("\t\t\t\tfont-size: 13px;\r\n");
      out.write("\t\t\t\tline-height: 30px;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t.layui-input-block{\r\n");
      out.write("\t\t\t\twidth: 500px !important;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t.layui-input-block input{\r\n");
      out.write("\t\t\t\tborder: none;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t</style>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body>\r\n");
      out.write("\t\t<!-- 页面内容——开始 -->\r\n");
      out.write("\t\t<div id=\"app\">\r\n");
      out.write("\t\t\t<!-- 表单——开始 -->\r\n");
      out.write("\t\t\t<form class=\"layui-form\" lay-filter=\"formTest\">\r\n");
      out.write("\t\t\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t\t\t<label class=\"layui-form-label\"><span>*</span>姓名 : </label>\r\n");
      out.write("\t\t\t\t\t<div class=\"layui-input-block\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"sName\" readonly=\"readonly\" class=\"layui-input\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t\t\t<label class=\"layui-form-label\"><span>*</span>性别 : </label>\r\n");
      out.write("\t\t\t\t\t<div class=\"layui-input-block\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"sex\" readonly=\"readonly\" class=\"layui-input\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t\t\t<label class=\"layui-form-label\"><span>*</span>出生年月 : </label>\r\n");
      out.write("\t\t\t\t\t<div class=\"layui-input-block\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"sDateBirth\" readonly=\"readonly\" class=\"layui-input\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t\t\t<label class=\"layui-form-label\"><span>*</span>电话 : </label>\r\n");
      out.write("\t\t\t\t\t<div class=\"layui-input-block\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"sPhone\" readonly=\"readonly\" class=\"layui-input\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t\t\t<label class=\"layui-form-label\"><span>*</span>邮箱 : </label>\r\n");
      out.write("\t\t\t\t\t<div class=\"layui-input-block\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"sEmail\" readonly=\"readonly\" class=\"layui-input\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t\t\t<label class=\"layui-form-label\"><span>*</span>住址 : </label>\r\n");
      out.write("\t\t\t\t\t<div class=\"layui-input-block\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"sAddress\" readonly=\"readonly\" class=\"layui-input\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t\t<!-- 表单——结束 -->\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- 页面内容——结束 -->\r\n");
      out.write("\t\t<!-- jquery文件 -->\r\n");
      out.write("\t\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/js/common/jquery.min.js\"></script>\r\n");
      out.write("\t\t<!-- layui框架js文件 -->\r\n");
      out.write("\t\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/js/common/layui/layui.all.js\"></script>\r\n");
      out.write("\t\t<script>\r\n");
      out.write("\t\t\tvar SCOPE = {\r\n");
      out.write("\t\t\t\t'value': '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/sevenStaff/selectSevenStaffById',\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tlayui.use(['form', 'laydate'], function() {\r\n");
      out.write("\t\t\t\tvar form = layui.form,\r\n");
      out.write("\t\t\t\t\tlaydate = layui.laydate;\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t$(function() {\r\n");
      out.write("\t\t\t\t\tvar postId = {};\r\n");
      out.write("\t\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\t\ttype: \"get\",\r\n");
      out.write("\t\t\t\t\t\turl: SCOPE.value,\r\n");
      out.write("\t\t\t\t\t\tdata: postId,\r\n");
      out.write("\t\t\t\t\t\tdataType: 'json',\r\n");
      out.write("\t\t\t\t\t\tsuccess: function(result) {\r\n");
      out.write("\t\t\t\t\t\t\tif (result.status == 0) {\r\n");
      out.write("\t\t\t\t\t\t\t\tvar datas = result.data;\r\n");
      out.write("\t\t\t\t\t\t\t\tform.val(\"formTest\", datas);//表单赋值\r\n");
      out.write("\t\t\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t\t\tvar msg = result.msg;\r\n");
      out.write("\t\t\t\t\t\t\t\tlayer.msg(msg);\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t})\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t</body>\r\n");
      out.write("</html>\r\n");
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
