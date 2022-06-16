/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente extends Observable implements Runnable {

    private int Puerto;
    private String Host;
    private DataOutputStream out;
    private DataInputStream in;
    private String mensaje;

    public Cliente(int port, String ip, String mensaje) {
        this.Puerto = port;
        this.Host = ip;
        this.mensaje = mensaje;
    }

    @Override
    public void run() {
        try {
            Socket sc = new Socket(Host, Puerto);
            out = new DataOutputStream(sc.getOutputStream());
            if (mensaje.contains("SELECT")) {
                out.writeUTF(mensaje);
                in = new DataInputStream(sc.getInputStream());
                InputStream inputStream = sc.getInputStream();
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                while (true) {
                    datos g = (datos) objectInputStream.readObject();
                    this.setChanged();
                    this.notifyObservers(g);
                    this.clearChanged();
                    if (objectInputStream.read() == -1) {
                        break;
                    }
                }
                objectInputStream.close();
            } else {
                out.writeUTF(mensaje);
                in = new DataInputStream(sc.getInputStream());
            }
            sc.close();
        } catch (IOException | ClassNotFoundException e) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
