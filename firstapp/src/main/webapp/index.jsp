<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>usuarios</title>
    <link href="assets/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<jsp:include page="./layouts/footer.jsp"/>
</head>
<body>
<div class="container-fluid">
    <div class="cot text-center mt-5">
        <h2>Usuarios</h2>
        <p>Practica 1 servelets para realizar un crud de usuarios</p>
        <div class="card">
            <div class="card-header">
                <div class="row">
                    <div class="col">Listado de usuario</div>
                    <div class="col text-end">
                        <button class="btn btn-outline-success btn-sm">
                            agregar</button>
                    </div>
                </div>
            </div>
            <div class="card-body">
                <table class="table table-stripped">
                    <thead>
                    <th>#</th>
                    <th>Nombre</th>
                    <th>Fecha Nacimiento</th>
                    <th>Usuario</th>
                    <th>Estado</th>
                    <th>Acciones</th>
                    </thead>
                    <tbody>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<jsp:include page ="./layouts/footer.jsp"/>
</body>
</html>