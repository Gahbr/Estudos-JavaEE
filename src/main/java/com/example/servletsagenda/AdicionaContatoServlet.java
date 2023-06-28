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
// busca o writer
        PrintWriter out = response.getWriter();
// buscando os parâmetros no request
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String email = request.getParameter("email");
        String dataEmTexto = request.getParameter("dataNascimento");
        String[] partesData = dataEmTexto.split("-");
        String dataFormatada = partesData[2] + "/" + partesData[1] + "/" + partesData[0];
        Calendar dataNascimento = null;
// fazendo a conversão da data
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataFormatada);
            dataNascimento = Calendar.getInstance();
            dataNascimento.setTime(date);//
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            out.println("Erro de conversão da data");
            return; //para a execução do método
        }

// monta um objeto contato
        Contato contato = new Contato();
        contato.setNome(nome);
        contato.setEndereco(endereco);
        contato.setEmail(email);
        contato.setDataNascimento(dataNascimento);

// salva o contato
        ContatoDAO dao = new ContatoDAO();
        dao.adicionaContato(contato);

//redirecionando para uma página de contato adicionado
        RequestDispatcher rd = request.getRequestDispatcher("/contato-adicionado.jsp");
        rd.forward(request,response);
    }
}