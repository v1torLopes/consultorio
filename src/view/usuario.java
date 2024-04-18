/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;


import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import model.DAO.UsuarioDAO;
import model.Usuario;

/**
 *
 * @author Vitor
 */
public class usuario extends javax.swing.JFrame {

    

    /**
     * Creates new form login
     */
    public usuario() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelusuario = new javax.swing.JLabel();
        jLabelsenha = new javax.swing.JLabel();
        Textusuario = new javax.swing.JTextField();
        jButtonentrar = new javax.swing.JButton();
        jButtonsair = new javax.swing.JButton();
        jButtoncadastrar = new javax.swing.JButton();
        Textsenha = new javax.swing.JPasswordField();
        jLabelimagem = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consultório Odontológico");
        setMinimumSize(new java.awt.Dimension(556, 515));
        getContentPane().setLayout(null);

        jLabelusuario.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelusuario.setText("Usuário");
        getContentPane().add(jLabelusuario);
        jLabelusuario.setBounds(170, 220, 50, 30);

        jLabelsenha.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelsenha.setText("Senha");
        getContentPane().add(jLabelsenha);
        jLabelsenha.setBounds(170, 260, 50, 30);

        Textusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextusuarioActionPerformed(evt);
            }
        });
        getContentPane().add(Textusuario);
        Textusuario.setBounds(220, 220, 140, 30);

        jButtonentrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonentrar.setText("entrar");
        jButtonentrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonentrarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonentrar);
        jButtonentrar.setBounds(60, 440, 90, 23);

        jButtonsair.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonsair.setText("sair");
        jButtonsair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonsairActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonsair);
        jButtonsair.setBounds(432, 440, 90, 23);

        jButtoncadastrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtoncadastrar.setText("cadastrar");
        jButtoncadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtoncadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtoncadastrar);
        jButtoncadastrar.setBounds(240, 440, 90, 23);
        getContentPane().add(Textsenha);
        Textsenha.setBounds(220, 262, 140, 30);

        jLabelimagem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelimagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/dentistaproj.jpg"))); // NOI18N
        jLabelimagem.setText("jLabel1");
        jLabelimagem.setMaximumSize(new java.awt.Dimension(539, 466));
        jLabelimagem.setMinimumSize(new java.awt.Dimension(500, 400));
        getContentPane().add(jLabelimagem);
        jLabelimagem.setBounds(0, 0, 540, 480);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TextusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextusuarioActionPerformed
        // TODO add your handling code here:
        //controller.fizTarefa();
    }//GEN-LAST:event_TextusuarioActionPerformed

    private void jButtonentrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonentrarActionPerformed
        
        var nome = Textusuario.getText();
        var senha =  new String(Textsenha.getPassword());
        
          System.out.println(nome);
          System.out.println(senha);
          
          Usuario usuario = new Usuario(nome, senha);
          UsuarioDAO usuarioDAO = new UsuarioDAO();
        try {
            
          if (usuarioDAO.logar(usuario)){
          
            JOptionPane.showMessageDialog(null, "Usuário logado no sistema");
            consulta tc = new consulta();
            this.dispose();
            tc.setVisible(true);
          }
          else {
            JOptionPane.showMessageDialog(null, "Usuário e/ou senha inválidos");
          }
          
          
  
        } catch (Exception ex) {
            Logger.getLogger(usuario.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        
    }//GEN-LAST:event_jButtonentrarActionPerformed

    private void jButtoncadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtoncadastrarActionPerformed
        // TODO add your handling code here:
        // Pegar dados da tela
        // Salvar dados no banco
        // Mostrar mensagem de sucesso e redirecionar pra tela  de login
        
            cadastro tc = new cadastro();
            this.dispose();
            tc.setVisible(true);
        
        
    }//GEN-LAST:event_jButtoncadastrarActionPerformed

    private void jButtonsairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonsairActionPerformed
        // TODO add your handling code here:
        this.dispose(); // Fecha a janela atual
        JOptionPane.showMessageDialog(null, "SISTEMA FECHADO!!!");
    }//GEN-LAST:event_jButtonsairActionPerformed

     private void btnsairActionPerformed(java.awt.event.ActionEvent evt) {                                        
       
    }         
    
        
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new usuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField Textsenha;
    private javax.swing.JTextField Textusuario;
    private javax.swing.JButton jButtoncadastrar;
    private javax.swing.JButton jButtonentrar;
    private javax.swing.JButton jButtonsair;
    private javax.swing.JLabel jLabelimagem;
    private javax.swing.JLabel jLabelsenha;
    private javax.swing.JLabel jLabelusuario;
    // End of variables declaration//GEN-END:variables

    public void exibeMensagem(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    
    }

    public JPasswordField getTextsenha() {
        return Textsenha;
    }

    public void setTextsenha(JPasswordField Textsenha) {
        this.Textsenha = Textsenha;
    }

    public JTextField getTextusuario() {
        return Textusuario;
    }

    public void setTextusuario(JTextField Textusuario) {
        this.Textusuario = Textusuario;
    }

    

    
    
}
