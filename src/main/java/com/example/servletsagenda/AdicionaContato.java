package com.example.servletsagenda;

import com.example.model.Contato;
import com.example.model.ContatoDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdicionaContato {
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ContatoDAO dao = new ContatoDAO();
        Contato contato = new Contato();
        contato.setNome(request.getParameter("nome"));
        contato.setEndereco(request.getParameter("endereco"));
        contato.setEmail(request.getParameter("email"));
        dao.adicionaContato(contato);
        RequestDispatcher rd =
                request.getRequestDispatcher("/contato-adicionado.jsp");
        rd.forward(request, response);
    }

}
