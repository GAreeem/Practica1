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
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
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

    private String name, surname, lastname,username, birthday, status, id;

    private user user;

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
            case "/user/user-view":
                //consultar catalogos
                redirect ="/views/user/create.jsp";
                break;
            case "/user/user-view-update":
                id = req.getParameter("id");
                user = new DaoUser().findOne(
                        id != null ? Long.parseLong(id) :0
                );
                if(user != null){
                    req.setAttribute("user", user);
                  redirect ="/views/user/update.jsp";
                } else {
                    redirect = "/user/users?result"+ false+
                            "&messages" +
                            URLEncoder.encode("", StandardCharsets.UTF_8);
                }

                break;
            default:
                System.out.println(action);
        }
        req.getRequestDispatcher(redirect).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        action = req.getServletPath();
        switch (action){
            case "/user/user-view-update":
                String id = req.getParameter("id");
                user user = new DaoUser().findOne(
                        id != null ? Long.parseLong(id) : 0
                );
                if (user != null){
                    req.setAttribute("user", user);
                    redirect = "/views/user/update.jsp";
                }else{
                    redirect = "/user/users";
                }
                break;
            case "/user/save":
                name = req.getParameter("name");
                surname = req.getParameter("surname");
                lastname = req.getParameter("lastname");
                username = req.getParameter("username");
                birthday = req.getParameter("birthday");
                status = req.getParameter("status");
                user user1 = new user(0L, name, surname, lastname, birthday,username, "ACTIVO");
                boolean result = new DaoUser().save(user1);
                if (result){
                    redirect = "/user/users?result= " +result
                            +"&message=" + URLEncoder.encode("!Exito¡ Usuario Registrado correctamente.", StandardCharsets.UTF_8);
                }else{
                    redirect = "/user/users?result= " +result
                            +"&message=" + URLEncoder.encode("!Error¡ Accion no realizada correctamente.", StandardCharsets.UTF_8);

                }
                break;
        }
        resp.sendRedirect(req.getContextPath() + redirect);
    }
}
