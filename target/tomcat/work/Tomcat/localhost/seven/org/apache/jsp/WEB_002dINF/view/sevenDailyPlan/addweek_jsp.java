/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-04-22 07:54:33 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view.sevenDailyPlan;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class addweek_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>菜单管理</title>\r\n");
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
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/fonts/iconfont.css\"/>\r\n");
      out.write("\t\t<style>\r\n");
      out.write("\t\t\t.planBlock{\r\n");
      out.write("\t\t\t\tpadding: 10px 0;\r\n");
      out.write("\t\t\t\tborder: 1px solid #E6E6E6;\r\n");
      out.write("\t\t\t\tposition: relative;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t.planTitle{\r\n");
      out.write("\t\t\t\twidth: 20px;\r\n");
      out.write("\t\t\t\tpadding: 0 20px;\r\n");
      out.write("\t\t\t\ttext-align: center;\r\n");
      out.write("\t\t\t\theight: 76px;\r\n");
      out.write("\t\t\t\tposition: absolute;\r\n");
      out.write("\t\t\t\ttop: 50%;\r\n");
      out.write("\t\t\t\tmargin-top: -38px;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t.tableBlock{\r\n");
      out.write("\t\t\t\tmargin-left: 60px;\r\n");
      out.write("\t\t\t\ttext-align: center;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t.btn{\r\n");
      out.write("\t\t\t\tmargin-left: 60px;\r\n");
      out.write("\t\t\t\tmargin-top: 30px;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t.btn button{\r\n");
      out.write("\t\t\t\theight: 28px;\r\n");
      out.write("\t\t\t\tline-height: 28px;\r\n");
      out.write("\t\t\t\tborder-radius: 8px;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t#table tr{\r\n");
      out.write("\t\t\t\theight: 36px;\r\n");
      out.write("\t\t\t\tline-height: 36px;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t#text{\r\n");
      out.write("\t\t\t\twidth: 400px;\r\n");
      out.write("\t\t\t\theight: 100px;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t.xsbtn{\r\n");
      out.write("\t\t\t\tmargin: 10px 0;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t.xsbtn a{\r\n");
      out.write("\t\t\t\theight: 28px;\r\n");
      out.write("\t\t\t\tline-height: 28px;\r\n");
      out.write("\t\t\t\tborder-radius: 8px;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t.w1200{\r\n");
      out.write("\t\t\t\twidth: 1200px;\r\n");
      out.write("\t\t\t\ttable-layout: fixed;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\ttd{\r\n");
      out.write("\t\t\t\twhite-space: nowrap;\r\n");
      out.write("\t\t\t\ttext-overflow: ellipsis;\r\n");
      out.write("\t\t\t\toverflow: hidden;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t.w60{\r\n");
      out.write("\t\t\t\twidth: 60px;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t.w140{\r\n");
      out.write("\t\t\t\twidth: 140px;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t.w200{\r\n");
      out.write("\t\t\t\twidth: 200px;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"planBlock\">\r\n");
      out.write("\t\t\t<div class=\"planTitle\">计划内容</div>\r\n");
      out.write("\t\t\t<div class=\"tableBlock\">\r\n");
      out.write("\t\t\t\t<table class=\"layui-table w1200\">\r\n");
      out.write("\t\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<th class=\"w60\">序号</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th class=\"w200\">客户名称</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th class=\"w200\">项目名称</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th class=\"w200\">项目内容</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th class=\"w200\">时间安排</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th class=\"w200\">陪同人</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th class=\"w140\">备注</th>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t\t<tbody id=\"table\">\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"w60\"></td><td class=\"w200\"></td><td class=\"w200\"></td><td class=\"w200\"></td><td class=\"w200\"></td><td class=\"w200\"></td><td class=\"w140\"></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"w60\"></td><td class=\"w200\"></td><td class=\"w200\"></td><td class=\"w200\"></td><td class=\"w200\"></td><td class=\"w200\"></td><td class=\"w140\"></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"w60\"></td><td class=\"w200\"></td><td class=\"w200\"></td><td class=\"w200\"></td><td class=\"w200\"></td><td class=\"w200\"></td><td class=\"w140\"></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"w60\"></td><td class=\"w200\"></td><td class=\"w200\"></td><td class=\"w200\"></td><td class=\"w200\"></td><td class=\"w200\"></td><td class=\"w140\"></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"w60\"></td><td class=\"w200\"></td><td class=\"w200\"></td><td class=\"w200\"></td><td class=\"w200\"></td><td class=\"w200\"></td><td class=\"w140\"></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"w60\"></td><td class=\"w200\"></td><td class=\"w200\"></td><td class=\"w200\"></td><td class=\"w200\"></td><td class=\"w200\"></td><td class=\"w140\"></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"w60\"></td><td class=\"w200\"></td><td class=\"w200\"></td><td class=\"w200\"></td><td class=\"w200\"></td><td class=\"w200\"></td><td class=\"w140\"></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"w60\"></td><td class=\"w200\"></td><td class=\"w200\"></td><td class=\"w200\"></td><td class=\"w200\"></td><td class=\"w200\"></td><td class=\"w140\"></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"w60\"></td><td class=\"w200\"></td><td class=\"w200\"></td><td class=\"w200\"></td><td class=\"w200\"></td><td class=\"w200\"></td><td class=\"w140\"></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"w60\"></td><td class=\"w200\"></td><td class=\"w200\"></td><td class=\"w200\"></td><td class=\"w200\"></td><td class=\"w200\"></td><td class=\"w140\"></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"btn\">\r\n");
      out.write("\t\t\t<button class=\"layui-btn layui-btn-normal\" id=\"formDemo\">立即提交</button>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div id=\"text\"  style=\"display: none;\">\r\n");
      out.write("\t\t\t<form class=\"layui-form\" lay-filter=\"formTest\">\r\n");
      out.write("\t\t\t\t<textarea name=\"desc\" placeholder=\"请输入内容\" class=\"layui-textarea\"></textarea>\r\n");
      out.write("\t\t\t\t<div class=\"xsbtn\">\r\n");
      out.write("\t\t\t\t\t<a lay-filter=\"add\" lay-submit class=\"layui-btn layui-btn-xs layui-btn-normal\">保存</a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/js/common/jquery.min.js\"></script>\r\n");
      out.write("\t\t<!-- layui框架js文件 -->\r\n");
      out.write("\t\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/js/common/layui/layui.all.js\"></script>\r\n");
      out.write("\t\t<script>\r\n");
      out.write("\t\t\tlayui.use(['form','layer'], function(){\r\n");
      out.write("\t\t\t\tvar form\t=layui.form;\r\n");
      out.write("\t\t\t\tvar layer\t=layui.layer;\r\n");
      out.write("\t\t\t\t$('#table td').on('click',function(){\r\n");
      out.write("\t\t\t\t\tvar dom=$(this);\r\n");
      out.write("\t\t\t\t\tvar dimStr=dom.text();\r\n");
      out.write("\t\t\t\t\ttext(dimStr);\r\n");
      out.write("\t\t\t\t\tform.on('submit(add)',function(data){\r\n");
      out.write("\t\t\t\t\t\tvar str=data.field.desc;\r\n");
      out.write("\t\t\t\t\t\tdom.text(str);\r\n");
      out.write("\t\t\t\t\t\treturn false\r\n");
      out.write("\t\t\t\t\t})\r\n");
      out.write("\t\t\t\t})\r\n");
      out.write("\t\t\t\tfunction text(dimStr){\r\n");
      out.write("\t\t\t\t\t$('textarea').val(dimStr);\r\n");
      out.write("\t\t\t\t\tlayer.open({\r\n");
      out.write("\t\t\t\t\t  type: 1,\r\n");
      out.write("\t\t\t\t\t  area: ['400px', '200px'],\r\n");
      out.write("\t\t\t\t\t  content: $('#text'),\r\n");
      out.write("\t\t\t\t\t  cancel: function(index, layero){ \r\n");
      out.write("\t\t\t\t\t\t\t$('textarea').val('');\r\n");
      out.write("\t\t\t\t\t\t\tlayer.close(index)\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t$('#formDemo').on('click',function(){\r\n");
      out.write("\t\t\t\t\t$(this).addClass('layui-btn-disabled');\r\n");
      out.write("\t\t\t\t\t$(this).attr('disabled', 'disabled');\r\n");
      out.write("\t\t\t\t\tvar data=new Object();\r\n");
      out.write("\t\t\t\t\tdata.str=$('#table').html();\r\n");
      out.write("\t\t\t\t\tvar url='';\r\n");
      out.write("\t\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\t\turl:url,\r\n");
      out.write("\t\t\t\t\t\tdata:data,\r\n");
      out.write("\t\t\t\t\t\ttype:'post',\r\n");
      out.write("\t\t\t\t\t\tdataType:'json',\r\n");
      out.write("\t\t\t\t\t\tsuccess:function(str){\r\n");
      out.write("\t\t\t\t\t\t\tif(str.status==0){\r\n");
      out.write("\t\t\t\t\t\t\t\tlayer.msg('已提交');\r\n");
      out.write("\t\t\t\t\t\t\t\tsetTimeout(function() {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t$(\"#open\",parent.document).attr('src','../../page/plan/week.html');\r\n");
      out.write("\t\t\t\t\t\t\t\t})\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t})\r\n");
      out.write("\t\t\t\t})\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t</body>\r\n");
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
