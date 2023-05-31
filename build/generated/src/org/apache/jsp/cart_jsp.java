package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class cart_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("        <meta name=\"description\" content=\"Responsive Bootstrap4 Shop Template, Created by Imran Hossain from https://imransdesign.com/\">\r\n");
      out.write("\r\n");
      out.write("        <!-- title -->\r\n");
      out.write("        <title>Cart</title>\r\n");
      out.write("\r\n");
      out.write("        <!-- favicon -->\r\n");
      out.write("        <link rel=\"shortcut icon\" type=\"image/png\" href=\"assets/img/favicon.png\">\r\n");
      out.write("        <!-- google font -->\r\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Open+Sans:300,400,700\" rel=\"stylesheet\">\r\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Poppins:400,700&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("        <!-- fontawesome -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/all.min.css\">\r\n");
      out.write("        <!-- bootstrap -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/bootstrap/css/bootstrap.min.css\">\r\n");
      out.write("        <!-- owl carousel -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/owl.carousel.css\">\r\n");
      out.write("        <!-- magnific popup -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/magnific-popup.css\">\r\n");
      out.write("        <!-- animate css -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/animate.css\">\r\n");
      out.write("        <!-- mean menu css -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/meanmenu.min.css\">\r\n");
      out.write("        <!-- main style -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/main.css\">\r\n");
      out.write("        <!-- responsive -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/responsive.css\">\r\n");
      out.write("\r\n");
      out.write("        <style>\r\n");
      out.write("             .continue-btn{\r\n");
      out.write("                cursor: pointer;\r\n");
      out.write("                border-radius: 30px;\r\n");
      out.write("                background-color: #f28123;\r\n");
      out.write("                color: white;\r\n");
      out.write("                border:none;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .continue-btn:hover{\r\n");
      out.write("                background-color: black;\r\n");
      out.write("                color: #f28123;\r\n");
      out.write("                border: none;\r\n");
      out.write("            }\r\n");
      out.write("        </style>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("\r\n");
      out.write("        <!--PreLoader-->\r\n");
      out.write("        <div class=\"loader\">\r\n");
      out.write("            <div class=\"loader-inner\">\r\n");
      out.write("                <div class=\"circle\"></div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!--PreLoader Ends-->\r\n");
      out.write("\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <!-- search area -->\r\n");
      out.write("            <div class=\"search-area\">\r\n");
      out.write("                <div class=\"container\">\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"col-lg-12\">\r\n");
      out.write("                            <span class=\"close-btn\"><i class=\"fas fa-window-close\"></i></span>\r\n");
      out.write("                            <div class=\"search-bar\">\r\n");
      out.write("                                <div class=\"search-bar-tablecell\">\r\n");
      out.write("                                    <h3>Search For:</h3>\r\n");
      out.write("                                    <form action=\"search-name\" method=\"get\">\r\n");
      out.write("                                        <input type=\"text\" placeholder=\"Search by name...\" name=\"name\">\r\n");
      out.write("                                        <button type=\"submit\">Search <i class=\"fas fa-search\"></i></button>\r\n");
      out.write("                                    </form>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- end search arewa -->\r\n");
      out.write("\r\n");
      out.write("            <!-- breadcrumb-section -->\r\n");
      out.write("            <div class=\"breadcrumb-section breadcrumb-bg\">\r\n");
      out.write("                <div class=\"container\">\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"col-lg-8 offset-lg-2 text-center\">\r\n");
      out.write("                            <div class=\"breadcrumb-text\">\r\n");
      out.write("                                <p>Fresh and Organic</p>\r\n");
      out.write("                                <h1>Cart</h1>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- end breadcrumb section -->\r\n");
      out.write("\r\n");
      out.write("            <!-- cart -->\r\n");
      out.write("            <div class=\"cart-section mt-150 mb-150\">\r\n");
      out.write("                <div class=\"container\">\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"col-lg-8 col-md-12\">\r\n");
      out.write("                            <div class=\"cart-table-wrap\">\r\n");
      out.write("                                <table class=\"cart-table\">\r\n");
      out.write("                                    <thead class=\"cart-table-head\">\r\n");
      out.write("                                        <tr class=\"table-head-row\">\r\n");
      out.write("                                            <th class=\"product-remove\"></th>\r\n");
      out.write("                                            <th class=\"product-image\">Product Image</th>\r\n");
      out.write("                                            <th class=\"product-name\">Name</th>\r\n");
      out.write("                                            <th class=\"product-price\">Price</th>\r\n");
      out.write("                                            <th class=\"product-quantity\">Quantity</th>\r\n");
      out.write("                                            <th class=\"product-total\">Total</th>\r\n");
      out.write("                                        </tr>\r\n");
      out.write("                                    </thead>\r\n");
      out.write("                                    <tbody>\r\n");
      out.write("                                    ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                                        \r\n");
      out.write("                                    </tbody>\r\n");
      out.write("                                    <a href=\"shopping\" class=\"px-4 py-2 continue-btn\">Continue shopping</a>\r\n");
      out.write("                                </table>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"col-lg-4\">\r\n");
      out.write("                            <div class=\"total-section\">\r\n");
      out.write("                                <table class=\"total-table\">\r\n");
      out.write("                                    <thead class=\"total-table-head\">\r\n");
      out.write("                                        <tr class=\"table-total-row\">\r\n");
      out.write("                                            <th>Total</th>\r\n");
      out.write("                                            <th>Price</th>\r\n");
      out.write("                                        </tr>\r\n");
      out.write("                                    </thead>\r\n");
      out.write("                                    <tbody>\r\n");
      out.write("                                        <tr class=\"total-data\">\r\n");
      out.write("                                            <td><strong>Subtotal: </strong></td>\r\n");
      out.write("                                            <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${subtotal}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("$</td>\r\n");
      out.write("                                        </tr>\r\n");
      out.write("<!--                                        <tr class=\"total-data\">\r\n");
      out.write("                                            <td><strong>Shipping: </strong></td>\r\n");
      out.write("                                            <td>$50</td>\r\n");
      out.write("                                        </tr>-->\r\n");
      out.write("                                        <tr class=\"total-data\">\r\n");
      out.write("                                            <td><strong>Total: </strong></td>\r\n");
      out.write("                                            <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${subtotal}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("$</td>\r\n");
      out.write("                                        </tr>\r\n");
      out.write("                                    </tbody>\r\n");
      out.write("                                </table>\r\n");
      out.write("                                <div class=\"cart-buttons\">\r\n");
      out.write("                                    <a href=\"checkout\" class=\"boxed-btn black\">Check Out</a>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"coupon-section\">\r\n");
      out.write("                                <h3>Apply Coupon</h3>\r\n");
      out.write("                                <div class=\"coupon-form-wrap\">\r\n");
      out.write("                                    <form action=\"index.html\">\r\n");
      out.write("                                        <p><input type=\"text\" placeholder=\"Coupon\"></p>\r\n");
      out.write("                                        <p><input type=\"submit\" value=\"Apply\"></p>\r\n");
      out.write("                                    </form>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- end cart -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <!-- jquery -->\r\n");
      out.write("        <script src=\"assets/js/jquery-1.11.3.min.js\"></script>\r\n");
      out.write("        <!-- bootstrap -->\r\n");
      out.write("        <script src=\"assets/bootstrap/js/bootstrap.min.js\"></script>\r\n");
      out.write("        <!-- count down -->\r\n");
      out.write("        <script src=\"assets/js/jquery.countdown.js\"></script>\r\n");
      out.write("        <!-- isotope -->\r\n");
      out.write("        <script src=\"assets/js/jquery.isotope-3.0.6.min.js\"></script>\r\n");
      out.write("        <!-- waypoints -->\r\n");
      out.write("        <script src=\"assets/js/waypoints.js\"></script>\r\n");
      out.write("        <!-- owl carousel -->\r\n");
      out.write("        <script src=\"assets/js/owl.carousel.min.js\"></script>\r\n");
      out.write("        <!-- magnific popup -->\r\n");
      out.write("        <script src=\"assets/js/jquery.magnific-popup.min.js\"></script>\r\n");
      out.write("        <!-- mean menu -->\r\n");
      out.write("        <script src=\"assets/js/jquery.meanmenu.min.js\"></script>\r\n");
      out.write("        <!-- sticker js -->\r\n");
      out.write("        <script src=\"assets/js/sticker.js\"></script>\r\n");
      out.write("        <!-- main js -->\r\n");
      out.write("        <script src=\"assets/js/main.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${items}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("c");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                                        <tr class=\"table-body-row\">\r\n");
          out.write("                                            <td class=\"product-remove\"><a href=\"remove-from-cart?id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${c.product.productID}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"><i class=\"far fa-window-close\"></i></a></td>\r\n");
          out.write("                                            <td class=\"product-image\"><img src=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${c.product.image}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" alt=\"\" style=\"height: 50px; width: 50px;\"></td>\r\n");
          out.write("                                            <td class=\"product-name\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${c.product.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\r\n");
          out.write("                                            <td class=\"product-price\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${c.product.price}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("$</td>\r\n");
          out.write("                                            <td class=\"product-quantity\"><input type=\"number\" readonly placeholder=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${c.quantity}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"></td>\r\n");
          out.write("                                            <td class=\"product-total\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${c.quantity * c.product.price}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("$</td>\r\n");
          out.write("                                        </tr>\r\n");
          out.write("                                    ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}
