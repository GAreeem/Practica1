package mx.edu.utez.firstapp.controllers.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mx.edu.utez.firstapp.models.user.DaoUser;
import mx.edu.utez.firstapp.models.user.user;

import javax.swing.plaf.ListUI;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "users", urlPatterns = {
        "/user/users",
        "/user/user",
        "/user/user-view",
        "/user/save",
        "/user/user-view-update",
        "/user/update",
        "/user/delete"
})
public class ServletUser extends HttpServlet{
    private String action;
    private String redirect = "/user/users";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        action = req.getServletPath();
        switch (action){
            case "/user/users":
                List<user> users = new DaoUser().findAll();
                req.setAttribute("users",users);
                redirect="/views/user/index.jsp";
                break;
            default:
                System.out.println(action);
        }
        req.getRequestDispatcher(redirect).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
