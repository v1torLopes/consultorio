package model.DAO;

import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Cadastro;
import model.Usuario;

public class UsuarioDAO {

    public boolean logar(Usuario usuario) throws Exception {
        String sql = "SELECT * FROM bancodyv.cadastro WHERE nome = ? and senha = ? ";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setString(1, usuario.getNome());
            pstm.setString(2, usuario.getSenha());
            var result = pstm.executeQuery();
            
            
             while (result.next()) {
                 
                 System.out.println("Logado com sucesso");
                 return true;
            
            }
             
             System.out.println("Error");
             return false;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar: " + e.getMessage());
        }
        return false;
    }

   
}
