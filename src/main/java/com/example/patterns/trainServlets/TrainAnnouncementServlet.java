package com.example.patterns.trainServlets;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet(name = "announcement", value = "/train-announcement")
public class TrainAnnouncementServlet extends HttpServlet {
}
