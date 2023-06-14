<%--
  Created by IntelliJ IDEA.
  User: CA2
  Date: 07/06/2023
  Time: 10:13 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Modificacion de usuario</title>
    <jsp:include page="../../layouts/head.jsp"/>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col">
            <div class="card mt-5">
                <div class="card-header">Modificacion de usuario</div>
                <div class="card-body">
                    <form id="user-form" class="needs-validation" novalidate action="/user/update"  method="post">
                        <input hidden value="${user.id}" name="id"/>
                        <input hidden value="${user.status}" name="status">
                        <div class="form-group mb-3">
                            <div class="row">
                                <div class="col">
                                    <label for="name" class="fw-bold">Nombre: </label>
                                    <input type="text" name="name" id="name" class="form-control"
                                           value="${user.name}" required/>
                                    <div class="invalid-feedback">Campo Obligatorio</div>
                                </div>
                                <div class="col">
                                    <label for="surname" class="fw-bold">Primer Apellido: </label>
                                    <input type="text" name="surname" id="surname" class="form-control"
                                           value="${user.surname}" required/>
                                    <div class="invalid-feedback">Campo Obligatorio</div>
                                </div>
                                <div class="col">
                                    <label for="lastname" class="fw-bold">Segundo Apellido: </label>
                                    <input type="text" name="lastname" id="lastname" class="form-control"
                                           value="${user.lastname}" required/>
                                    <div class="invalid-feedback">Campo Obligatorio</div>
                                </div>
                            </div>
                        </div>
                        <div class="form-group mb-3">
                            <div class="row">
                                <div class="col">
                                    <label for="birthday" class="fw-bold">Fecha de Nacimiento: </label>
                                    <input type="date" name="birthday" id="birthday" class="form-control"
                                           value="${user.birthday}" required/>
                                    <div class="invalid-feedback">Campo Obligatorio</div>
                                </div>
                                <div class="col">
                                    <label for="username" class="fw-bold">Nombre de Usuario: </label>
                                    <input type="text" name="username" id="username" class="form-control"
                                           value="${user.username}" required/>
                                    <div class="invalid-feedback">Campo Obligatorio</div>
                                </div>
                            </div>
                        </div>
                        <div class="form-group mb-3">
                            <div class="row">
                                <div class="col text-end">
                                    <a href="/user/users" class="btn btn-outline-danger btn-sm">
                                        CANCELAR
                                    </a>
                                    <button type="submit" class="btn btn-outline-success btn-sm">
                                        ACEPTAR
                                    </button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="../../layouts/footer.jsp"/>
<script>
    (function (){
        const form = document.getElementById("user-form");
        form.addEventListener("submit", function (event){
            if (!form.checkValidity()){
                event.preventDefault();
                event.stopPropagation();
            }
            form.classList.add("was-validated");
        }, false);
    })();
</script>
</body>
</html>
