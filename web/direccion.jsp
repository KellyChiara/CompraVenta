<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container mt-100">
            <div class="col-sm-100">
                <div class="alert alert-success" role="alert">
                    <h1 class="alert-heading">VISITANOS!</h1>
                    <p>Te esperamos </p>
                    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3825.620697316166!2d-68.17569908570826!3d-16.49473294496197!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x915edfc74f000001%3A0x1548261438d42835!2sEstaci%C3%B3n%20Telef%C3%A9rico%20Azul!5e0!3m2!1ses!2sbo!4v1594360492092!5m2!1ses!2sbo" width="800" height="500" frameborder="0" style="border:0;" allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>
                    <center>
                        <a href="Controlador?accion=view" class="btn btn-warning">Finalizar</a>
                    </center>
                </div>
            </div>
        </div>
    </body>
</html>

