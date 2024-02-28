package com.example.exam_sever.controllers;

import com.example.exam_sever.entities.Employee;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import java.io.IOException;

import java.util.List;

@WebServlet(value = "/list-employee")

public class EmployeeController extends HttpServlet {


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

        HttpSession httpSession = req.getSession();
        String searchValue = req.getParameter("search");

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            List<Employee> list = session.createQuery(
                            "SELECT s FROM Employee s " + (searchValue!= null ? " WHERE s.name LIKE '%"+searchValue+"%'  OR s.id LIKE  '"+searchValue+"'" : "")
                            ,Employee.class)
                    .getResultList();
            session.getTransaction().commit();

            req.setAttribute("employees", list);


        }
        req.getRequestDispatcher("employee/list.jsp").forward(req, resp);


    }




    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String employeeId = req.getParameter("id");
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Employee employee = session.get(Employee.class,(employeeId));
            if (employee != null) {
                session.delete(employee);
            }
            session.getTransaction().commit();
            resp.setStatus(200);
            return;
        } catch (Exception e) {
            resp.setStatus(403);
        }


    }




}
