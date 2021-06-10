<%@page import="me.huypc.dto.error.OrderError"%>
<%@page import="me.huypc.dto.Product"%>
<%@page import="java.util.List"%>
<%@page import="me.huypc.dto.User"%>
<%@page import="me.huypc.dbutil.SD"%>
<!DOCTYPE html>
<html lang="en">
    <%
        User user = (User) session.getAttribute(SD.LOGIN_USER);
        if (user == null) {
            user = new User();
            response.sendRedirect("index.html");
        }
        OrderError error = (OrderError) request.getAttribute(SD.ERROR_ENTITY);
        if (error == null) {
            error = new OrderError();
            error.setMessage("");
        }
        List<Product> productList = (List<Product>) session.getAttribute(SD.USER_CARTS);
        double total = 0;
    %>
    <head>
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
        <script src="scripts/cart.js" defer></script>
        <title>Cart - Web Assignment</title>

    </head>

    <body>
        <header class="container-fluid bg-main mb-4">
            <div class="container bg-main">
                <div class="py-5">
                    <h1>Cart</h1>
                    <p>All the selected products in your cart</p>
                    <p class="text-danger"><%= error.getMessage()%></p>
                </div>
            </div>
        </header>

        <div class="container">
            <div class="d-flex justify-content-between">
                <div>
                    <a href="#" class="btn btn-danger">
                        <i class="fa fa-trash"></i>&nbsp;Clear cart
                    </a>
                </div>
                <div>
                    <a href="#" onclick="clearCart()" class="btn btn-main text-white">
                        <i class="fa fa-shopping-cart"></i>&nbsp;Check out
                    </a>
                </div>
            </div>
            <%
                if (!productList.isEmpty()) {
            %>
            <table class="table">
                <thead>
                    <tr>
                        <th>Product</th>
                        <th>Quantity</th>
                        <th>Unit Price</th>
                        <th>Price</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (Product item : productList) {
                    %>
                    <!-- an order header-->
                    <tr>
                        <td><%= item.getName()%></td>
                        <td><%= item.getAvailable()%></td>
                        <td><%= item.getUnitPrice()%></td>
                        <td><%= item.getPrice()%></td>
                        <td>
                            <form action="MainController" method="POST" class="d-inline">
                                <input hidden name="productId" value="<%= item.getId()%>">
                                <button type="submit" name="action" value="RemoveCart" class="btn btn-danger">
                                    <i class="fa fa-trash"></i>&nbsp;Remove
                                </button>
                                <button type="submit" name="action" value="Plus" class="btn btn-primary">
                                    <i class="fa fa-plus"></i>
                                </button>
                                <button type="submit" name="action" value="Minus" class="btn btn-warning">
                                    <i class="fa fa-minus"></i>
                                </button>
                                <!--                            <a href="#" class="btn btn-danger">
                                                                <i class="fa fa-plus"></i>
                                                            </a>
                                                            <a href="#" class="btn btn-danger">
                                                                <i class="fa fa-minus"></i>
                                                            </a>-->
                            </form>
                        </td>
                    </tr>
                    <!-- end order header-->
                    <%
                            total += item.getPrice();
                        }

                    %>
                    <!-- Grand total-->
                    <tr>
                        <td></td>
                        <td></td>
                        <td><strong>Grand total</strong></td>
                        <td><strong><%= total%></strong></td>
                        <td>
                            <form action="MainController" method="POST">
                                <input hidden name="total" value="<%= total %>">
                                <button type="submit" name="action" value="CheckOut" class="btn btn-main">
                                    <i class="fa fa-shopping-cart"></i>&nbsp;Check out
                                </button>
                            </form>
                        </td>
                    </tr>
                    <!-- end grand total-->
                </tbody>
            </table>
            <%            } else {
            %>
            <h3>You don't have any product in cart</h3>
            <%
                }
            %>

        </div>

        <footer>
        </footer>

    </body>

</html>