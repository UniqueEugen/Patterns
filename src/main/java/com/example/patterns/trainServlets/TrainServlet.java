package com.example.patterns1.trainServlets;

import com.example.patterns1.data.main.GetTrainsImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "trains", value = "/trains")
public class TrainServlet extends HttpServlet {
    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if(request.getParameter("id") != null){
            response.setContentType("text/html");
            request.setAttribute("moveType", GetTrainsImpl.getInstance().getTrain( request.getParameter("id")).announcement());
            request.setAttribute("message", "<script>" +
                    "var dialog = document.querySelector('#type');"+
                    "dialog.show();"+
                    "</script>");
        }
        getServletContext().getRequestDispatcher("/WEB-INF/views/train.jsp").forward(request,response);
    }

    public void destroy() {
    }
}
