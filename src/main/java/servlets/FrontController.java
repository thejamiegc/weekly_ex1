package servlets;

import dtos.UserDTO;
import facades.UserFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/index.html", "/backend"})
public class FrontController extends HttpServlet {
    UserFacade uf = new UserFacade("startcode");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<UserDTO> users = uf.getAll();

        HttpSession session = request.getSession();
        session.setAttribute("users", users);

        request.getRequestDispatcher("second.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");

        UserDTO user = new UserDTO(fname, lname, password, phone, address);
        uf.create(user);

        List<UserDTO> users = uf.getAll();
        HttpSession session = request.getSession();
        session.setAttribute("users", users);
        request.getRequestDispatcher("second.jsp").forward(request, response);
    }
}
