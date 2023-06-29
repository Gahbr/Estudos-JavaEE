package com.example.logica;
import com.example.model.Contato;
import com.example.model.ContatoDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class RemoveContatoLogica implements Logica {
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        long id = Long.parseLong(req.getParameter("id"));
        Contato contato = new Contato();
        contato.setId(id);
        ContatoDAO dao = new ContatoDAO();
        dao.deletaContato(id);
        System.out.println("Excluindo contato...");
        return "/WEB-INF/jsp/lista-contatos.jsp";
    }
}
