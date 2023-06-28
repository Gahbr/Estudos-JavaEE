package com.example.logica;

import com.example.model.Contato;
import com.example.model.ContatoDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ListaContatosLogica implements Logica{
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        // Monta a lista de contatos
        List<Contato> contatos = new ContatoDAO().getLista();
        // Guarda a lista no request
        req.setAttribute("contatos", contatos);
        return "lista-contatos.jsp";
    }
}
