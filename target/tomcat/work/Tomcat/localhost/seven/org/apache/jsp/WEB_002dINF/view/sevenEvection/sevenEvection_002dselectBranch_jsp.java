/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-03-01 05:35:10 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view.sevenEvection;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class sevenEvection_002dselectBranch_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t\t<title>出差部门审批</title>\r\n");
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
      out.write("\t\t\t\t<div class=\"layui-col-sm12\">\r\n");
      out.write("\t\t\t\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t\t\t\t<label class=\"layui-form-label\"><span>*</span>目的 : </label>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"layui-input-block\" style=\"width: 80%;\">\r\n");
      out.write("\t\t\t\t\t\t\t<textarea name=\"eGoal\" placeholder=\"请输入出差目的\" class=\"layui-textarea\"></textarea>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"zyc_verify\" data-name=\"e_goal\"></div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t\t<!-- 表单——结束 -->\r\n");
      out.write("\t\t\t<div class=\"layui-col-sm12\">\r\n");
      out.write("\t\t\t\t<div class=\"layui-tab\" lay-filter=\"demo\">\r\n");
      out.write("\t\t\t\t\t<ul class=\"layui-tab-title\">\r\n");
      out.write("\t\t\t\t\t\t<li data-url=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/sevenVisit/index\" class=\"layui-this\">访问客户</li>\r\n");
      out.write("\t\t\t\t\t\t\t<li data-url=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/sevenPlan/index\">行程安排</li>\r\n");
      out.write("\t\t\t\t\t\t\t<li data-url=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/sevenEvection/toView\">审批进度</li>\r\n");
      out.write("\t\t\t\t\t\t<li id=\"know\" data-url=\"../business/index.html\">出差报告</li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t<div class=\"layui-tab-content\" style=\"height: 600px;\">\r\n");
      out.write("\t\t\t\t\t\t<iframe class=\"zyc_iframe\" width=\"100%\" height=\"100%\" src=\"\" frameborder=\"0\" seamless></iframe>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div style=\"position: absolute;top: 10px;right: 30px;\">\r\n");
      out.write("\t\t\t\t\t<button class=\"layui-btn\" id=\"zyc_refer\">审批</button>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
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
      out.write("/sevenEvection/selectSevenEvection', //编辑时，获取单一数据接口，用以展示编辑数据\r\n");
      out.write("\t\t\t\t'know': '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/sevenEvection/branchKnow', \r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tlayui.use(['form', 'laydate', 'element'], function() {\r\n");
      out.write("\t\t\t    var form = layui.form,\r\n");
      out.write("\t\t\t     element = layui.element,\r\n");
      out.write("\t\t\t     laydate = layui.laydate;\r\n");
      out.write("\t\t\t    \r\n");
      out.write("\t\t\t    $.getUrlParam = function(name) { //获取路径中的参数\r\n");
      out.write("\t\t\t     var reg = new RegExp(\"(^|&)\" + name + \"=([^&]*)(&|$)\");\r\n");
      out.write("\t\t\t     var r = window.location.search.substr(1).match(reg);\r\n");
      out.write("\t\t\t     if (r != null) return unescape(r[2]);\r\n");
      out.write("\t\t\t     return null;\r\n");
      out.write("\t\t\t    }\r\n");
      out.write("\t\t\t    var id = $.getUrlParam('id'); //获取id\r\n");
      out.write("\t\t\t    \r\n");
      out.write("\t\t\t    $(function() {\r\n");
      out.write("\t\t\t     //编辑赋值\r\n");
      out.write("\t\t\t     var postId = {};\r\n");
      out.write("\t\t\t     postId['id'] = id;\r\n");
      out.write("\t\t\t     $.ajax({\r\n");
      out.write("\t\t\t      type: \"get\",\r\n");
      out.write("\t\t\t      url: SCOPE.value,\r\n");
      out.write("\t\t\t      data: postId,\r\n");
      out.write("\t\t\t      dataType: 'json',\r\n");
      out.write("\t\t\t      success: function(result) {\r\n");
      out.write("\t\t\t       if (result.status == 0) {\r\n");
      out.write("\t\t\t        var datas = result.data;\r\n");
      out.write("\t\t\t        form.val(\"formTest\", datas);//表单赋值\r\n");
      out.write("\t\t\t        $('textarea').attr('disabled','disabled');\r\n");
      out.write("\t\t\t        if(datas.eState != 0){\r\n");
      out.write("\t\t\t         $('#zyc_refer').css('display','none');\r\n");
      out.write("\t\t\t        }\r\n");
      out.write("\t\t\t        if(datas.eState < 4){\r\n");
      out.write("\t\t\t         $('#know').css('display','none');\r\n");
      out.write("\t\t\t        }\r\n");
      out.write("\t\t\t        $('.zyc_iframe').attr('src', $('.layui-tab-title>.layui-this').data('url') + '?id=' + id + '&type=1');\r\n");
      out.write("\t\t\t        element.on('tab(demo)', function(data) {\r\n");
      out.write("\t\t\t         $('.zyc_iframe').attr('src', $(this).data('url') + '?id=' + id + '&type=1');\r\n");
      out.write("\t\t\t        });\r\n");
      out.write("\t\t\t       } else {\r\n");
      out.write("\t\t\t        var msg = result.msg;\r\n");
      out.write("\t\t\t        layer.msg(msg);\r\n");
      out.write("\t\t\t       }\r\n");
      out.write("\t\t\t      },\r\n");
      out.write("\t\t\t     });\r\n");
      out.write("\t\t\t    })\r\n");
      out.write("\t\t\t    \r\n");
      out.write("\t\t\t    $('#zyc_refer').click(function(){\r\n");
      out.write("\t\t\t     layer.open({\r\n");
      out.write("\t\t\t      type: 2,\r\n");
      out.write("\t\t\t      title: '审批',\r\n");
      out.write("\t\t\t      anim: 5,\r\n");
      out.write("\t\t\t      content: SCOPE.know+'?id=' + id,\r\n");
      out.write("\t\t\t      area: ['600px', '450px'],\r\n");
      out.write("\t\t\t     });\r\n");
      out.write("\t\t\t    })\r\n");
      out.write("\t\t\t   })\r\n");
      out.write("\t\t\t   //关闭所有弹框，并重新加载当前页面\r\n");
      out.write("\t\t\t   function cloae(){\r\n");
      out.write("\t\t\t    layer.closeAll();\r\n");
      out.write("\t\t\t   }\r\n");
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
