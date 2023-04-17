package com.dormitory.controller;

import com.dormitory.entity.Moveout;
import com.dormitory.service.MoveoutService;
import com.dormitory.service.StudentService;
import com.dormitory.service.impl.MoveoutServiceImpl;
import com.dormitory.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/moveout")
public class MoveoutServlet extends HttpServlet {

    private StudentService studentService = new StudentServiceImpl();
    private MoveoutService moveoutService = new MoveoutServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String method = req.getParameter("method");
        switch (method){
            case "list"://获取可迁出的学生名单
                req.setAttribute("list",this.studentService.moveoutList());
                req.getRequestDispatcher("moveOutRegist.jsp").forward(req, resp);
                break;
            case "moveout"://点击迁出按钮
                String studentIdStr = req.getParameter("studentId");
                Integer studentId = Integer.parseInt(studentIdStr);
                String dormitoryIdStr = req.getParameter("dormitoryId");
                Integer dormitoryId = Integer.parseInt(dormitoryIdStr);
                String reason = req.getParameter("reason");
                this.moveoutService.save(new Moveout(studentId,dormitoryId,reason));
                resp.sendRedirect("/moveout?method=list");
                break;
            case "search"://查询可迁出的学生名单
                String key = req.getParameter("key");
                String value = req.getParameter("value");
                req.setAttribute("list", this.studentService.searchForMoveout(key, value));
                req.getRequestDispatcher("moveOutRegist.jsp").forward(req, resp);
                break;
            case "record"://获取迁出学生名单
                req.setAttribute("list", this.moveoutService.list());
                req.getRequestDispatcher("moveOutRecord.jsp").forward(req, resp);
                break;
            case "recordSearch"://查询迁出学生名单
                key = req.getParameter("key");
                value = req.getParameter("value");
                req.setAttribute("list", this.moveoutService.search(key, value));
                req.getRequestDispatcher("moveOutRecord.jsp").forward(req, resp);
                break;
        }
    }
}
