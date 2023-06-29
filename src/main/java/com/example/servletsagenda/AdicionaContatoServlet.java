package com.example.servletsagenda;

import com.example.model.Contato;
import com.example.model.ContatoDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/adiciona-contato.jsp");
        rd.forward(request,response);
    }
}