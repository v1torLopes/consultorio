package model.DAO;

import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import model.Cadastro;


public class CadastroDAO {
    private Connection connection;

    public CadastroDAO() throws Exception {
        this.connection = ConnectionFactory.getConnection();
    }

   public void adicionar (Cadastro cadastro){
    
        String sql = "INSERT INTO cadastro(nome, email, senha, endereco, complemento, telefone, cpf, sobrenome) VALUES (?,?,?,?,?,?,?,?)";
        
       
    
        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            
            // Adicionar os valores que são esperados pela query
            pstm.setString(1, cadastro.getNome());
            pstm.setString(2, cadastro.getEmail());
            pstm.setString(3, cadastro.getSenha());
            pstm.setString(4, cadastro.getEndereco());
            pstm.setString(5, cadastro.getComplemento());
            pstm.setString(6, cadastro.getTelefone());
            pstm.setString(7, cadastro.getCpf());
            pstm.setString(8, cadastro.getSobrenome());
            
            //Executar a query
            
            pstm.executeUpdate();
            System.out.println("Cadastro feito com sucesso!");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
   public List<Cadastro> listar() throws ParseException {
        List<Cadastro> cadastros = new ArrayList<>();
        String sql = "SELECT * FROM bancodyv.cadastro";
    
    try (PreparedStatement pstm = connection.prepareStatement(sql);
             ResultSet rs = pstm.executeQuery()) {
        
        while (rs.next()) {
            String nome = rs.getString("nome");
            String email = rs.getString("email");
            String senha = rs.getString("senha");
            String endereco = rs.getString("endereco");
            String complemento = rs.getString("complemento");
            String telefone = rs.getString("telefone");
            String cpf = rs.getString("cpf");
            String sobrenome = rs.getString("sobrenome");
            
            Cadastro cadastro = new Cadastro(nome, email, senha, endereco, complemento, telefone, cpf, sobrenome);
                cadastros.add(cadastro);
        }
   
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return cadastros;
    }

    
    public void atualizar(Cadastro cadastro) throws Exception {
    String sql = "UPDATE cadastro SET nome=?, sobrenome=?, senha=?, email=?, telefone=?, cpf=?, endereco=?, complemento=? WHERE cpf=?";

    try (PreparedStatement pstm = connection.prepareStatement(sql)){

        
        // Adicionar os valores atualizados
        pstm.setString(1, cadastro.getNome());
        pstm.setString(2, cadastro.getSobrenome());
        pstm.setString(3, cadastro.getSenha());
        pstm.setString(4, cadastro.getEmail());
        pstm.setString(5, cadastro.getTelefone());
        pstm.setString(6, cadastro.getCpf());
        pstm.setString(7, cadastro.getEndereco());
        pstm.setString(8, cadastro.getComplemento());
        pstm.executeUpdate();
            System.out.println("Cadastro atualizada com sucesso!");
        
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
