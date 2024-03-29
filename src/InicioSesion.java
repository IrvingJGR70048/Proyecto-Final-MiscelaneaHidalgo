
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author cr
 */
public class InicioSesion extends javax.swing.JFrame {

    int c = 3;
    //int intentos = 0;

    /**
     * Creates new form InicioSesion
     */
    public InicioSesion() {
        try {
            this.cn = cc.conexion();
        } catch (InstantiationException ex) {
            Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();

        this.getContentPane().setBackground(Color.white);
        this.setTitle("Inicio de Sesion");

        ImageIcon obj = new ImageIcon(getClass().getResource("/Imagenes/LOGO.jpg"));
        ImageIcon icono = new ImageIcon(obj.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_DEFAULT));
        logo.setIcon(icono);

        TextPrompt holder;
        holder = new TextPrompt("Introduzca su usuario", user);
        holder = new TextPrompt("Introduzca su contraseña", password);
    }
    
    int intentos = 0;
    final int maximos = 3;
    boolean logueado = false;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        B_Iniciar = new javax.swing.JButton();
        user = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Iniciar Sesión");

        B_Iniciar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        B_Iniciar.setText("Iniciar Sesión");
        B_Iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_IniciarActionPerformed(evt);
            }
        });

        user.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        user.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        user.setText("ADM");

        password.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        password.setText("12345");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(user)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(B_Iniciar, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                    .addComponent(password))
                .addGap(0, 50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(B_Iniciar)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void B_IniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_IniciarActionPerformed
        String User = "";
        String Clave = "";
        String SQL="";
        if (user.getText().isEmpty() || password.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se ha introducido ningun Usuario y Contraseña", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            if (intentos == maximos) {
                JOptionPane.showMessageDialog(this, "Sistema bloqueado, maximo de intentos permitidos alcanzados", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
            try{
            SQL = "SELECT usuario, pass FROM Usuarios_1 WHERE usuario = '" + user.getText() + "' and pass= '" + password.getText() +"'"; 
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
                while(rs.next()){
                User = rs.getObject(1).toString();
                Clave = rs.getObject(2).toString();
                }
                String UserF = User.replaceAll(" ", "");
                String ClaveF = Clave.replaceAll(" ", "");
                if (user.getText().equals(UserF) && password.getText().equals(ClaveF)) {
                    logueado = true;
                    JOptionPane.showMessageDialog(this, "Bienvenido", "Inicio de sesion exitoso", JOptionPane.INFORMATION_MESSAGE);
                    new Principal().setVisible(true);
                    this.dispose();
                } else {
                    intentos++;
                    JOptionPane.showMessageDialog(this, "Usuario / Contraseña incorrecta, lleva " + intentos + " de 3", "--ERROR--", JOptionPane.ERROR_MESSAGE);
                }
             }catch(SQLException e){
                System.out.print("Error SQL del tipo: " + e.getMessage());
                }
            }
        }
        /*String nombre = "1";
        String contrasena = "2";
        String nombre2 = "Ejem";
        String contrasena2 = "Ejem1"; */
        //Logearse();

        /*if (c > 0) {
            if ((T_Usuario.getText().equals(nombre) && T_Contra.getText().equals(contrasena)) | (T_Usuario.getText().equals(nombre2) && T_Contra.getText().equals(contrasena2)) ) {
                Principal p = new Principal();
                p.setVisible(true);
                p.setLocationRelativeTo(null);
                p.setResizable(false);
                //p.setBackground(new Color());
                p.setTitle("Pantalla principal");

                this.dispose();
            } else {
                c--;
                JOptionPane.showMessageDialog(this, "Usuario o contraseña Incorrecta, verifique porfavor\n" + "Quedan " + c + " intentos");

                T_Usuario.setText("");
                T_Contra.setText("");
            }
        }else{
            JOptionPane.showMessageDialog(this, "No quedan intentos, vuelva después");
        }*/
    }//GEN-LAST:event_B_IniciarActionPerformed

    /*void Logearse() {

        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setServerName("34.69.84.99");
        ds.setDatabaseName("BD_Josefa");
        ds.setUser("sqlserver"); //Aqui cambiar al usuario de SQL Server
        ds.setPassword("root"); // Contraseña
        ds.setPortNumber(1433);

        try {
            Connection cn = ds.getConnection();
            PreparedStatement ps = cn.prepareStatement("select * from Logins where Nombre = ? and Contraseña = ? ");
            ps.setObject(1, this.user.getText());
            ps.setObject(2, this.password.getText());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String rutaCar = "C:\\Josefa Ortiz de Dominguez";
                File carpeta = new File(rutaCar);

                if (carpeta.exists()) {
                    //confrima si la carpeta existe
                } else {
                    carpeta.mkdirs();
                }

                new Principal().setVisible(true);
                intentos = 0;
                this.dispose();
            } else {
                System.out.println("Error de Login");
                intentos++;
                JOptionPane.showMessageDialog(this, "Usuario o contraseña Incorrecta, verifique porfavor\n" + "Quedan " + (3 - intentos) + " intentos");

                user.setText("");
                password.setText("");
            }
        } catch (SQLServerException ex) {
            Logger.getLogger(InicioSesion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(InicioSesion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }*/

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
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                InicioSesion inicio = new InicioSesion();
                inicio.setVisible(true);
                inicio.setLocationRelativeTo(null);
                inicio.setResizable(false);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B_Iniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel logo;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
    conexion cc = new conexion();
    Connection cn;
}
