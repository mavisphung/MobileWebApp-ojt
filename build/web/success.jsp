<%@page import="me.huypc.dto.OrderHeader"%>
<%@page import="java.util.List"%>
<%@page import="me.huypc.dto.Product"%>
<%@page import="me.huypc.dto.error.OrderError"%>
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
        OrderHeader header = (OrderHeader) session.getAttribute(SD.ORDER_HEADER);
        if (header == null) {
            header = new OrderHeader();
            request.getRequestDispatcher("cart.jsp").forward(request, response);
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
<!--        <script src="../scripts/cart.js" defer></script>-->
        <title>Check out - Web Assignment</title>
    </head>

    <body>
        <header class="container-fluid bg-main mb-4">
            <div class="container bg-main">
                <div class="py-5">
                    <h1 class="">Check out confirmation</h1>
                    <p>Thank you for choosing our services!</p>
                </div>
            </div>
        </header>

        <div class="container">
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
            <form action="MainController" method="POST">
                <input hidden name="orderId" value="<%= header.getId() %>">
                <button type="submit" name="action" value="Confirm" class="btn btn-main text-white w-100">
                    <i class="fa fa-shopping-bag"></i>&nbsp;Confirm
                </button>
            </form>
        </div>

        <footer>
        </footer>

    </body>

</html>