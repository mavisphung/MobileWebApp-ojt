<%@page import="me.huypc.dbutil.DbConnection"%>
<%@page import="me.huypc.dao.ProductRepository"%>
<%@page import="java.util.List"%>
<%@page import="me.huypc.dto.Product"%>
<%@page import="me.huypc.dto.Product"%>
<%@page import="me.huypc.dto.User"%>
<%@page import="me.huypc.dbutil.SD"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <%
            User user = (User) session.getAttribute(SD.LOGIN_USER);
            if (user == null) {
                user = new User();
                response.sendRedirect("LogoutController");
            }

            List<Product> list = (List<Product>) session.getAttribute(SD.PRODUCT_LIST);
            if (list == null) {
                ProductRepository pRepo = new ProductRepository(DbConnection.getConnection());
                list = pRepo.getAll();
                pRepo.close();
            }
        %>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="styles/font-awesome.min.css">
        <link rel="stylesheet" href="styles/bootstrap.min.css">
        <link rel="stylesheet" href="styles/site.css">

        <!-- Js-->
        <script src="scripts/jquery-3.6.0.min.js" defer></script>
        <script src="scripts/bootstrap.min.js" defer></script>
        <script src="scripts/scripts.js" defer></script>


        <title>Products List - Web Assignment</title>
    </head>

    <body>
        <header class="container-fluid bg-main">
            <div class="container bg-main d-flex justify-content-between">
                <div class="py-4">
                    <h1 class="">Products</h1>
                    <p>Add the available products in our store</p>
                </div>
                <div class="py-4">
                    <form action="MainController" method="POST">
                        <input hidden name="userId" value="<%= user.getId()%>" >
                        <button type="submit" name="action" value="ViewCart" class="btn btn-white">
                            <i class="fa fa-shopping-cart"></i> View cart
                        </button>
                    </form>
                </div>
            </div>
        </header>

        <div class="container my-4">
            <div id='product-list' class="row row-cols-1 row-cols-sm-2 row-cols-lg-4 g-4">
                <%
                    if (list.isEmpty()) {
                %>
                <h3>There is no product in database</h3>
                <%
                } else {
                    for (Product item : list) {

                %>
                <!-- A product-->
                <div class="col">
                    <div class="card">
                        <div class="card-header bg-white">
                            <h5><%= item.getName()%></h5>
                        </div>
                        <img src="<%= item.getImageUrl()%>" class="card-img-top" alt="<%= item.getName()%>">
                        <div class="card-body">
                            <p class="card-text mb-2">
                                <%= item.getDescription()%>
                            </p>
                            <p class="card-text mb-2">
                                <%= item.getUnitPrice()%> USD
                            </p>
                            <p class="card-text mb-2">
                                <%= item.getAvailable()%> units in stock
                            </p>
                            <a href="MainController?action=Detail&id=<%= item.getId()%>" class="btn btn-primary">
                                <i class="fa fa-info-circle"></i> Detail
                            </a>
                            <span>
                                <form action="MainController" method="POST" class="d-inline">
                                    <input hidden name="id" value="<%= item.getId()%>">
                                    <button type="submit" class="btn btn-warning text-white" name="action" value="Order Now">
                                        <i class="fa fa-shopping-cart"></i> Order Now
                                    </button>
                                </form>
                            </span>
                        </div>
                    </div>
                </div> 
                <!-- end product-->
                <%                        }

                    }
                %>
            </div>
        </div>

        <footer></footer>


    </body>

</html>
