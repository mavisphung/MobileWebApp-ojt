<%-- 
    Document   : add-product
    Created on : Jun 8, 2021, 1:23:39 PM
    Author     : Admin
--%>

<%@page import="me.huypc.dto.User"%>
<%@page import="me.huypc.dbutil.SD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <%
            User user = (User) session.getAttribute(SD.LOGIN_USER);
            if (user == null) {
                user = new User();
                response.sendRedirect("LogoutController");
            }
            
            String notImageFile = (String) request.getAttribute(SD.NOT_IMAGE_FILE);
            if (notImageFile == null) {
                notImageFile = "";
            }
            String addSuccessNotice = (String) request.getAttribute(SD.ADD_SUCCESS);
            if (addSuccessNotice == null) {
                addSuccessNotice = "";
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
        <!--<script src="scripts/add-product.js" defer></script>-->
        <title>Add Product - Web Assignment</title>
        
    </head>
    <body>
        <header class="container-fluid bg-main">
            <div class="container bg-main d-flex justify-content-between">
                <div class="py-4">
                    <p>Hello, <%= user.getFullName() %></p>
                    <h1 class="">Products</h1>
                    <p>Add products</p>
                </div>
                <div class="py-4">
                    <form action="MainController">
                        <button class="btn btn-danger" type="submit" value="Log out" name="action">Log out</button>
                    </form>
                </div>
            </div>
        </header>
        <div class="container mt-4">
            <legend class="m-0">Add new product</legend>
            <p><strong><%= addSuccessNotice %></strong></p>
            <hr class="mb-3 mt-0">
            <form action="MainController" enctype="multipart/form-data" method="POST">
                <div class="row col-12 col-sm-10 col-md-8">
                    <!-- product name-->
                    <div class="row mb-4">
                        <div class="col-12 col-sm-6 col-md-4 line-height-38">
                            <p class="be-right"><strong>Product Name</strong></p>
                        </div>
                        <div class="col-12 col-sm-6 col-md-8 form-group">
                            <input type="text" class="form-control" name="name" required>
                        </div>
                    </div>
                    <!-- end product name-->
                    <!-- unit price -->
                    <div class="row mb-4">
                        <div class="col-12 col-sm-6 col-md-4 line-height-38">
                            <p class="be-right"><strong>Unit Price</strong></p>
                        </div>
                        <div class="col-12 col-sm-6 col-md-8 form-group">
                            <input type="number" class="form-control" name="unitPrice" required>
                        </div>
                    </div>
                    <!-- end unit price -->
                    <!-- unit in stock-->
                    <div class="row mb-4">
                        <div class="col-12 col-sm-6 col-md-4 line-height-38">
                            <p class="be-right"><strong>Units In Stock</strong></p>
                        </div>
                        <div class="col-12 col-sm-6 col-md-8 form-group">
                            <input type="number" class="form-control" name="available" required>
                        </div>
                    </div>
                    <!-- end unit in stock-->
                    <!-- description-->
                    <div class="row mb-4">
                        <div class="col-12 col-sm-6 col-md-4 line-height-38">
                            <p class="be-right"><strong>Description</strong></p>
                        </div>
                        <div class="col-12 col-sm-6 col-md-8 form-group">
                            <textarea rows="5" class="form-control" name="description" required></textarea>
                        </div>
                    </div>
                    <!-- end description-->
                    <!-- Manufacturer-->
                    <div class="row mb-4">
                        <div class="col-12 col-sm-6 col-md-4 line-height-38">
                            <p class="be-right"><strong>Manufacturer</strong></p>
                        </div>
                        <div class="col-12 col-sm-6 col-md-8 form-group">
                            <input type="text" class="form-control" name="manufacturer" required>
                        </div>
                    </div>
                    <!-- end Manufacturer-->
                    <!-- Category-->
                    <div class="row mb-4">
                        <div class="col-12 col-sm-6 col-md-4 line-height-38">
                            <p class="be-right"><strong>Category</strong></p>
                        </div>
                        <div class="col-12 col-sm-6 col-md-8 form-group">
                            <input type="text" class="form-control" name="category" required>
                        </div>
                    </div>
                    <!-- end Category-->
                    <!-- condition-->
                    <div class="row mb-4">
                        <div class="col-12 col-sm-6 col-md-4 line-height-38">
                            <p class="be-right"><strong>Condition</strong></p>
                        </div>
                        <div class="col-12 col-sm-6 col-md-8">
                            <div class="form-check-inline">
                                <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1" value="New" required>
                                <label class="form-check-label" for="flexRadioDefault1">
                                    New
                                </label>
                            </div>
                            <div class="form-check-inline">
                                <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2" value="Old" required>
                                <label class="form-check-label" for="flexRadioDefault2">
                                    Old
                                </label>
                            </div>
                            <div class="form-check-inline">
                                <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault3" value="Refurbished" required>
                                <label class="form-check-label" for="flexRadioDefault3">
                                    Refurbished
                                </label>
                            </div>
                        </div>
                    </div>
                    <!-- end condition-->
                    <!-- product image file-->
                    <div class="row mb-4">
                        <div class="col-12 col-sm-6 col-md-4 line-height-38">
                            <p class="be-right"><strong>Product Image File</strong></p>
                        </div>
                        <div class="col-12 col-sm-6 col-md-8 form-group">
                            <input type="file" class="form-control" name="image" required>
                            <small><%= notImageFile %></small>
                        </div>
                    </div>
                    <!-- end product image file-->
                    <div class="row mb-4">
                        <div class="col-12 offset-sm-6 col-md-8 offset-sm-6 offset-md-4">
                            <button type="submit" class="btn btn-primary" name="action" value="Add Product">Add Product</button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
        <footer>
        </footer>

    </body>

</html>

