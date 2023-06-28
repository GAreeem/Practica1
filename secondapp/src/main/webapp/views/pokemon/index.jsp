<%--
  Created by IntelliJ IDEA.
  User: CA2
  Date: 28/06/2023
  Time: 10:36 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Pokemon Index</title>
    <jsp:include page="../../layouts/head.jsp"/>
</head>
<body>
<!--- NAV NAVBAR -->
<div class="container">
    <div class="row">
        <div class="col">
            <h2 class="mt-3 mb-5">POKEMONS</h2>
            <div class="card">
                <div class="card-header">
                    <div class="row">
                        <div class="col">Listado</div>
                        <div class="col text-end">
                            <button type="button"
                                    data-bs-toggle="modal"
                                    data-bs-target="#createPokemon"
                                    class="btn btn-outline-primary btn-sm"
                            >AGREGAR
                            </button>
                        </div>
                    </div>
                </div>
                <div class="card-body">
                    <s:forEach items="${pokemons}" var="pokemon">
                        <div class="card" style="width: 18rem;">
                            <img src="/pokemon/loadfile?file=${pokemon.id}" class="card-img-top" alt="${pokemon.name}">
                            <div class="card-body">
                                <h5 class="card-title">${pokemon.name}</h5>
                                <p class="card-text">Poder: ${pokemon.power}</p>
                                <p class="card-text">Puntos de experiencia: ${pokemon.ps}</p>
                                <p class="card-text">HP: ${pokemon.hp}</p>
                                <p class="card-text">Poder: ${pokemon.power}</p>
                                <p class="card-text">Habilidades: ${pokemon.abilities}</p>
                                <button type="button" class="btn btn-primary">
                                    <i data-feather="edit"></i>EDITAR
                                </button>
                            </div>
                        </div>
                    </s:forEach>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Modal -->
<div class="modal fade" id="createPokemon" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="staticBackdropLabel">Modal title</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                ...
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Understood</button>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../../layouts/footer.jsp"/>
</body>
</html>
