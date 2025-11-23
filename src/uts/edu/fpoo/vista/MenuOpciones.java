package uts.edu.fpoo.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import uts.edu.fpoo.controlador.MesasControlador;
import uts.edu.fpoo.controlador.PlatosControlador;
import uts.edu.fpoo.vista.MesasVista;
import uts.edu.fpoo.vista.PedidosVista;
import uts.edu.fpoo.vista.PlatosVista;

/**
 * Menú principal con interfaz tipo dashboard.
 */
public class MenuOpciones extends JFrame {

    // Panel lateral e interno
    private JPanel sideMenuPanel;
    private JPanel mainPanel;
    private JButton botonSeleccionado;

    // Barra de menú superior (si la quieres seguir usando)
    private JMenuBar jMenuBar1;
    
    private ImageIcon cargarIcono(String nombreArchivo, int ancho, int alto){
        java.net.URL url = getClass().getClass().getResource("/uts/edu/fpoo/icons/" + nombreArchivo);
        if (url== null){
            System.out.println("No se encontro icono: " + nombreArchivo);
            return null;
        }
        ImageIcon icon = new ImageIcon(url);
        Image img  = icon.getImage().getScaledInstance(ancho, alto,Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }
    private void mostrarFrameEnMain(javax.swing.JFrame frame){
        mainPanel.removeAll();
        java.awt.Container contenido=frame.getContentPane();
        
        // creamos un panle contenedor
        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.setOpaque(false);
        wrapper.add(contenido, BorderLayout.CENTER);
        
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(wrapper, BorderLayout.CENTER);
        mainPanel.revalidate();
        mainPanel.repaint();
        
        aplicarFadeIn(wrapper);
    }
    

    public MenuOpciones() {
        initComponents();
        construirUI();
    }

    /**
     * Solo crea los componentes base que NetBeans esperaba.
     * Ya no usamos AbsoluteLayout ni el contentPanel viejo.
     */
    private void initComponents() {
        jMenuBar1 = new JMenuBar();
        setJMenuBar(jMenuBar1);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 700);
        setLocationRelativeTo(null);
    }

    /**
     * Construye toda la interfaz moderna.
     */
    private void construirUI() {
        // ----- LAYOUT PRINCIPAL DEL FRAME -----
        getContentPane().setLayout(new BorderLayout());
        Color colorFondo = new Color(245, 245, 245);
        getContentPane().setBackground(colorFondo);

        // ----- PANEL LATERAL -----
        sideMenuPanel = new JPanel();
        sideMenuPanel.setPreferredSize(new Dimension(230, 700));
        sideMenuPanel.setBackground(new Color(255, 204, 0)); // amarillo restaurante
        sideMenuPanel.setLayout(new BoxLayout(sideMenuPanel, BoxLayout.Y_AXIS));
        sideMenuPanel.setBorder(new EmptyBorder(25, 20, 25, 20));

        // LOGO / TÍTULO
        JLabel lblLogo = new JLabel("Mi Restaurante");
        lblLogo.setAlignmentX(LEFT_ALIGNMENT);
        lblLogo.setFont(new Font("SansSerif", Font.BOLD, 22));
        lblLogo.setForeground(new Color(40, 40, 40));

        // si quieres usar una imagen de logo.png:
        // lblLogo.setIcon(new ImageIcon(getClass().getResource("/uts/edu/fpoo/icons/Logo.png")));
        // lblLogo.setHorizontalTextPosition(SwingConstants.RIGHT);
        // lblLogo.setIconTextGap(10);

        sideMenuPanel.add(lblLogo);
        sideMenuPanel.add(Box.createVerticalStrut(25));

        // SEPARADOR
        sideMenuPanel.add(crearLineaSeparadora());
        sideMenuPanel.add(Box.createVerticalStrut(15));

        // ----- BOTONES DEL MENÚ LATERAL -----
        JButton btnInicio = crearBotonMenu("Inicio", null);
        JButton btnPlatos = crearBotonMenu("Platos",
                new ImageIcon(getClass().getResource("/uts/edu/fpoo/icons/plato.png")));
        JButton btnMesas = crearBotonMenu("Mesas",
                new ImageIcon(getClass().getResource("/uts/edu/fpoo/icons/mesa.png")));
        JButton btnPedidos = crearBotonMenu("Pedidos",
                new ImageIcon(getClass().getResource("/uts/edu/fpoo/icons/Movimientos.png")));
        JButton btnUsuarios = crearBotonMenu("Usuarios",
                new ImageIcon(getClass().getResource("/uts/edu/fpoo/icons/Archivo.png")));
        JButton btnAyuda = crearBotonMenu("Ayuda",
                new ImageIcon(getClass().getResource("/uts/edu/fpoo/icons/Ayuda.png")));

        sideMenuPanel.add(btnInicio);
        sideMenuPanel.add(Box.createVerticalStrut(8));
        sideMenuPanel.add(btnPlatos);
        sideMenuPanel.add(Box.createVerticalStrut(8));
        sideMenuPanel.add(btnMesas);
        sideMenuPanel.add(Box.createVerticalStrut(8));
        sideMenuPanel.add(btnPedidos);
        sideMenuPanel.add(Box.createVerticalStrut(8));
        sideMenuPanel.add(btnUsuarios);

        sideMenuPanel.add(Box.createVerticalGlue()); // empuja hacia arriba

        // BOTÓN CERRAR SESIÓN
        JButton btnCerrarSesion = crearBotonMenu("Cerrar sesión",
                new ImageIcon(getClass().getResource("/uts/edu/fpoo/icons/Archivo.png")));
        btnCerrarSesion.setAlignmentX(LEFT_ALIGNMENT);
        sideMenuPanel.add(btnCerrarSesion);

        // ----- PANEL PRINCIPAL -----
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setBorder(new EmptyBorder(40, 40, 40, 40));

        mostrarPantallaInicio();

        // Agregamos paneles al frame
        getContentPane().add(sideMenuPanel, BorderLayout.WEST);
        getContentPane().add(mainPanel, BorderLayout.CENTER);

        // ----- ACCIONES DE LOS BOTONES -----
                btnInicio.addActionListener(e -> {
            marcarBotonSeleccionado(btnInicio);
            mostrarPantallaInicio();
        });


               btnPlatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                marcarBotonSeleccionado(btnPlatos);
                abrirPlatosVista();
            }
        });

        btnMesas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                marcarBotonSeleccionado(btnMesas);
                abrirMesasVista();
            }
        });

        btnPedidos.addActionListener(e -> {
            marcarBotonSeleccionado(btnPedidos);
            abrirPedidosVista();
        });

        btnUsuarios.addActionListener(e -> {
            marcarBotonSeleccionado(btnUsuarios);
            mostrarMensajeSimple("Módulo de usuarios próximamente…");
        });

        btnAyuda.addActionListener(e -> {
            marcarBotonSeleccionado(btnAyuda);
            mostrarMensajeSimple("Ayuda en construcción…");
        });

                btnCerrarSesion.addActionListener(e -> {
            marcarBotonSeleccionado(null);
            dispose(); // por ahora cierra todo
        });

    }

    /**
     * Crea un botón estilizado para el menú lateral.
     */
    private JButton crearBotonMenu(String texto, ImageIcon icono) {
        JButton btn = new JButton(texto);
        btn.setAlignmentX(LEFT_ALIGNMENT);
        btn.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        btn.setFont(new Font("SansSerif", Font.PLAIN, 14));
        btn.setFocusPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setHorizontalAlignment(SwingConstants.LEFT);
        btn.setIcon(icono);
        btn.setIconTextGap(10);
        btn.setBackground(new Color(255, 214, 70));
        btn.setBorder(BorderFactory.createEmptyBorder(5, 12, 5, 5));
        btn.setForeground(new Color(40, 40, 40));

        // “Animación” sencilla: cambio suave de color al pasar el mouse
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            Color base = btn.getBackground();
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                if (btn != botonSeleccionado){
                btn.setBackground(new Color(255, 230, 120));
            }
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                if (btn != botonSeleccionado){
                btn.setBackground(base);
                }
            }
        });

        return btn;
    }
        private void marcarBotonSeleccionado(JButton btn) {
        if (botonSeleccionado != null) {
            // volver el anterior a su color base
            botonSeleccionado.setBackground(new Color(255, 214, 70));
        }
        botonSeleccionado = btn;
        if (botonSeleccionado != null) {
            botonSeleccionado.setBackground(new Color(255, 190, 40)); // un poco más oscuro
        }
    }


    /**
     * Línea discreta para separar secciones del menú.
     */
    private JPanel crearLineaSeparadora() {
        JPanel line = new JPanel();
        line.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));
        line.setBackground(new Color(230, 180, 0));
        return line;
    }

    /**
     * Pantalla de “dashboard” de bienvenida.
     */
    private void mostrarPantallaInicio() {
        mainPanel.removeAll();

        JPanel panel = new JPanel(new BorderLayout());
        panel.setOpaque(false);
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JLabel lblTitulo = new JLabel("¡Bienvenidos!");
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 32));
        lblTitulo.setForeground(new Color(40, 40, 40));

        JLabel lblSub = new JLabel("Una experiencia gastronómica para recordar");
        lblSub.setFont(new Font("SansSerif", Font.PLAIN, 16));
        lblSub.setForeground(new Color(90, 90, 90));

        JLabel lblDesc = new JLabel(
                "<html>Administra mesas, platos y pedidos desde el menú lateral.<br>"
                        + "Haz clic en una opción para comenzar.</html>");
        lblDesc.setFont(new Font("SansSerif", Font.PLAIN, 13));
        lblDesc.setForeground(new Color(110, 110, 110));

        JPanel textoPanel = new JPanel();
        textoPanel.setOpaque(false);
        textoPanel.setLayout(new BoxLayout(textoPanel, BoxLayout.Y_AXIS));
        textoPanel.add(lblTitulo);
        textoPanel.add(Box.createVerticalStrut(10));
        textoPanel.add(lblSub);
        textoPanel.add(Box.createVerticalStrut(20));
        textoPanel.add(lblDesc);

        panel.add(textoPanel, BorderLayout.WEST);
        
        // ---- Tarjeta derecha tipo estadísticas
        JPanel card = new JPanel();
        card.setPreferredSize(new Dimension(260, 160));
        card.setBackground(new Color(255, 255, 255));
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(230, 230, 230)),
                new EmptyBorder(15, 15, 15, 15)
        ));
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));

        JLabel lblToday = new JLabel("Resumen del día");
        lblToday.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblToday.setForeground(new Color(60, 60, 60));

        JLabel lblStat1 = new JLabel("• Mesas activas: 5");
        JLabel lblStat2 = new JLabel("• Pedidos en curso: 12");
        JLabel lblStat3 = new JLabel("• Platos registrados: 24");

        lblStat1.setFont(new Font("SansSerif", Font.PLAIN, 12));
        lblStat2.setFont(new Font("SansSerif", Font.PLAIN, 12));
        lblStat3.setFont(new Font("SansSerif", Font.PLAIN, 12));

        lblStat1.setForeground(new Color(80, 80, 80));
        lblStat2.setForeground(new Color(80, 80, 80));
        lblStat3.setForeground(new Color(80, 80, 80));

        card.add(lblToday);
        card.add(Box.createVerticalStrut(8));
        card.add(lblStat1);
        card.add(Box.createVerticalStrut(4));
        card.add(lblStat2);
        card.add(Box.createVerticalStrut(4));
        card.add(lblStat3);

        panel.add(card, BorderLayout.EAST);
        
        

        mainPanel.add(panel, BorderLayout.CENTER);
        mainPanel.revalidate();
        mainPanel.repaint();
        
        aplicarFadeIn(panel);
    }

    private void mostrarMensajeSimple(String mensaje) {
        mainPanel.removeAll();
        JLabel lbl = new JLabel(mensaje);
        lbl.setFont(new Font("SansSerif", Font.PLAIN, 16));
        lbl.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(lbl, BorderLayout.CENTER);
        if (mainPanel instanceof JPanel){
            aplicarFadeIn(mainPanel);
        }
        mainPanel.revalidate();
        mainPanel.repaint();
    }
    
        private void aplicarFadeIn(JPanel panel) {
        // Truco sencillo: hacemos varios repaints con pequeñas pausas
        // (no es un fade real alfa, pero sirve para que se vea más suave el cambio)
        new Thread(() -> {
            try {
                for (int i = 0; i < 4; i++) {
                    Thread.sleep(40);
                    panel.repaint();
                }
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }


    // --------- APERTURA DE VISTAS -----------

    private void abrirPlatosVista() {
        PlatosVista pv = new PlatosVista();
        new PlatosControlador(pv);
        pv.setLocationRelativeTo(this);
        pv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pv.setVisible(true);
        
    }

    private void abrirMesasVista() {
        MesasVista mv = new MesasVista();
        new MesasControlador(mv);
        mv.setLocationRelativeTo(this);
        mv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mv.setVisible(true);
    }

    private void abrirPedidosVista() {
        PedidosVista pv = new PedidosVista();
        pv.setLocationRelativeTo(this);
        pv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pv.setVisible(true);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new MenuOpciones().setVisible(true));
    }
}
