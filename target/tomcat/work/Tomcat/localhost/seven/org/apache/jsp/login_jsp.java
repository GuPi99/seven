/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-04-17 01:13:18 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("\t\t<link rel=\"shortcut icon\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/img/favicon.ico\"/>\r\n");
      out.write("\t\t<title>七所高科销售管理系统</title>\r\n");
      out.write("\t\t<meta name=\"renderer\" content=\"webkit\">\r\n");
      out.write("\t\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\r\n");
      out.write("\t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"http://at.alicdn.com/t/font_1242623_63pmdw5olfb.css\" />\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/css/common/common.css\"/>\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/css/login.css\"/>\r\n");
      out.write("\t\t<style>\r\n");
      out.write("\t\t\t#zyc_login{\r\n");
      out.write("\t\t\t\tbackground: url(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/img/backdrop.png) no-repeat;\r\n");
      out.write("\t\t\t\tbackground-size: 100% 100%;\r\n");
      out.write("\t\t\t\twidth: 100%;\r\n");
      out.write("\t\t\t\theight: 100%;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t.titlebg{\r\n");
      out.write("\t\t\t\twidth: 150px;\r\n");
      out.write("\t\t\t\tbackground: url('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/img/titlebg.png') no-repeat;\r\n");
      out.write("\t\t\t\tbackground-size: 100%;\r\n");
      out.write("\t\t\t\tbackground-position: -11px center;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t</style>\r\n");
      out.write("\t\t<script language=\"JavaScript\">\r\n");
      out.write("\t\t\tif(window != top)\r\n");
      out.write("\t\t\t\ttop.location.href = location.href;\r\n");
      out.write("\t\t\tfunction check(){\r\n");
      out.write("\t\t\t\tvar aAccount=$(\"#aAccount\").val();\r\n");
      out.write("\t\t\t\tvar aPassword=$(\"#aPassword\").val();\r\n");
      out.write("\t\t\t\tvar code=$(\"#captcha\").val();\r\n");
      out.write("\t\t\t\t $.ajax({\r\n");
      out.write("\t\t\t         type: \"POST\",\r\n");
      out.write("\t\t\t         data:{\"aAccount\":aAccount,\"aPassword\":aPassword,\"code\":code},\r\n");
      out.write("\t\t\t         url: \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/sevenAccount/loginCheck\",\r\n");
      out.write("\t\t\t         async: false,\r\n");
      out.write("\t\t\t         success: function(msg){\r\n");
      out.write("\t\t\t            if(msg.status==\"code\"){\r\n");
      out.write("\t\t\t            \talert(msg.msg)\r\n");
      out.write("\t\t\t            \tchangeCpacha() \r\n");
      out.write("\t\t\t            }else if(msg.status==\"pwd\"){\r\n");
      out.write("\t\t\t            \talert(msg.msg)\r\n");
      out.write("\t\t\t            \tchangeCpacha() \r\n");
      out.write("\t\t\t            }else if(msg.status==\"error\"){\r\n");
      out.write("\t\t\t            \talert(msg.msg)\r\n");
      out.write("\t\t\t            \tchangeCpacha() \r\n");
      out.write("\t\t\t            }else if(msg.status==\"200\"){\r\n");
      out.write("\t\t\t            \twindow.location=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/sevenMenus/index\";\r\n");
      out.write("\t\t\t            }\r\n");
      out.write("\t\t\t         }\r\n");
      out.write("\t\t\t     });\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tfunction changeCpacha(){\r\n");
      out.write("\t\t\t\t$(\"#cpacha\").attr(\"src\",'getCpacha?t'+new Date().getTime());\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body>\r\n");
      out.write("\t\t<div id=\"zyc_login\">\r\n");
      out.write("\t\t\t<div id=\"zyc_login_form\">\r\n");
      out.write("\t\t\t\t<div class=\"formBlock\">\r\n");
      out.write("\t\t\t\t\t<div class=\"formTop\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"titlebg\">\r\n");
      out.write("\t\t\t\t\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/img/title.png\"/>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<form class=\"zyc_form\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"zyc_float\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"zyc_left zyc_tag\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<i class=\"iconfont iconzhanghu\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"zyc_left\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" id=\"aAccount\" name=\"aAccount\" class=\"zyc_input zyc_boder_no\" placeholder=\"账户\" />\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"zyc_float\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"zyc_left zyc_tag\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<i class=\"iconfont iconmima\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"zyc_left\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"password\" id=\"aPassword\" name=\"aPassword\" class=\"zyc_input zyc_boder_no\" placeholder=\"密码\" />\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"zyc_float\" id=\"zyc_verify\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"zyc_left\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" name=\"code\"   style=\"vertical-align:bottom\" tabindex='3' id=\"captcha\" pattern=\"[A-z0-9]{4}\" title=\"验证码为4个字符\" autocomplete=\"off\" class=\"zyc_input zyc_boder_no\" placeholder=\"验证码\" />\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"zyc_left\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<img title=\"点击刷新验证码\" id=\"cpacha\" onclick=\"changeCpacha()\" src=\"getCpacha\" style=\"cursor:pointer;vertical-align:bottom\" width=\"100%\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"zyc_float\">\r\n");
      out.write("\t\t\t\t\t\t\t<button style=\"background-color: #1565E2 !important;\" type=\"button\" onclick=\"check()\" id=\"zyc_login_btn\" class=\"zyc_btn zyc_ntn_blue zyc_left\">登 录</button>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<footer id=\"zyc_foot\">\r\n");
      out.write("\t\t\t\t<span>Copyright © 2006-2019 </span><a href=\"javascript:location.reload()\">七所高科 在线办公系统</a>\r\n");
      out.write("\t\t\t</footer>\r\n");
      out.write("\t\t\t<!-- <div id=\"zyc_logo\">\r\n");
      out.write("\t\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/img/logo.png\" />\r\n");
      out.write("\t\t\t\t<span>七所高科 </span>\r\n");
      out.write("\t\t\t\t<span>在线信息化管理平台</span>\r\n");
      out.write("\t\t\t</div> -->\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/js/common/jquery.min.js\"></script>\r\n");
      out.write("\t\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/js/common/layui/lay/modules/layer.js\"></script>\r\n");
      out.write("\t\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/js/common/common.js\"></script>\r\n");
      out.write("\t\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/js/login/index.js\"></script>\r\n");
      out.write("\t</body>\r\n");
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
