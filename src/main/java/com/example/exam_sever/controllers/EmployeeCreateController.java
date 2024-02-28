package com.example.exam_sever.controllers;

import com.example.exam_sever.entities.Employee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

@WebServlet("/create-employee")


public class EmployeeCreateController extends HttpServlet {


    private SessionFactory sessionFactory;


    @Override
    public void init() throws ServletException {
        try {
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();


        }

        req.getRequestDispatcher("employee/create.jsp").forward(req, resp);
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Employee employee = new Employee();


        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
        Date birthday= formatter.parseDateTime(req.getParameter("birthday")).toDate();

        UUID uuid=UUID.randomUUID();
        employee.setId(uuid.toString());
        employee.setName(req.getParameter("name"));
        employee.setEmail(req.getParameter("email"));
        employee.setPhone(req.getParameter("phone"));
        employee.setBirthday(birthday);


        try (Session session = sessionFactory.openSession()) {


            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();

        }

        resp.sendRedirect("list-employee");
    }


}
