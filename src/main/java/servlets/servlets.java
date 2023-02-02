package servlets;

import dtos.UserDTO;
import facades.UserFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FrontController", value = "/frontController")
public class servlets extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserFacade uf = new UserFacade("startcode");
        List<UserDTO> users = uf.getAll();

        HttpSession session = request.getSession();
        session.setAttribute("users", users);

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
