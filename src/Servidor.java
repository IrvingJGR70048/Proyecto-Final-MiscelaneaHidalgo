/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package main;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Servidor extends Observable implements Runnable {

    ServerSocket server = null;
    Socket sc = null;
    DataInputStream in;
    DataOutputStream out;
    String mensaje;
    String resul;
    DefaultTableModel modelo;
    final int Puerto = 5002;

    @Override
    public void run() {
        try {
            server = new ServerSocket(Puerto);
            System.out.println("Servidor iniciado");
            while (true) {
                sc = server.accept();
                System.out.println("Cliente conectado");
                System.out.println("Maquina de guadalupe");
                in = new DataInputStream(sc.getInputStream());
                mensaje = in.readUTF();
                ProcesarSQL(mensaje);
                this.setChanged();
                this.notifyObservers();
                this.clearChanged();
                sc.close();
            }
        } catch (IOException | SQLException e) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public String Clean(String CleanOff) {
        String Limpio = "";
        Limpio = CleanOff.replaceAll(" ", "");
        return Limpio;
    }

    public void ProcesarSQL(String SQL) throws SQLException, IOException {
        conexion cc = new conexion();
        Connection cn;
        modelo = new DefaultTableModel();
        String[] getdatos = new String[5];
        try {
            cn = cc.conexion();
            if (SQL.contains("SELECT")) {
                modelo.addColumn("Id Productos");
                modelo.addColumn("Nombre del producto");
                modelo.addColumn("Cantidad");
                modelo.addColumn("Precio");
                modelo.addColumn("Id proveedor");
//                modelo.addColumn("Meses");
//                modelo.addColumn("Direccion");
//                modelo.addColumn("Telefono");
                try {
                    Statement st = cn.createStatement();
                    ResultSet rs = st.executeQuery(SQL);
                    while (rs.next()) {
                        getdatos[0] = rs.getString(1);
                        getdatos[1] = rs.getString(2);
                        getdatos[2] = rs.getString(3);
                        getdatos[3] = rs.getString(4);
                        getdatos[4] = rs.getString(5);
//                        getdatos[5] = rs.getString(6);
//                        getdatos[6] = rs.getString(7);
//                        getdatos[7] = rs.getString(8);

                        modelo.addRow(getdatos);
                    }
                    datos g = new datos(getdatos);
                    g.setInfo(getdatos);
                    try {
                        try ( ObjectOutputStream oos = new ObjectOutputStream(sc.getOutputStream())) {
                            oos.writeObject(g);
                            oos.close();
                            System.out.println("SELECT REALIZADO CON EXITO");
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("Sentencia SQL realizada correctamente");
                } catch (SQLException ex) {
                    Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                PreparedStatement pst = cn.prepareStatement(SQL);
                int i = pst.executeUpdate();
                if (i > 0) {
                    System.out.println("Sentencia SQL realizada correctamente");
                } else {
                    System.out.println("Sentencia SQL no realizada con exito");
                }
            }
        } catch (IllegalAccessException | InstantiationException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
