<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1" %>
    <%@ page import="models.User" %>

        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link rel="icon" href="images/logo.svg" sizes="36x36">
            <link rel="stylesheet" type="text/css"
                href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
                crossorigin="anonymous">
            <link href="./css/user.css" rel="stylesheet" type="text/css">
            <title>Proyecto CaC</title>
        </head>

        <body>
            <%! User user; %>
                <% user=(User) request.getSession().getAttribute("user"); %>
                    <div id="header">
                        <ul class="nav">
                            <div id="brand">
                                <a href="index.html">
                                    <img src="images/logo.svg" width="28px" alt="Codo a codo">
                                </a>
                            </div>
                            <div class="menu">
                                <li><a href="index.html">Inicio</a></li>
                                <li><a href="">Servicios</a>
                                    <ul class="toggle-menu">
                                        <li><a href="">Venta</a></li>
                                        <li><a href="">Colocación</a></li>
                                        <li><a href="">Reparación</a></li>
                                        <li><a href="">Pedidos</a>
                                            <ul class="toggle-menu">
                                                <li><a href="user">Ingresar</a></li>
                                                <li><a href="user">Consultar</a></li>
                                            </ul>
                                        </li>
                                    </ul>
                                </li>
                                <li><a href="">Acerca de</a>
                                    <ul class="toggle-menu">
                                        <li><a href="">Nosotros</a></li>
                                        <li><a href="">Nuestra misión</a></li>
                                        <li><a href="">Historia</a></li>
                                    </ul>
                                </li>
                                <li><a href="">Contacto</a></li>
                            </div>
                        </ul>
                    </div>

                    <div class="user-section col-10 mx-auto">
                        <div class="card text-center py-4">
                            <div class="card-header">
                                Usuario
                            </div>
                            <div class="card-body">
                                <h5 class="card-title"><%= user.getNombre() + " " + user.getApellido() %></h5>
                                <p class="card-text"><%= user.getEmail() %></p>
                                <div class="col-6 col-lg-2 mx-auto d-flex flex-column">
				                    <a href="user"><button type="button" class="btn btn-outline-danger mb-2">Ingresar pedido</button>
				                    </a>
				                    <a href="user"><button type="button" class="btn btn-outline-info">Consultar pedido</button></a>
				                </div>
                            </div>
                            <div class="card-footer text-muted">
                                
                            </div>
                        </div>
                    </div>

                    <footer class="footer">
                        <div class="footer-menu">
                            <div class="footer-col">
                                <h4>Acerca de</h4>
                                <ul>
                                    <li><a href="#">Nosotros</a></li>
                                    <li><a href="#">Nuestra misión</a></li>
                                    <li><a href="#">Historia</a></li>
                                </ul>
                            </div>
                            <div class="footer-col">
                                <h4>Servicios</h4>
                                <ul>
                                    <li><a href="#">Venta</a></li>
                                    <li><a href="#">Colocación</a></li>
                                    <li><a href="#">Reparación</a></li>
                                    <li><a href="user">Ingresar pedidos</a></li>
                                    <li><a href="user">Consultar pedidos</a></li>
                                </ul>
                            </div>
                            <div class="footer-col">
                                <h4>Contacto</h4>
                                <div class="social-links">
                                    <a href="#"><i class="fab fa-twitter"></i></a>
                                    <a href="#"><i class="fab fa-instagram"></i></a>
                                    <a href="#"><i class="fab fa-linkedin-in"></i></a>
                                </div>
                            </div>
                        </div>
                        <div class="author">Brenda Mareco &#169 2022</div>
                    </footer>
        </body>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>

        </html>