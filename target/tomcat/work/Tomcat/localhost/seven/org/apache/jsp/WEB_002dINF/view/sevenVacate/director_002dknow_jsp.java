/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-02-25 03:47:51 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view.sevenVacate;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class director_002dknow_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t<head>\r\n");
      out.write("\t\t<meta name=\"robots\" content=\"noindex, nofollow\">\r\n");
      out.write("\t\t<meta charset=\"utf-8\">\r\n");
      out.write("\t\t<link rel=\"shortcut icon\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/img/favicon.ico\" />\r\n");
      out.write("\t\t<title>请假主管审批</title>\r\n");
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
      out.write("\t\t</style>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body>\r\n");
      out.write("\t\t<!-- 页面内容——开始 -->\r\n");
      out.write("\t\t<div id=\"app\">\r\n");
      out.write("\t\t\t<!-- 表单——开始 -->\r\n");
      out.write("\t\t\t<form class=\"layui-form\" lay-filter=\"formTest\">\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t\t\t<label class=\"layui-form-label\"><span>*</span>审批 : </label>\r\n");
      out.write("\t\t\t\t\t<div class=\"layui-input-block\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"radio\" name=\"vSate\" value=\"2\" title=\"通过\" checked>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"radio\" name=\"vSate\" value=\"-2\" title=\"驳回\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t\t\t<label class=\"layui-form-label\">批语 : </label>\r\n");
      out.write("\t\t\t\t\t<div class=\"layui-input-block\">\r\n");
      out.write("\t\t\t\t\t\t<textarea name=\"vDirector\" placeholder=\"请输入批语\" class=\"layui-textarea\"></textarea>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"zyc_verify\" data-name=\"v_director\"></div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<!-- 提交按钮——开始 -->\r\n");
      out.write("\t\t\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t\t\t<div class=\"layui-input-block\">\r\n");
      out.write("\t\t\t\t\t\t<button lay-filter=\"formDemo\" lay-submit class=\"layui-btn\">立即提交</button>\r\n");
      out.write("\t\t\t\t\t\t<button type=\"reset\" class=\"layui-btn layui-btn-primary\">重置</button>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<!-- 提交按钮——结束 -->\r\n");
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
      out.write("\t\t\t\t\t'operate': '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/sevenVacate/addDirector', //数据提交接口\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tlayui.use(['form', 'laydate', 'element', 'layer'], function() {\r\n");
      out.write("\t\t\t\tvar form = layui.form,\r\n");
      out.write("\t\t\t\t\telement = layui.element,\r\n");
      out.write("\t\t\t\t\tlaydate = layui.laydate,\r\n");
      out.write("\t\t\t\t\tlayer = layui.layer;\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t$.getUrlParam = function(name) { //获取路径中的参数\r\n");
      out.write("\t\t\t\t\tvar reg = new RegExp(\"(^|&)\" + name + \"=([^&]*)(&|$)\");\r\n");
      out.write("\t\t\t\t\tvar r = window.location.search.substr(1).match(reg);\r\n");
      out.write("\t\t\t\t\tif (r != null) return unescape(r[2]);\r\n");
      out.write("\t\t\t\t\treturn null;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tvar id = $.getUrlParam('id'); //获取id\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t//表单提交\r\n");
      out.write("\t\t\t\tform.on('submit(formDemo)', function(data) {\r\n");
      out.write("\t\t\t\t\t//表单提交一次，禁止重复点击\r\n");
      out.write("\t\t\t\t\t$(this).addClass('layui-btn-disabled');\r\n");
      out.write("\t\t\t\t\t$(this).attr('disabled','disabled');\r\n");
      out.write("\t\t\t\t\t//提交数据，data获取的表单数据\r\n");
      out.write("\t\t\t\t\tdata.field.id = id;\r\n");
      out.write("\t\t\t\t\tvar that = $(this);\r\n");
      out.write("\t\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\t\ttype: \"post\",\r\n");
      out.write("\t\t\t\t\t\turl: SCOPE.operate,\r\n");
      out.write("\t\t\t\t\t\tdata: data.field,\r\n");
      out.write("\t\t\t\t\t\tdataType: 'json',\r\n");
      out.write("\t\t\t\t\t\tsuccess: function(result) {\r\n");
      out.write("\t\t\t\t\t\t\t//操作成功，状态（status）返回0\r\n");
      out.write("\t\t\t\t\t\t\tif (result.status == 0) {\r\n");
      out.write("\t\t\t\t\t\t\t\tvar msg = result.msg;//成功提示获取\r\n");
      out.write("\t\t\t\t\t\t\t\tlayer.msg(msg);//成功提示弹框\r\n");
      out.write("\t\t\t\t\t\t\t\t//成功后，300毫秒关闭弹框，重新加载列表页面（对应列表页面cloae方法）\r\n");
      out.write("\t\t\t\t\t\t\t\tsetTimeout(function() {\r\n");
      out.write("\t\t\t\t\t\t\t\t\twindow.parent.cloae();\r\n");
      out.write("\t\t\t\t\t\t\t\t}, 300)\r\n");
      out.write("\t\t\t\t\t\t\t} else if (result.status == 2) { //批量验证数据错误\r\n");
      out.write("\t\t\t\t\t\t\t\t//解除提交按钮禁止点击\r\n");
      out.write("\t\t\t\t\t\t\t\tthat.removeClass('layui-btn-disabled');\r\n");
      out.write("\t\t\t\t\t\t\t\tthat.removeAttr('disabled');\r\n");
      out.write("\t\t\t\t\t\t\t\t//获取批量错误提示\r\n");
      out.write("\t\t\t\t\t\t\t\tvar errors = result.msg;\r\n");
      out.write("\t\t\t\t\t\t\t\t//获取表单提示信息展示位置，并进行对应展示\r\n");
      out.write("\t\t\t\t\t\t\t\t$('.zyc_verify').each(function() {\r\n");
      out.write("\t\t\t\t\t\t\t\t\tvar errorMsg = errors[$(this).data('name')];\r\n");
      out.write("\t\t\t\t\t\t\t\t\t$(this).html(errorMsg != undefined ? '*' + errorMsg : '').css(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t'cssText', 'color: red !important'\r\n");
      out.write("\t\t\t\t\t\t\t\t\t);\r\n");
      out.write("\t\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t\t} else { //其它错误，弹框提示\r\n");
      out.write("\t\t\t\t\t\t\t\t//解除提交按钮禁止点击\r\n");
      out.write("\t\t\t\t\t\t\t\tthat.removeClass('layui-btn-disabled');\r\n");
      out.write("\t\t\t\t\t\t\t\tthat.removeAttr('disabled');\r\n");
      out.write("\t\t\t\t\t\t\t\t//获取错误提示\r\n");
      out.write("\t\t\t\t\t\t\t\tvar msg = result.msg;\r\n");
      out.write("\t\t\t\t\t\t\t\t//弹框提示\r\n");
      out.write("\t\t\t\t\t\t\t\tlayer.msg(msg);\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t\t\r\n");
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
