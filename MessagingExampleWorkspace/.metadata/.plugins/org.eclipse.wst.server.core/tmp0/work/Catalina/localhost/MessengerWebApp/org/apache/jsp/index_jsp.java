package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

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

      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("<title>Messenger</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      de.sones.mule.demo.MessageBean msgBean = null;
      synchronized (request) {
        msgBean = (de.sones.mule.demo.MessageBean) _jspx_page_context.getAttribute("msgBean", PageContext.REQUEST_SCOPE);
        if (msgBean == null){
          msgBean = new de.sones.mule.demo.MessageBean();
          _jspx_page_context.setAttribute("msgBean", msgBean, PageContext.REQUEST_SCOPE);
        }
      }
      out.write("\n");
      out.write("\n");
      out.write("<h1>MessengerWebApp</h1>\n");
      out.write("\n");
      out.write("<hr/>\n");
      out.write("\n");
      out.write("\n");
      out.write("<form action=\"index.jsp\" method=\"get\">\n");
      out.write("\t<input type=\"text\" name=\"FromName\" value=\"Anonymous\" style=\"width: 300px; \"/>\n");
      out.write("\t<br/>\n");
      out.write("\t<textarea name=\"MsgText\" style=\"width: 300px; height: 150px\">Enter your message here!</textarea>\n");
      out.write("\t<hr/>\n");
      out.write("\t<input type=\"submit\" value=\"Send\"/>\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("<hr/>\n");
      out.write("\n");


if (request.getParameterNames().hasMoreElements())
{
	msgBean.setUserName(request.getParameter("FromName"));
	msgBean.setMessage(request.getParameter("MsgText"));
	
	String result = msgBean.sendMessage();
	
	if (!result.equals(""))
	{
		out.println( result + "<br/>");		
	}

	out.println("From: " + msgBean.getUserName());
	out.println("<br/>");
	out.println("Message: " + msgBean.getMessage() );
	
	
}

      out.write("\n");
      out.write("\n");
      out.write("<br/>\n");
      out.write("<a href=\"list.jsp\">Show all messages</a>\n");
      out.write("\n");
      out.write("<hr/>\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
