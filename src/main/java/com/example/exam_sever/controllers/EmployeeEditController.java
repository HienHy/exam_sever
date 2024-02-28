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
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
@WebServlet("/edit-employee")

public class EmployeeEditController extends HttpServlet
{

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
        String employeeId = req.getParameter("id");
        try   (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            Employee employee = session.get(Employee.class,Integer.parseInt(employeeId));
            session.getTransaction().commit();
            if (employee != null){
                req.setAttribute("employee",employee);
                req.getRequestDispatcher("employee/edit.jsp").forward(req,resp);
            }
            else
                resp.setStatus(404);
        }catch (Exception e){
            resp.setStatus(404);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String employeeId = req.getParameter("id");

        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
        Date birthday= (Date) formatter.parseDateTime(req.getParameter("birthday")).toDate();



        try   (Session session = sessionFactory.openSession()){

            session.beginTransaction();
            Employee employee = session.get(Employee.class,Integer.parseInt(employeeId));
            System.out.println(employee.getEmail());
            if (employee != null){
                employee.setName(req.getParameter("name"));
                employee.setEmail(req.getParameter("email"));
                employee.setPhone(req.getParameter("phone"));
                employee.setBirthday(birthday);
                session.update(employee);
            }

            session.getTransaction().commit();
            resp.sendRedirect("list-employee");
        }catch (Exception e){
            System.out.println(e.getMessage());
            resp.setStatus(404);
        }
    }

}
