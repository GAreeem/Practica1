package mx.edu.utez.secondapp.controllers.pokemon;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mx.edu.utez.secondapp.models.pokemon.DaoPokemon;

import java.io.IOException;

@WebServlet(name = "pokemon", urlPatterns = {
        "/api/pokemon/all",
        "/api/pokemon/one",
        "/api/pokemon/person",
        "/api/pokemon/create",
        "/api/pokemon/save",
        "/api/pokemon/edit",
        "/api/pokemon/update",
        "/api/pokemon/enable-disable",
})
public class ServletPokemon extends HttpServlet {
    private String action, redirect = "/api/pokemon/all",
            id, name, ps, hp, weigth, heigth, abilities, power, personid, pokemonType;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        action = req.getServletPath();
        switch (action){
            case "/api/pokemon/all":
                //consultar pokkemons
                req.setAttribute("pokemons",
                        new DaoPokemon().findAll());
                redirect ="/view/pokemon/index.jsp";
                break;
            case  "/api/pokemon/one":
                redirect ="/view/pokemon/one.jsp";
                break;
            case "/api/pokemon/person":
                //consultar pokemons ligados a una persona
                redirect ="/view/pokemon/person-id.jsp";
                break;
            case  "/api/pokemon/create":
                //consultar personas
                //consultar los tipos de pokemon
                redirect ="/view/pokemon/create.jsp";
                break;
            case  "/api/pokemon/edit":

                redirect ="/view/pokemon/edit.jsp";
                break;
        }
        req.getRequestDispatcher(redirect)
                .forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        action = req.getServletPath();
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        switch (action){
            case "/api/pokemon/save":
                break;
            case "/api/pokemon/update":
                break;
            case "/api/pokemon/enable-disable":
                break;
        }
        resp.sendRedirect(req.getContextPath() + redirect);
    }
}