package com.calculator;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.*;
@WebServlet("/calculate")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        double a = Double.parseDouble(req.getParameter("a"));
        double b = Double.parseDouble(req.getParameter("b"));
        String op = req.getParameter("op");
        double result = 0;
        String error = "";
        switch(op) {
            case "add": result = a + b; break;
            case "sub": result = a - b; break;
            case "mul": result = a * b; break;
            case "div": if(b != 0) result = a / b; else error = "Error: division por cero"; break;
        }
        // test
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<h1>Resultado: " + (error.isEmpty() ? result : error) + "</h1>");
        out.println("<a href='index.html'>Volver</a>");
    }
}
