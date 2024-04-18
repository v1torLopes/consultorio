package model.DAO;

import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.Consulta;

public class ConsultaDAO {
    private Connection connection;

    public ConsultaDAO() throws Exception {
        this.connection = ConnectionFactory.getConnection();
    }

    public void adicionar(Consulta consulta) {
        String sql = "INSERT INTO bancodyv.consulta (nome, sobrenome, cpf, data, hora, plano, servico, observacao) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setString(1, consulta.getNome());
            pstm.setString(2, consulta.getSobrenome());
            pstm.setString(3, consulta.getCpf());
            pstm.setDate(4, new java.sql.Date(consulta.getData().getTime()));
            pstm.setString(5, consulta.getHora());
            pstm.setString(6, consulta.getPlanos());
            pstm.setString(7, consulta.getServicos());
            pstm.setString(8, consulta.getObservacao());
            pstm.executeUpdate();
            System.out.println("Consulta adicionada com sucesso!");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Consulta> listar() throws ParseException {
        List<Consulta> consultas = new ArrayList<>();
        String sql = "SELECT * FROM bancodyv.consulta";
        
        try (PreparedStatement pstm = connection.prepareStatement(sql);
             ResultSet rs = pstm.executeQuery()) {
            
            while (rs.next()) {
                String nome = rs.getString("nome");
                String sobrenome = rs.getString("sobrenome");
                String cpf = rs.getString("cpf");
                java.sql.Date dataSql = rs.getDate("data");
                java.util.Date data = new java.util.Date(dataSql.getTime());
                String hora = rs.getString("hora");
                String planos = rs.getString("planos");
                String servicos = rs.getString("servicos");
                 String observacao = rs.getString("observacao");
                
                
                Consulta consulta = new Consulta(nome, sobrenome, cpf, data, hora, planos, servicos, observacao);
                consultas.add(consulta);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return consultas;
    }

    public void atualizar(Consulta consulta) {
        String sql = "UPDATE bancodyv.consultas SET nome=?, sobrenome=?, data=?, hora=?, planos=?, servicos=? WHERE cpf=?";
        
        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setString(1, consulta.getNome());
            pstm.setString(2, consulta.getSobrenome());
            pstm.setDate(3, new java.sql.Date(consulta.getData().getTime()));
            pstm.setString(4, consulta.getHora());
            pstm.setString(5, consulta.getPlanos());
            pstm.setString(6, consulta.getServicos());
            pstm.setString(7, consulta.getCpf());
            pstm.setString(8, consulta.getObservacao());
            pstm.executeUpdate();
            System.out.println("Consulta atualizada com sucesso!");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletar(String cpf) {
        String sql = "DELETE FROM bancodyv.consultas WHERE cpf=?";
        
        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setString(1, cpf);
            pstm.executeUpdate();
            System.out.println("Consulta deletada com sucesso!");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
