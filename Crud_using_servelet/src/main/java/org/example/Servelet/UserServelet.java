package org.example.Servelet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.Model.User;
import org.example.Service.UserService;

import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class UserServelet extends HttpServlet {
    private UserService userService = new UserService();


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");

        if (id == null || name == null|| email == null || mobile == null) {
            response.setStatus(404);
            response.setContentType("application/json");
            response.getWriter().write("{\n" +
                    "    \"message\" : \"all fields are required\"\n" +
                    "}");
            return;
        }
        User user = new User(id, name, email, mobile);
        userService.createUser(user);

        response.setStatus(201);
        response.setContentType("application/json");
        response.getWriter().write("{\n" +
                "    \"message\" : \"user added successfully \"\n" +
                "}");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idparam = request.getParameter("id");
        if (idparam == null) {
            List<User> users = userService.getall();
            response.setStatus(201);
            response.setContentType("application/json");
            response.getWriter().write(usersToJson(users));
            return;
        }

        Integer id = Integer.parseInt(request.getParameter("id"));

        User user = userService.getById(id);
        if (user == null) {
            response.setStatus(404);
            response.setContentType("application/json");
            response.getWriter().write("{\n" +
                    "    \"message\" : \"user is not found\"\n" +
                    "}");
            return ;
        }
        response.setStatus(201);
        response.setContentType("application/json");
        response.getWriter().write(UserToJson(user));

    }
    @Override
    public void doPut(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String idParam = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");

        if (idParam == null || idParam.isBlank()
                || name == null || name.isBlank()
                || email == null || email.isBlank()
                || mobile == null || mobile.isBlank()) {

            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write(
                    "{\"message\":\"All fields are required\"}"
            );
            return;
        }

        int id;

        try {
            id = Integer.parseInt(idParam);
        } catch (NumberFormatException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write(
                    "{\"message\":\"Invalid ID\"}"
            );
            return;
        }

        User user = new User(id, name, email, mobile);

        User updatedUser = userService.updateUser(id, user);

        if (updatedUser == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.getWriter().write(
                    "{\"message\":\"User not found\"}"
            );
            return;
        }

        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().write(
                "{\"message\":\"User updated successfully\"}"
        );
    }
    private String UserToJson(User user){


        return "{\n" +
                "    \"id\" : " + user.getId() + ",\n" +
                "    \"name\": " + user.getName() + ",\n" +
                "    \"email\" : " + user.getEmail() + " ,\n" +
                "    \"mobile\" : " + user.getMobile() + " ,\n" +
                "}";
    }


    private String usersToJson(List<User> users) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");

        for(int i = 0; i<users.size(); i++) {
            stringBuilder.append(UserToJson(users.get(i)));

            if(i < users.size() - 1) {
                stringBuilder.append(",");
            }
        }

        stringBuilder.append("]");

        return stringBuilder.toString();
    }
}


