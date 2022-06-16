
import Capa_Dato.Conexion;
import javax.swing.JOptionPane;
import desplazable.Desface;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author cr
 */
public class Productos extends javax.swing.JFrame implements Observer {

    int filial = 0;
    String[] getdatos = new String[5]; //poner en mostrar datos
    Conexion conexion = new Conexion();
    //Connection cin = conexion.getConexion();
    PreparedStatement ps;
    /**
     * Creates new form Alumnos
     */
    Desface desplace;
    Desface des;
    int Activado = 0;
    int btnCRUD = 1;

    /*
    void Registrar() {
        //String insertar = "INSERT INTO Alumnos (CURPAlumno, NombreAlumno, NombreMadre, NombrePadre, Años, Meses, Direccion, TelefonoContacto)VALUES (?,?,?,?,?,?,?,?)";
        try {
            ps = cin.prepareStatement("SELECT * FROM Alumnos WHERE CURPAlumno = ?");
            ps.setObject(1, this.T_Curp.getText());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "CURP Repetida, Cambiela");
            } else {

                ps = cin.prepareStatement("INSERT INTO Alumnos (CURPAlumno, NombreAlumno, NombreMadre, NombrePadre, Años, Meses, Direccion, TelefonoContacto)VALUES (?,?,?,?,?,?,?,?)");
                ps.setString(1, T_Curp.getText());
                ps.setString(2, T_Nombre.getText());
                ps.setString(3, T_Madre.getText());
                ps.setString(4, T_Padre.getText());
                ps.setInt(5, Integer.parseInt(T_Anio.getText()));
                ps.setInt(6, Integer.parseInt(T_Meses.getText()));
                ps.setString(7, T_Direccion.getText());
                ps.setString(8, T_Tel.getText());
                ps.executeUpdate();

                JOptionPane.showMessageDialog(this, "Dato Guardado", "Registro", JOptionPane.QUESTION_MESSAGE);
                Limpiar();
            }
            /*int registro = ps.executeUpdate();
           if(registro > 0){
               JOptionPane.showMessageDialog(this, "Dato Guardado","Ingresar",JOptionPane.QUESTION_MESSAGE);
               Limpiar();
           }else{
               JOptionPane.showMessageDialog(this, "Dato No Guardado","Ingresar",JOptionPane.ERROR_MESSAGE);
           }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Dato No Guardado", "Registro", JOptionPane.ERROR_MESSAGE);
        }
    }*/
    static ResultSet res;

    public void CargarArticulo() {
        DefaultTableModel modelo = (DefaultTableModel) tblAlumnos.getModel();
        modelo.setRowCount(0);
        //res = conexion.Consulta("select * from Alumnos");

        try {
            while (res.next()) {
                Vector v = new Vector();
                v.add(res.getString(1));
                v.add(res.getString(2));
                v.add(res.getString(3));
                v.add(res.getString(4));
                v.add(res.getString(5));
                v.add(res.getString(6));
                v.add(res.getString(7));
                v.add(res.getString(8));
                modelo.addRow(v);
                tblAlumnos.setModel(modelo);
            }
        } catch (SQLException e) {

        }
    }

    public Productos() {
        try {
            this.cn = cc.conexion();
        } catch (InstantiationException ex) {
            Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();

        this.getContentPane().setBackground(Color.WHITE);
        this.setTitle("Productos");
        MenuDesplegable.setBackground(new Color(122, 164, 255));
        PanelTabla.setBackground(new Color(122, 164, 255));

        TextPrompt holder;
        holder = new TextPrompt("Introduzca el dato que desea buscar", txtBuscar);
        holder = new TextPrompt("Introduzca el id del producto", T_Curp);
        holder = new TextPrompt("Introduzca el nombre del producto", T_Nombre);
        holder = new TextPrompt("Introduzca el cantidad", T_Madre);
        holder = new TextPrompt("Introduzca el precio", T_Padre);
        holder = new TextPrompt("Introduzca el id de proveedor", T_Anio);
//        holder = new TextPrompt("Introduzca los meses cumplidos", T_Meses);
//        holder = new TextPrompt("Introduzca la direccion proporcionada", T_Direccion);
//        holder = new TextPrompt("Introduzca el telefono de contacto", T_Tel);

        /*PanelTabla.setLayout(new FlowLayout());
        PanelTabla.validate();*/
        desplace = new Desface();
        des = new Desface();

        //desplace.desplazarIzquierda(MenuDesplegable, MenuDesplegable.getX(), -300, 300, 300);
    }

    conexion cc = new conexion();
    Connection cn;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        B_ClicR = new javax.swing.JMenuItem();
        B_ClicA = new javax.swing.JMenuItem();
        B_ClicE = new javax.swing.JMenuItem();
        MenuDesplegable = new javax.swing.JPanel();
        TituloPanel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        T_Curp = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        T_Nombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        T_Madre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        T_Padre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        T_Anio = new javax.swing.JTextField();
        B_Datos = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        B_Datos1 = new javax.swing.JButton();
        B_Datos2 = new javax.swing.JButton();
        PanelTabla = new javax.swing.JPanel();
        btnMostrarDatos = new javax.swing.JButton();
        B_Desplegar = new javax.swing.JButton();
        B_BuscarDatos = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAlumnos = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        B_Inicio = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        B_Opciones = new javax.swing.JMenuItem();
        B_CerrarS = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        B_Educadoras = new javax.swing.JMenuItem();
        B_General = new javax.swing.JMenuItem();
        B_General3 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        B_Registrar = new javax.swing.JMenuItem();

        B_ClicR.setText("Registrar");
        B_ClicR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_ClicRActionPerformed(evt);
            }
        });
        jPopupMenu1.add(B_ClicR);

        B_ClicA.setText("Actualizar");
        B_ClicA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_ClicAActionPerformed(evt);
            }
        });
        jPopupMenu1.add(B_ClicA);

        B_ClicE.setText("Eliminar");
        B_ClicE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_ClicEActionPerformed(evt);
            }
        });
        jPopupMenu1.add(B_ClicE);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MenuDesplegable.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MenuDesplegable.setPreferredSize(new java.awt.Dimension(290, 547));

        TituloPanel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        TituloPanel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TituloPanel.setText("Registre los datos");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Id Producto");

        T_Curp.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Nombre del producto");

        T_Nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Cantidad");

        T_Madre.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Precio");

        T_Padre.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Id Proveedor");

        T_Anio.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        B_Datos.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        B_Datos.setText("Registrar");
        B_Datos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_DatosActionPerformed(evt);
            }
        });

        btnLimpiar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        B_Datos1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        B_Datos1.setText("Actualizar");
        B_Datos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_Datos1ActionPerformed(evt);
            }
        });

        B_Datos2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        B_Datos2.setText("Eliminar");
        B_Datos2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_Datos2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MenuDesplegableLayout = new javax.swing.GroupLayout(MenuDesplegable);
        MenuDesplegable.setLayout(MenuDesplegableLayout);
        MenuDesplegableLayout.setHorizontalGroup(
            MenuDesplegableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TituloPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(T_Curp, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(T_Nombre, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(T_Madre, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(T_Padre, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(T_Anio, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(MenuDesplegableLayout.createSequentialGroup()
                .addGroup(MenuDesplegableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MenuDesplegableLayout.createSequentialGroup()
                        .addComponent(btnLimpiar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuDesplegableLayout.createSequentialGroup()
                        .addGap(0, 175, Short.MAX_VALUE)
                        .addGroup(MenuDesplegableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(B_Datos, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(B_Datos1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(B_Datos2, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        MenuDesplegableLayout.setVerticalGroup(
            MenuDesplegableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuDesplegableLayout.createSequentialGroup()
                .addComponent(TituloPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(T_Curp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(T_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(T_Madre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(T_Padre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(T_Anio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(B_Datos)
                .addGap(18, 18, 18)
                .addComponent(B_Datos1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(B_Datos2)
                .addGap(18, 18, 18)
                .addComponent(btnLimpiar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelTabla.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnMostrarDatos.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnMostrarDatos.setText("Mostrar todos los datos");
        btnMostrarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarDatosActionPerformed(evt);
            }
        });

        B_Desplegar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/IconoRegistrar.png"))); // NOI18N
        B_Desplegar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_DesplegarActionPerformed(evt);
            }
        });

        B_BuscarDatos.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        B_BuscarDatos.setText("Buscar");
        B_BuscarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_BuscarDatosActionPerformed(evt);
            }
        });

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });

        tblAlumnos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tblAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Curp Alumno", "Nombre Alumno", "Nombre Madre", "Nombre Padre", "Title 5"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAlumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAlumnosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAlumnos);

        javax.swing.GroupLayout PanelTablaLayout = new javax.swing.GroupLayout(PanelTabla);
        PanelTabla.setLayout(PanelTablaLayout);
        PanelTablaLayout.setHorizontalGroup(
            PanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTablaLayout.createSequentialGroup()
                .addComponent(B_Desplegar)
                .addGap(18, 18, 18)
                .addComponent(txtBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(B_BuscarDatos)
                .addGap(18, 18, 18)
                .addComponent(btnMostrarDatos))
            .addGroup(PanelTablaLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelTablaLayout.setVerticalGroup(
            PanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTablaLayout.createSequentialGroup()
                .addGroup(PanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(B_Desplegar)
                    .addGroup(PanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnMostrarDatos)
                        .addComponent(B_BuscarDatos)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                .addContainerGap())
        );

        jMenuBar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        B_Inicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Inicio.png"))); // NOI18N
        B_Inicio.setText("Inicio");
        B_Inicio.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        B_Inicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B_InicioMouseClicked(evt);
            }
        });
        B_Inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_InicioActionPerformed(evt);
            }
        });
        jMenuBar1.add(B_Inicio);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Sesion.png"))); // NOI18N
        jMenu1.setText("Sesión");
        jMenu1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        B_Opciones.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        B_Opciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Sesion.png"))); // NOI18N
        B_Opciones.setText("Opciones");
        B_Opciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                B_OpcionesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                B_OpcionesMouseExited(evt);
            }
        });
        B_Opciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_OpcionesActionPerformed(evt);
            }
        });
        jMenu1.add(B_Opciones);

        B_CerrarS.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        B_CerrarS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Sesion.png"))); // NOI18N
        B_CerrarS.setText("Cerrar Sesión");
        B_CerrarS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                B_CerrarSMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                B_CerrarSMouseExited(evt);
            }
        });
        B_CerrarS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_CerrarSActionPerformed(evt);
            }
        });
        jMenu1.add(B_CerrarS);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Personal.png"))); // NOI18N
        jMenu2.setText("Inventario");
        jMenu2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        B_Educadoras.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        B_Educadoras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Personal.png"))); // NOI18N
        B_Educadoras.setText("Empleados");
        B_Educadoras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                B_EducadorasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                B_EducadorasMouseExited(evt);
            }
        });
        B_Educadoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_EducadorasActionPerformed(evt);
            }
        });
        jMenu2.add(B_Educadoras);

        B_General.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        B_General.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Personal.png"))); // NOI18N
        B_General.setText("Clientes");
        B_General.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                B_GeneralMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                B_GeneralMouseExited(evt);
            }
        });
        B_General.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_GeneralActionPerformed(evt);
            }
        });
        jMenu2.add(B_General);

        B_General3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        B_General3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Personal.png"))); // NOI18N
        B_General3.setText("Proveedores");
        B_General3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                B_General3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                B_General3MouseExited(evt);
            }
        });
        B_General3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_General3ActionPerformed(evt);
            }
        });
        jMenu2.add(B_General3);

        jMenuBar1.add(jMenu2);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Evaluaciones.png"))); // NOI18N
        jMenu4.setText("Ventas");
        jMenu4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        B_Registrar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        B_Registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Evaluaciones.png"))); // NOI18N
        B_Registrar.setText("Registrar");
        B_Registrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                B_RegistrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                B_RegistrarMouseExited(evt);
            }
        });
        B_Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_RegistrarActionPerformed(evt);
            }
        });
        jMenu4.add(B_Registrar);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(MenuDesplegable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuDesplegable, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
            .addComponent(PanelTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void B_OpcionesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B_OpcionesMouseEntered

    }//GEN-LAST:event_B_OpcionesMouseEntered

    private void B_OpcionesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B_OpcionesMouseExited

    }//GEN-LAST:event_B_OpcionesMouseExited

    private void B_CerrarSMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B_CerrarSMouseEntered

    }//GEN-LAST:event_B_CerrarSMouseEntered

    private void B_CerrarSMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B_CerrarSMouseExited

    }//GEN-LAST:event_B_CerrarSMouseExited

    private void B_CerrarSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_CerrarSActionPerformed
        int salida;
        salida = JOptionPane.showConfirmDialog(this, "¿Seguro/a que desea salir?", "Confirmar", JOptionPane.OK_CANCEL_OPTION);

        if (salida == 0) {
            this.dispose();
            InicioSesion p = new InicioSesion();
            p.setVisible(true);
            p.setLocationRelativeTo(null);
            p.setResizable(false);
        }
    }//GEN-LAST:event_B_CerrarSActionPerformed

    private void B_EducadorasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B_EducadorasMouseEntered

    }//GEN-LAST:event_B_EducadorasMouseEntered

    private void B_EducadorasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B_EducadorasMouseExited

    }//GEN-LAST:event_B_EducadorasMouseExited

    private void B_EducadorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_EducadorasActionPerformed
        int salida;
        salida = JOptionPane.showConfirmDialog(this, "¿Seguro/a que desea salir? Se perderan los datos no guardados", "Confirmar", JOptionPane.OK_CANCEL_OPTION);

        if (salida == 0) {
            this.dispose();
            Empleados p = new Empleados();
            p.setVisible(true);
            p.setLocationRelativeTo(null);
            p.setResizable(false);
        }
    }//GEN-LAST:event_B_EducadorasActionPerformed

    private void B_GeneralMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B_GeneralMouseEntered

    }//GEN-LAST:event_B_GeneralMouseEntered

    private void B_GeneralMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B_GeneralMouseExited

    }//GEN-LAST:event_B_GeneralMouseExited

    private void B_RegistrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B_RegistrarMouseEntered

    }//GEN-LAST:event_B_RegistrarMouseEntered

    private void B_RegistrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B_RegistrarMouseExited

    }//GEN-LAST:event_B_RegistrarMouseExited

    private void B_DesplegarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_DesplegarActionPerformed
        //Animacion del menu

        if (Activado == 0) {
            //MenuDesplegable.setSize(new Dimension(0, MenuDesplegable.getHeight()));
            desplace.desplazarIzquierda(MenuDesplegable, MenuDesplegable.getX(), -310, 10, 10);
            des.desplazarIzquierda(PanelTabla, PanelTabla.getX(), 20, 10, 10);
            this.setSize(new Dimension(this.getWidth() - 250, this.getHeight()));
            //PanelTabla.setSize(new Dimension(900,PanelTabla.getHeight()));
            Activado = 1;
        } else {
            //MenuDesplegable.setSize(new Dimension(300, MenuDesplegable.getHeight()));
            desplace.desplazarDerecha(MenuDesplegable, MenuDesplegable.getX(), 10, 10, 10);
            des.desplazarDerecha(PanelTabla, PanelTabla.getX(), 310, 10, 10);
            this.setSize(new Dimension(this.getWidth() + 250, this.getHeight()));
            //PanelTabla.setSize(new Dimension(618,PanelTabla.getHeight()));
            Activado = 0;
        }

        /*if (MenuDesplegable.getX() == 0) {
            desplace.desplazarIzquierda(MenuDesplegable, MenuDesplegable.getX(), -300, 10, 10);

        } else if (MenuDesplegable.getX() == -300) {
            desplace.desplazarDerecha(MenuDesplegable, MenuDesplegable.getX(), 0, 10, 10);
        }*/
    }//GEN-LAST:event_B_DesplegarActionPerformed

    private void B_InicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_InicioActionPerformed

    }//GEN-LAST:event_B_InicioActionPerformed

    private void B_InicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B_InicioMouseClicked
        int salida;
        salida = JOptionPane.showConfirmDialog(this, "¿Seguro/a que desea salir? Se perderan los datos no guardados", "Confirmar", JOptionPane.OK_CANCEL_OPTION);

        if (salida == 0) {
            this.dispose();
            Principal p = new Principal();
            p.setVisible(true);
            p.setLocationRelativeTo(null);
            p.setResizable(false);
        }
    }//GEN-LAST:event_B_InicioMouseClicked

    private void B_ClicRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_ClicRActionPerformed
        if (Activado == 1) {
            desplace.desplazarDerecha(MenuDesplegable, MenuDesplegable.getX(), 10, 10, 10);
            des.desplazarDerecha(PanelTabla, PanelTabla.getX(), 310, 10, 10);
            this.setSize(new Dimension(this.getWidth() + 250, this.getHeight()));
            Activado = 0;
        }
        btnCRUD = 1;
        if (btnCRUD == 1) {
            TituloPanel.setText("Registre los datos");

            B_Datos.setText("Registrar datos");
        }

    }//GEN-LAST:event_B_ClicRActionPerformed

    private void B_ClicAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_ClicAActionPerformed
        if (Activado == 1) {
            desplace.desplazarDerecha(MenuDesplegable, MenuDesplegable.getX(), 10, 10, 10);
            des.desplazarDerecha(PanelTabla, PanelTabla.getX(), 310, 10, 10);
            this.setSize(new Dimension(this.getWidth() + 250, this.getHeight()));
            Activado = 0;
        }

        btnCRUD = 2;
        if (btnCRUD == 2) {
            TituloPanel.setText("Actualice los datos");
            B_Datos.setText("Actualice datos");
        }

    }//GEN-LAST:event_B_ClicAActionPerformed

    private void B_ClicEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_ClicEActionPerformed
        if (Activado == 1) {
            desplace.desplazarDerecha(MenuDesplegable, MenuDesplegable.getX(), 10, 10, 10);
            des.desplazarDerecha(PanelTabla, PanelTabla.getX(), 310, 10, 10);
            this.setSize(new Dimension(this.getWidth() + 250, this.getHeight()));
            Activado = 0;
        }
        btnCRUD = 3;
        if (btnCRUD == 3) {
            TituloPanel.setText("Elimine los datos");
            B_Datos.setText("Elimine datos");
        }

    }//GEN-LAST:event_B_ClicEActionPerformed

    private void B_DatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_DatosActionPerformed
        //acciones del boton Registrar datos
        registrarserver3();

    }//GEN-LAST:event_B_DatosActionPerformed

    private void btnMostrarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarDatosActionPerformed
        // TODO add your handling code here:

        mostrardatosfilial2(txtBuscar.getText());
        //mostrardatosfilial2("");
        //mostrardatos("");
//CargarArticulo();
    }//GEN-LAST:event_btnMostrarDatosActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        Limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void B_BuscarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_BuscarDatosActionPerformed
        // TODO add your handling code here:
        try {
            //ps = cin.prepareStatement("SELECT * FROM Alumnos WHERE CURPAlumno = ?");
            ps.setObject(1, this.txtBuscar.getText());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                DefaultTableModel modelo = (DefaultTableModel) tblAlumnos.getModel();
                modelo.setRowCount(0);

                //String curp = T_Buscar.getText();
                //ps = cin.prepareStatement("SELECT CURPAlumno, NombreAlumno, NombreMadre, NombrePadre, Años, Meses, Direccion, TelefonoContacto FROM Alumnos WHERE CURPAlumno=?");
                ps.setString(1, txtBuscar.getText());
                res = ps.executeQuery();

                //try {
                while (res.next()) {
                    Vector v = new Vector();
                    v.add(res.getString(1));
                    v.add(res.getString(2));
                    v.add(res.getString(3));
                    v.add(res.getString(4));
                    v.add(res.getString(5));
//                    v.add(res.getString(6));
//                    v.add(res.getString(7));
//                    v.add(res.getString(8));
                    modelo.addRow(v);
                    tblAlumnos.setModel(modelo);
                }
                JOptionPane.showMessageDialog(this, "Dato Encontrado", "Consulta", JOptionPane.QUESTION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "El Dato No Existe");

                //Limpiar();
            }
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(this, "Dato No Guardado", "Registro", JOptionPane.ERROR_MESSAGE);
        }

        /*try {
            DefaultTableModel modelo = (DefaultTableModel) tblAlumnos.getModel();
            modelo.setRowCount(0);

            //String curp = T_Buscar.getText();
            ps = cin.prepareStatement("SELECT CURPAlumno, NombreAlumno, NombreMadre, NombrePadre, Años, Meses, Direccion, TelefonoContacto FROM Alumnos WHERE CURPAlumno=?");
            ps.setString(1, T_Buscar.getText());
            res = ps.executeQuery();

            //try {
            while (res.next()) {
                Vector v = new Vector();
                v.add(res.getString(1));
                v.add(res.getString(2));
                v.add(res.getString(3));
                v.add(res.getString(4));
                v.add(res.getString(5));
                v.add(res.getString(6));
                v.add(res.getString(7));
                v.add(res.getString(8));
                modelo.addRow(v);
                tblAlumnos.setModel(modelo);
            }
        }catch (SQLException e) {

        }*/
    }//GEN-LAST:event_B_BuscarDatosActionPerformed

    private void B_OpcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_OpcionesActionPerformed
       /* int salida;
        salida = JOptionPane.showConfirmDialog(this, "¿Seguro/a que desea salir? Se perderan los datos no guardados", "Confirmar", JOptionPane.OK_CANCEL_OPTION);

        if (salida == 0) {
            this.dispose();
            Opciones p = new Opciones();
            p.setVisible(true);
            p.setLocationRelativeTo(null);
            p.setResizable(false);
        }*/
    }//GEN-LAST:event_B_OpcionesActionPerformed

    private void B_GeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_GeneralActionPerformed
        int salida;
        salida = JOptionPane.showConfirmDialog(this, "¿Seguro/a que desea salir? Se perderan los datos no guardados", "Confirmar", JOptionPane.OK_CANCEL_OPTION);

        if (salida == 0) {
            this.dispose();
            Clientes p = new Clientes();
            p.setVisible(true);
            p.setLocationRelativeTo(null);
            p.setResizable(false);
        }
    }//GEN-LAST:event_B_GeneralActionPerformed

    private void B_RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_RegistrarActionPerformed
        int salida;
        salida = JOptionPane.showConfirmDialog(this, "¿Seguro/a que desea salir? Se perderan los datos no guardados", "Confirmar", JOptionPane.OK_CANCEL_OPTION);

        if (salida == 0) {
            this.dispose();
            Ventas p = new Ventas();
            p.setVisible(true);
            p.setLocationRelativeTo(null);
            p.setResizable(false);
        }
    }//GEN-LAST:event_B_RegistrarActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void B_Datos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_Datos1ActionPerformed
        // TODO add your handling code here:
        actualizadatos(T_Curp.getText());
    }//GEN-LAST:event_B_Datos1ActionPerformed

    private void B_Datos2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_Datos2ActionPerformed
        // TODO add your handling code here:
        eliminadatos(T_Curp.getText());
    }//GEN-LAST:event_B_Datos2ActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void B_General3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B_General3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_B_General3MouseEntered

    private void B_General3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B_General3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_B_General3MouseExited

    private void B_General3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_General3ActionPerformed
        // TODO add your handling code here:
         int salida;
        salida = JOptionPane.showConfirmDialog(this, "¿Seguro/a que desea salir? Se perderan los datos no guardados", "Confirmar", JOptionPane.OK_CANCEL_OPTION);

        if (salida == 0) {
            this.dispose();
            Proveedores p = new Proveedores();
            p.setVisible(true);
            p.setLocationRelativeTo(null);
            p.setResizable(false);
        }
        
    }//GEN-LAST:event_B_General3ActionPerformed

    private void tblAlumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAlumnosMouseClicked
        // TODO add your handling code here:
        int fila = tblAlumnos.getSelectedRow();
        String curp = tblAlumnos.getValueAt(fila, 0).toString();

        //ps = cin.prepareStatement("SELECT CURPAlumno, NombreAlumno, NombreMadre, NombrePadre, Años, Meses, Direccion, TelefonoContacto FROM Alumnos WHERE CURPAlumno=?");
        //ps.setString(1, curp);
        //res = ps.executeQuery();

        T_Curp.setText(tblAlumnos.getValueAt(fila, 0).toString());
        T_Nombre.setText(tblAlumnos.getValueAt(fila, 1).toString());
        T_Madre.setText(tblAlumnos.getValueAt(fila, 2).toString());
        T_Padre.setText(tblAlumnos.getValueAt(fila, 3).toString());
        T_Anio.setText(tblAlumnos.getValueAt(fila, 4).toString());
//        T_Meses.setText(tblAlumnos.getValueAt(fila, 5).toString());
//        T_Direccion.setText(tblAlumnos.getValueAt(fila, 6).toString());
//        T_Tel.setText(tblAlumnos.getValueAt(fila, 7).toString());
    }//GEN-LAST:event_tblAlumnosMouseClicked

    void mostrardatos(String valor) {
        filial = 0;
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Id_Productos");
        modelo.addColumn("Producto");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio");
        modelo.addColumn("Id_proveedor");
//        modelo.addColumn("Meses");
//        modelo.addColumn("Direccion");
//        modelo.addColumn("Telefono");
        tblAlumnos.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT * FROM productos";
        } else {
            sql = "SELECT * FROM productos WHERE Producto='" + valor + "'";
        }
        String[] datos = new String[5];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
//                datos[5] = rs.getString(6);
//                datos[6] = rs.getString(7);
//                datos[7] = rs.getString(8);

                modelo.addRow(datos);
            }
            tblAlumnos.setModel(modelo);
            if (modelo.getDataVector().isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se encontro el producto");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void mostrardatosfilial(String valor) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Id_productos");
        modelo.addColumn("Producto");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio");
        modelo.addColumn("Id_Proveedor");
        tblAlumnos.setModel(modelo);
        String sql = "";
        sql = "SELECT * FROM productos";
        Cliente c = new Cliente(5001, "192.168.1.81", sql);
        c.addObserver(this);
        Thread t = new Thread(c);
        t.start();
        filial = 1;
        modelo.addRow(getdatos);
        tblAlumnos.setModel(modelo);
        if (modelo.getDataVector().isEmpty()) {
            t.interrupt();
            filial = 0;
            JOptionPane.showMessageDialog(null, "No se encontro el pedido");
        }
    }

    void mostrardatosfilial2(String valor) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Id_productos");
        modelo.addColumn("Producto");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio");
        modelo.addColumn("Id_proveedor");
//        modelo.addColumn("Meses");
//        modelo.addColumn("Direccion");
//        modelo.addColumn("Telefono");
        tblAlumnos.setModel(modelo);
        String sql = "";
        sql = "SELECT * FROM productos WHERE Id_productos='" + valor + "'" ;
        Cliente c = new Cliente(5003, "192.168.1.115", sql);
        c.addObserver(this);
        Thread t = new Thread(c);
        t.start();
        filial = 1;
        modelo.addRow(getdatos);
        tblAlumnos.setModel(modelo);
        if (modelo.getDataVector().isEmpty()) {
            t.interrupt();
            filial = 0;
            JOptionPane.showMessageDialog(null, "No se encontro el pedido");
        }
    }

   /* void registrarserver2() {
        String sql = "";
        sql = "INSERT INTO Alumnos (CURPAlumno, NombreAlumno, NombreMadre , NombrePadre , Anios , Meses , Direccion, Telefono) VALUES ('" + T_Curp.getText() +"', '" + T_Nombre.getText() +"', '" + T_Madre.getText() +"', '" + T_Padre.getText() +"', '" + T_Anio.getText() +"', '" + T_Meses.getText() +"', '" + T_Direccion.getText() +"', '" + T_Tel.getText() +"')";
        //sql = "SELECT * FROM Alumnos WHERE NombreAlumno='" + valor + "'";
        Cliente c = new Cliente(5002, "192.168.189.15", sql);
        c.addObserver(this);
        Thread t = new Thread(c);
        t.start();
    }*/
    
   /* void registrarserver2() {
        String sql = "";
        sql = "INSERT INTO productos (Id_productos, Producto, Cantidad, Precio, Id_proveedor) VALUES ('" + T_Curp.getText() +"', '" + T_Nombre.getText() +"', '" + T_Madre.getText() +"', '" + T_Padre.getText() +"', '" + T_Anio.getText() + "')";
        //sql = "SELECT * FROM Alumnos WHERE NombreAlumno='" + valor + "'";
        Cliente c = new Cliente(5001, "192.168.1.81", sql);
        c.addObserver(this);
        Thread t = new Thread(c);
        t.start();
    }*/
    
    void registrarserver3() {
        String sql = "";
        sql = "INSERT INTO productos (Id_productos, Producto, Cantidad, Precio, Id_proveedor) VALUES ('" + T_Curp.getText() +"', '" + T_Nombre.getText() +"', '" + T_Madre.getText() +"', '" + T_Padre.getText() +"', '" + T_Anio.getText() +"')";
        //sql = "SELECT * FROM Alumnos WHERE NombreAlumno='" + valor + "'";
        Cliente c = new Cliente(5003, "192.168.1.115", sql);
        c.addObserver(this);
        Thread t = new Thread(c);
        t.start();
    }

void actualizadatos(String curp) {
        String sql = "";
        sql = "UPDATE productos SET Producto= '" + T_Nombre.getText() +"', Cantidad ='" + T_Madre.getText() +"', Precio='" + T_Padre.getText() +"', Id_proveedor='" + T_Anio.getText() + "' WHERE Id_productos='" + T_Curp.getText() +"'";
        //sql = "SELECT * FROM Alumnos WHERE NombreAlumno='" + valor + "'";
        Cliente c = new Cliente(5003, "192.168.1.115", sql);
        c.addObserver(this);
        Thread t = new Thread(c);
        t.start();
    }
    
    void eliminadatos(String cod) {
        String sql = "";
        sql = "DELETE from productos WHERE Id_productos = '" + T_Curp.getText() + "'";
        //sql = "SELECT * FROM Alumnos WHERE NombreAlumno='" + valor + "'";
        Cliente c = new Cliente(5003, "192.168.1.115", sql);
        c.addObserver(this);
        Thread t = new Thread(c);
        t.start();
    }

    void Modificar() {
        try {

            //ps = cin.prepareStatement("UPDATE Alumnos SET NombreAlumno=?,NombreMadre=?, NombrePadre=?, Años=?, Meses=?, Direccion=?, TelefonoContacto=? WHERE CURPAlumno=?");
            ps.setString(1, T_Nombre.getText());
            ps.setString(2, T_Madre.getText());
            ps.setString(3, T_Padre.getText());
            ps.setInt(4, Integer.parseInt(T_Anio.getText()));
//            ps.setInt(5, Integer.parseInt(T_Meses.getText()));
//            ps.setString(6, T_Direccion.getText());
//            ps.setString(7, T_Tel.getText());
            ps.setString(8, T_Curp.getText());
            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Dato Modificado", "Ingresar", JOptionPane.QUESTION_MESSAGE);
            Limpiar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Dato No Modificado", "Ingresar", JOptionPane.ERROR_MESSAGE);
        }

    }

    void Eliminar() {
        try {

            //ps = cin.prepareStatement("DELETE FROM Alumnos WHERE CURPAlumno=?");
            ps.setString(1, T_Curp.getText());
            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Alumno Eliminado", "Ingresar", JOptionPane.QUESTION_MESSAGE);
            Limpiar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Alumno No Eliminado", "Ingresar", JOptionPane.ERROR_MESSAGE);
        }

    }

    void Limpiar() {
        T_Curp.setText("");
        T_Nombre.setText("");
        T_Madre.setText("");
        T_Padre.setText("");
        T_Anio.setText("");
//        T_Meses.setText("");
//        T_Direccion.setText("");
//        T_Tel.setText("");
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
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
                }
                new Productos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B_BuscarDatos;
    private javax.swing.JMenuItem B_CerrarS;
    private javax.swing.JMenuItem B_ClicA;
    private javax.swing.JMenuItem B_ClicE;
    private javax.swing.JMenuItem B_ClicR;
    private javax.swing.JButton B_Datos;
    private javax.swing.JButton B_Datos1;
    private javax.swing.JButton B_Datos2;
    private javax.swing.JButton B_Desplegar;
    private javax.swing.JMenuItem B_Educadoras;
    private javax.swing.JMenuItem B_General;
    private javax.swing.JMenuItem B_General3;
    private javax.swing.JMenu B_Inicio;
    private javax.swing.JMenuItem B_Opciones;
    private javax.swing.JMenuItem B_Registrar;
    private javax.swing.JPanel MenuDesplegable;
    private javax.swing.JPanel PanelTabla;
    private javax.swing.JTextField T_Anio;
    private javax.swing.JTextField T_Curp;
    private javax.swing.JTextField T_Madre;
    private javax.swing.JTextField T_Nombre;
    private javax.swing.JTextField T_Padre;
    private javax.swing.JLabel TituloPanel;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnMostrarDatos;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAlumnos;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        if (arg instanceof datos && filial == 1) {
            datos g = (datos) arg;
            getdatos = g.getInfo();
        }
    }
}
