package com.example.logica;

import com.example.model.Contato;
import com.example.model.ContatoDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AdicionaContatoLogica implements Logica{
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        ContatoDAO dao = new ContatoDAO();
        Contato contato = new Contato();
        String nome = req.getParameter("nome");
        String endereco = req.getParameter("endereco");
        String email = req.getParameter("email");
        String dataEmTexto = req.getParameter("dataNascimento");
        String[] partesData = dataEmTexto.split("-");
        String dataFormatada = partesData[2] + "/" + partesData[1] + "/" + partesData[0];
        Calendar dataNascimento = null;
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataFormatada);
            dataNascimento = Calendar.getInstance();
            dataNascimento.setTime(date);//
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }

        contato.setNome(nome);
        contato.setEndereco(endereco);
        contato.setEmail(email);
        contato.setDataNascimento(dataNascimento);

        dao.adicionaContato(contato);
       return "/WEB-INF/jsp/contato-adicionado.jsp";
    }
}
