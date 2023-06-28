package com.example.model;
import com.example.model.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ContatoDAO {
    // a conexão com o banco de dados
    private Connection connection;
    public ContatoDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public List<Contato> getLista(){
        List<Contato> contatos = new ArrayList<Contato>();
        try{
            PreparedStatement stmt = connection.prepareStatement("select * from contatos");
            // executa um select
            ResultSet rs = stmt.executeQuery();

            // itera no ResultSet
            while (rs.next()) {
                Contato contato = new Contato();
                contato.setId(rs.getLong("id"));
                contato.setNome(rs.getString("nome"));
                contato.setEmail(rs.getString("email"));
                contato.setEndereco(rs.getString("endereco"));

                // montando a data através do Calendar
                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("dataNascimento"));
                contato.setDataNascimento(data);

                contatos.add(contato);
            }
            rs.close();
            stmt.close();
           // connection.close();

        }catch (SQLException e ){
            throw new RuntimeException(e);
        }
        return contatos;
    }

    public Contato getContato(int id){
        Contato contato = new Contato();
        try {
            PreparedStatement stmt = connection.prepareStatement("select * from contatos where id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                contato.setNome(rs.getString("nome"));
                contato.setEmail(rs.getString("email"));
                contato.setEndereco(rs.getString("endereco"));
            }

            rs.close();
            stmt.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return contato;
    }
    public void adicionaContato(Contato contato){
        String sql = "insert into contatos (nome,email,endereco,dataNascimento) " +
                "values (?,?,?,?)";
        try{
            PreparedStatement stmt  = connection.prepareStatement(sql);
            stmt.setString(1,contato.getNome());
            stmt.setString(2,contato.getEmail());
            stmt.setString(3,contato.getEndereco());
            stmt.setDate(4,new Date(contato.getDataNascimento().getTimeInMillis()));

            stmt.execute();
            stmt.close();
        }catch (SQLException e ){
            throw new RuntimeException(e);
        }
    }

    public void alteraContato(Contato contato){
        try {
            String sql = "update contatos set nome = ?, endereco = ?, email = ?, dataNascimento = ? where id= ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, contato.getNome());
            statement.setString(2, contato.getEndereco());
            statement.setString(3, contato.getEmail());
            statement.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
            statement.setLong(5, contato.getId());
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void deletaContato(long id){
        try {
            String sql = "delete from contatos where id= ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1,id);
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}