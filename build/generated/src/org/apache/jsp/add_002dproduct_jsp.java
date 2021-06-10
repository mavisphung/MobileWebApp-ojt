package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import me.huypc.dto.User;
import me.huypc.dbutil.SD;

public final class add_002dproduct_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        ");

            User user = (User) session.getAttribute(SD.LOGIN_USER);
            if (user == null) {
                user = new User();
                response.sendRedirect("LogoutController");
            }
        
      out.write("\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"styles/font-awesome.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"styles/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"styles/site.css\">\n");
      out.write("\n");
      out.write("        <!-- Js-->\n");
      out.write("        <script src=\"scripts/jquery-3.6.0.min.js\" defer></script>\n");
      out.write("        <script src=\"scripts/bootstrap.min.js\" defer></script>\n");
      out.write("        <script src=\"scripts/scripts.js\" defer></script>\n");
      out.write("        <!--<script src=\"scripts/add-product.js\" defer></script>-->\n");
      out.write("        <title>Add Product - Web Assignment</title>\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <header class=\"container-fluid bg-main\">\n");
      out.write("            <div class=\"container bg-main d-flex justify-content-between\">\n");
      out.write("                <div class=\"py-4\">\n");
      out.write("                    <p>Hello, ");
      out.print( user.getFullName() );
      out.write("</p>\n");
      out.write("                    <h1 class=\"\">Products</h1>\n");
      out.write("                    <p>Add products</p>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"py-4\">\n");
      out.write("                    <form action=\"MainController\">\n");
      out.write("                        <button class=\"btn btn-danger\" type=\"submit\" value=\"Log out\" name=\"action\">Log out</button>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </header>\n");
      out.write("        <div class=\"container mt-4\">\n");
      out.write("            <legend class=\"m-0\">Add new product</legend>\n");
      out.write("            <hr class=\"mb-3 mt-0\">\n");
      out.write("            <form action=\"MainController\" enctype=\"multipart/form-data\" method=\"POST\">\n");
      out.write("                <div class=\"row col-12 col-sm-10 col-md-8\">\n");
      out.write("                    <!-- product name-->\n");
      out.write("                    <div class=\"row mb-4\">\n");
      out.write("                        <div class=\"col-12 col-sm-6 col-md-4 line-height-38\">\n");
      out.write("                            <p class=\"be-right\"><strong>Product Name</strong></p>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-12 col-sm-6 col-md-8 form-group\">\n");
      out.write("                            <input type=\"text\" class=\"form-control\" name=\"name\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- end product name-->\n");
      out.write("                    <!-- unit price -->\n");
      out.write("                    <div class=\"row mb-4\">\n");
      out.write("                        <div class=\"col-12 col-sm-6 col-md-4 line-height-38\">\n");
      out.write("                            <p class=\"be-right\"><strong>Unit Price</strong></p>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-12 col-sm-6 col-md-8 form-group\">\n");
      out.write("                            <input type=\"number\" class=\"form-control\" name=\"unitPrice\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- end unit price -->\n");
      out.write("                    <!-- unit in stock-->\n");
      out.write("                    <div class=\"row mb-4\">\n");
      out.write("                        <div class=\"col-12 col-sm-6 col-md-4 line-height-38\">\n");
      out.write("                            <p class=\"be-right\"><strong>Units In Stock</strong></p>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-12 col-sm-6 col-md-8 form-group\">\n");
      out.write("                            <input type=\"number\" class=\"form-control\" name=\"available\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- end unit in stock-->\n");
      out.write("                    <!-- description-->\n");
      out.write("                    <div class=\"row mb-4\">\n");
      out.write("                        <div class=\"col-12 col-sm-6 col-md-4 line-height-38\">\n");
      out.write("                            <p class=\"be-right\"><strong>Description</strong></p>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-12 col-sm-6 col-md-8 form-group\">\n");
      out.write("                            <textarea rows=\"5\" class=\"form-control\" name=\"description\"></textarea>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- end description-->\n");
      out.write("                    <!-- Manufacturer-->\n");
      out.write("                    <div class=\"row mb-4\">\n");
      out.write("                        <div class=\"col-12 col-sm-6 col-md-4 line-height-38\">\n");
      out.write("                            <p class=\"be-right\"><strong>Manufacturer</strong></p>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-12 col-sm-6 col-md-8 form-group\">\n");
      out.write("                            <input type=\"text\" class=\"form-control\" name=\"manufacturer\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- end Manufacturer-->\n");
      out.write("                    <!-- Category-->\n");
      out.write("                    <div class=\"row mb-4\">\n");
      out.write("                        <div class=\"col-12 col-sm-6 col-md-4 line-height-38\">\n");
      out.write("                            <p class=\"be-right\"><strong>Category</strong></p>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-12 col-sm-6 col-md-8 form-group\">\n");
      out.write("                            <input type=\"text\" class=\"form-control\" name=\"category\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- end Category-->\n");
      out.write("                    <!-- condition-->\n");
      out.write("                    <div class=\"row mb-4\">\n");
      out.write("                        <div class=\"col-12 col-sm-6 col-md-4 line-height-38\">\n");
      out.write("                            <p class=\"be-right\"><strong>Condition</strong></p>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-12 col-sm-6 col-md-8\">\n");
      out.write("                            <div class=\"form-check-inline\">\n");
      out.write("                                <input class=\"form-check-input\" type=\"radio\" name=\"flexRadioDefault\" id=\"flexRadioDefault1\" value=\"New\">\n");
      out.write("                                <label class=\"form-check-label\" for=\"flexRadioDefault1\">\n");
      out.write("                                    New\n");
      out.write("                                </label>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-check-inline\">\n");
      out.write("                                <input class=\"form-check-input\" type=\"radio\" name=\"flexRadioDefault\" id=\"flexRadioDefault2\" value=\"Old\">\n");
      out.write("                                <label class=\"form-check-label\" for=\"flexRadioDefault2\">\n");
      out.write("                                    Old\n");
      out.write("                                </label>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-check-inline\">\n");
      out.write("                                <input class=\"form-check-input\" type=\"radio\" name=\"flexRadioDefault\" id=\"flexRadioDefault3\" value=\"Refurbished\">\n");
      out.write("                                <label class=\"form-check-label\" for=\"flexRadioDefault3\">\n");
      out.write("                                    Refurbished\n");
      out.write("                                </label>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- end condition-->\n");
      out.write("                    <!-- product image file-->\n");
      out.write("                    <div class=\"row mb-4\">\n");
      out.write("                        <div class=\"col-12 col-sm-6 col-md-4 line-height-38\">\n");
      out.write("                            <p class=\"be-right\"><strong>Product Image File</strong></p>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-12 col-sm-6 col-md-8 form-group\">\n");
      out.write("                            <input type=\"file\" class=\"form-control\" multiple name=\"imageUrl\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- end product image file-->\n");
      out.write("                    <div class=\"row mb-4\">\n");
      out.write("                        <div class=\"col-12 offset-sm-6 col-md-8 offset-sm-6 offset-md-4\">\n");
      out.write("                            <button type=\"submit\" class=\"btn btn-primary\" name=\"action\" value=\"Add Product\">Add Product</button>\n");
      out.write("                            <input type=\"submit\" class=\"btn btn-danger\" name=\"action\" value=\"Add Product\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        <footer>\n");
      out.write("        </footer>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
