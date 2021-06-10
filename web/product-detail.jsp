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

            Product item = (Product) request.getAttribute(SD.PRODUCT);
            if (item == null) {
                response.sendRedirect("LogoutController");
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
        <!--  <script src="scripts/detail.js" defer></script>-->
        <title>Product Detail - Web Assignment</title>
    </head>

    <body>
        <header class="container-fluid bg-main">
            <div class="container bg-main">
                <div class="py-4">
                    <h1 class="">Products</h1>
                </div>
            </div>
        </header>
        <div class="container-fluid mt-5">
            <div id="product-detail" class="row">
                <div class="col-12 col-md-6">
                    <img src="<%= item.getImageUrl()%>" alt="<%= item.getName()%>" class="w-100 img-fluid">
                </div>
                <div class="col-12 col-md-6">
                    <legend><%= item.getName()%></legend>
                    <p class="mb-3">
                        <%= item.getDescription()%>
                    </p>
                    <div class="mb-3">
                        <strong>Item code:</strong> &nbsp;
                        <p class="d-inline item-code"><%= item.getId()%></p>
                    </div>
                    <div class="mb-3">
                        <strong>Manufacturer:</strong> &nbsp;
                        <p class="d-inline"><%= item.getManufacturer()%></p>
                    </div>
                    <div class="mb-3">
                        <strong>Category:</strong> &nbsp;
                        <p class="d-inline"><a href="#"><%= item.getCategory()%></a></p>
                    </div>
                    <div class="mb-3">
                        <strong>Available in stock:</strong> &nbsp;
                        <p class="d-inline"><%= item.getAvailable()%></p>
                    </div>
                    <div class="mb-3">
                        <p class="d-inline"><%= item.getUnitPrice()%> USD</p>
                    </div>
                    <div class="mb-3">
                        <a href="products-list.jsp" class="btn btn-main text-decoration-none text-white">
                            <i class="fa fa-backward"></i>&nbsp;Back
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
        </div>
        <footer>
        </footer>

    </body>

</html>