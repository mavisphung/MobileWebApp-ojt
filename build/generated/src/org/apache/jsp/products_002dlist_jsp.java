package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import me.huypc.dbutil.DbConnection;
import me.huypc.dao.ProductRepository;
import java.util.List;
import me.huypc.dto.Product;
import me.huypc.dto.Product;
import me.huypc.dto.User;
import me.huypc.dbutil.SD;

public final class products_002dlist_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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

            List<Product> list = (List<Product>) session.getAttribute(SD.PRODUCT_LIST);
            if (list == null) {
                ProductRepository pRepo = new ProductRepository(DbConnection.getConnection(), 
                                                    "SELECT * FROM Products");
                list = pRepo.getAll();
                pRepo.close();
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
      out.write("        <!--  <script src=\"../scripts/products-list.js\" defer></script>-->\n");
      out.write("\n");
      out.write("\n");
      out.write("        <title>Products List - Web Assignment</title>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <header class=\"container-fluid bg-main\">\n");
      out.write("            <div class=\"container bg-main d-flex justify-content-between\">\n");
      out.write("                <div class=\"py-4\">\n");
      out.write("                    <h1 class=\"\">Products</h1>\n");
      out.write("                    <p>Add the available products in our store</p>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"py-4\">\n");
      out.write("                    <form action=\"#\">\n");
      out.write("                        <a href=\"cart.html\" class=\"btn btn-white\">\n");
      out.write("                            <i class=\"fa fa-shopping-cart\"></i> View cart\n");
      out.write("                        </a>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </header>\n");
      out.write("\n");
      out.write("        <div class=\"container my-4\">\n");
      out.write("            <div id='product-list' class=\"row row-cols-1 row-cols-sm-2 row-cols-lg-4 g-4\">\n");
      out.write("                ");

                    if (list.isEmpty()) {
                
      out.write("\n");
      out.write("                <h3>There is no product in database</h3>\n");
      out.write("                ");

                } else {
                    for (Product item : list) {

                
      out.write("\n");
      out.write("                <!-- A product-->\n");
      out.write("                <div class=\"col\">\n");
      out.write("                    <div class=\"card\">\n");
      out.write("                        <div class=\"card-header bg-white\">\n");
      out.write("                            <h5>");
      out.print( item.getName() );
      out.write("</h5>\n");
      out.write("                        </div>\n");
      out.write("                        <img src=\"");
      out.print( item.getImageUrl() );
      out.write("\" class=\"card-img-top\" alt=\"");
      out.print( item.getName());
      out.write("\">\n");
      out.write("                        <div class=\"card-body\">\n");
      out.write("                            <p class=\"card-text mb-2\">\n");
      out.write("                                ");
      out.print( item.getDescription());
      out.write("\n");
      out.write("                            </p>\n");
      out.write("                            <p class=\"card-text mb-2\">\n");
      out.write("                                ");
      out.print( item.getUnitPrice());
      out.write(" USD\n");
      out.write("                            </p>\n");
      out.write("                            <p class=\"card-text mb-2\">\n");
      out.write("                                ");
      out.print( item.getAvailable());
      out.write(" units in stock\n");
      out.write("                            </p>\n");
      out.write("                            <form action=\"MainController\">\n");
      out.write("                                <input hidden name=\"id\" value=\"");
      out.print( item.getId() );
      out.write("\">\n");
      out.write("                                <button class=\"btn btn-primary\" type=\"submit\" name=\"action\" value=\"Detail\">\n");
      out.write("                                    <i class=\"fa fa-info-circle\"></i> Detail\n");
      out.write("                                </button>\n");
      out.write("                            </form>\n");
      out.write("<!--                            <a href=\"product-detail.html\" class=\"btn btn-primary\">\n");
      out.write("                                <i class=\"fa fa-info-circle\"></i> Detail\n");
      out.write("                            </a>-->\n");
      out.write("                            <a href=\"#\" class=\"btn btn-warning text-white\">\n");
      out.write("                                <i class=\"fa fa-shopping-cart\"></i> Order Now\n");
      out.write("                            </a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div> \n");
      out.write("                <!-- end product-->\n");
      out.write("                ");
                        }
                    
                    }
                
      out.write("\n");
      out.write("\n");
      out.write("                <!-- A product-->\n");
      out.write("                <!-- <div class=\"col\">\n");
      out.write("                  <div class=\"card\">\n");
      out.write("                    <div class=\"card-header bg-white\">\n");
      out.write("                      <h5>iPhone 8 Plus 64GB PRODUCT RED</h5>\n");
      out.write("                    </div>\n");
      out.write("                    <img src=\"images/iphone8plus.jpg\" class=\"card-img-top w-75\" alt=\"iPhone 8 Plus 64GB PRODUCT RED\">\n");
      out.write("                    <div class=\"card-body\">\n");
      out.write("                      <p class=\"card-text mb-2\">\n");
      out.write("                        A smartphone is a handheld personal computer with a mobile operating system\n");
      out.write("                        and an integrated mobile boardband cellular network connection for voice,\n");
      out.write("                        SMS, and Internet data communication; most, if not all, smartphones also support Wifi\n");
      out.write("                      </p>\n");
      out.write("                      <p class=\"card-text mb-2\">\n");
      out.write("                        1009 USD\n");
      out.write("                      </p>\n");
      out.write("                      <p class=\"card-text mb-2\">\n");
      out.write("                        250 units in stock\n");
      out.write("                      </p>\n");
      out.write("                      <a href=\"product-detail.html\" class=\"btn btn-primary\">\n");
      out.write("                        <i class=\"fa fa-info-circle\"></i> Detail\n");
      out.write("                      </a>\n");
      out.write("                      <a href=\"#\" class=\"btn btn-warning text-white\">\n");
      out.write("                        <i class=\"fa fa-shopping-cart\"></i> Order Now\n");
      out.write("                      </a>\n");
      out.write("                    </div>\n");
      out.write("                  </div>\n");
      out.write("                </div> -->\n");
      out.write("                <!-- end product-->\n");
      out.write("                <!-- A product-->\n");
      out.write("                <!-- <div class=\"col\">\n");
      out.write("                  <div class=\"card\">\n");
      out.write("                    <div class=\"card-header bg-white\">\n");
      out.write("                      <h5>Iphone X</h5>\n");
      out.write("                    </div>\n");
      out.write("                    <img src=\"images/iphonex.jpg\" class=\"card-img-top w-75\" alt=\"Iphone X\">\n");
      out.write("                    <div class=\"card-body\">\n");
      out.write("                      <p class=\"card-text mb-2\">\n");
      out.write("                        A smartphone is a handheld personal computer with a mobile operating system\n");
      out.write("                        and an integrated mobile boardband cellular network connection for voice,\n");
      out.write("                        SMS, and Internet data communication; most, if not all, smartphones also support Wifi\n");
      out.write("                      </p>\n");
      out.write("                      <p class=\"card-text mb-2\">\n");
      out.write("                        1099 USD\n");
      out.write("                      </p>\n");
      out.write("                      <p class=\"card-text mb-2\">\n");
      out.write("                        800 units in stock\n");
      out.write("                      </p>\n");
      out.write("                      <a href=\"product-detail.html\" class=\"btn btn-primary\">\n");
      out.write("                        <i class=\"fa fa-info-circle\"></i> Detail\n");
      out.write("                      </a>\n");
      out.write("                      <a href=\"#\" class=\"btn btn-warning text-white\">\n");
      out.write("                        <i class=\"fa fa-shopping-cart\"></i> Order Now\n");
      out.write("                      </a>\n");
      out.write("                    </div>\n");
      out.write("                  </div>\n");
      out.write("                </div> -->\n");
      out.write("                <!-- end product-->\n");
      out.write("                <!-- A product-->\n");
      out.write("                <!-- <div class=\"col\">\n");
      out.write("                  <div class=\"card\">\n");
      out.write("                    <div class=\"card-header bg-white\">\n");
      out.write("                      <h5>Galaxy S8</h5>\n");
      out.write("                    </div>\n");
      out.write("                    <img src=\"images/galaxys8.jpg\" class=\"card-img-top w-75\" alt=\"Galaxy S8\">\n");
      out.write("                    <div class=\"card-body\">\n");
      out.write("                      <p class=\"card-text mb-2\">\n");
      out.write("                        A smartphone is a handheld personal computer with a mobile operating system\n");
      out.write("                        and an integrated mobile boardband cellular network connection for voice,\n");
      out.write("                        SMS, and Internet data communication; most, if not all, smartphones also support Wifi\n");
      out.write("                      </p>\n");
      out.write("                      <p class=\"card-text mb-2\">\n");
      out.write("                        1099 USD\n");
      out.write("                      </p>\n");
      out.write("                      <p class=\"card-text mb-2\">\n");
      out.write("                        800 units in stock\n");
      out.write("                      </p>\n");
      out.write("                      <a href=\"product-detail.html\" class=\"btn btn-primary\">\n");
      out.write("                        <i class=\"fa fa-info-circle\"></i> Detail\n");
      out.write("                      </a>\n");
      out.write("                      <a href=\"#\" class=\"btn btn-warning text-white\">\n");
      out.write("                        <i class=\"fa fa-shopping-cart\"></i> Order Now\n");
      out.write("                      </a>\n");
      out.write("                    </div>\n");
      out.write("                  </div>\n");
      out.write("                </div> -->\n");
      out.write("                <!-- end product-->\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <footer></footer>\n");
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>\n");
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
