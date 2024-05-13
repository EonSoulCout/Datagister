package View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

import Controller.LogicEvent;

public class View_Register extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public JTextField txt_Names;
    public JTextField txt_Cedula;
    public ButtonGroup Gender;
    public JSpinner spn_Age;
    public JRadioButton rbtn_GenderM;
    public JRadioButton rbtn_GenderF;
    public JCheckBox chckbx_Soccer;
    public JCheckBox chckbx_Games;
    public JCheckBox chckbx_Gym;
    public JCheckBox chckbx_Read;
    public JCheckBox chckbx_ListenM;
    public JCheckBox chckbx_Swim;
    public JPanel pnl_Register;
    public JButton btn_Photo;
    public JComboBox comboBox;
    public JButton btn_Save;
    private JLabel lbl_Photo;
    private JPanel pn_photo;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    View_Register frame = new View_Register();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public View_Register() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 510, 366);
        setResizable(false);
        setTitle("Registro");
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        pnl_Register = new JPanel();
        pnl_Register.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Regristrar Usuario", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        pnl_Register.setBackground(new Color(139, 177, 199));
        pnl_Register.setBounds(0, 0, 498, 331);
        contentPane.add(pnl_Register);
        pnl_Register.setLayout(null);

        txt_Names = new JTextField();
        txt_Names.setFont(new Font("Century", Font.PLAIN, 15));
        txt_Names.setBounds(90, 50, 151, 20);
        pnl_Register.add(txt_Names);
        txt_Names.setColumns(10);

        JLabel lbl_Name = new JLabel("Nombres:");
        lbl_Name.setBounds(32, 53, 63, 14);
        pnl_Register.add(lbl_Name);

        JLabel lbl_CI = new JLabel("C I:");
        lbl_CI.setBounds(32, 84, 48, 14);
        pnl_Register.add(lbl_CI);

        txt_Cedula = new JTextField();
        txt_Cedula.setFont(new Font("Century", Font.PLAIN, 15));
        txt_Cedula.setColumns(10);
        txt_Cedula.setBounds(90, 81, 151, 20);
        pnl_Register.add(txt_Cedula);

        spn_Age = new JSpinner();
        spn_Age.setFont(new Font("Century", Font.PLAIN, 13));
        spn_Age.setBounds(90, 163, 40, 20);
        spn_Age.setModel(new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1)); // Establecer el modelo del Spinner
        pnl_Register.add(spn_Age);

        JLabel lbl_Age = new JLabel("Edad:");
        lbl_Age.setBounds(32, 167, 48, 14);
        pnl_Register.add(lbl_Age);

        JLabel lbl_Gender = new JLabel("Genero:");
        lbl_Gender.setBounds(32, 121, 48, 14);
        pnl_Register.add(lbl_Gender);

        pn_photo = new JPanel();
        pn_photo.setBounds(366, 38, 110, 130);
        pnl_Register.add(pn_photo);
        pn_photo.setLayout(null);

        lbl_Photo = new JLabel("");
        lbl_Photo.setIcon(new ImageIcon(View_Register.class.getResource("/View/Resources/Pics/usuario.png")));
        lbl_Photo.setBounds(0, 0, 110, 130);
        pn_photo.add(lbl_Photo);

        rbtn_GenderM = new JRadioButton("Masculino");
        rbtn_GenderM.setBackground(new Color(139, 177, 199));
        rbtn_GenderM.setFont(new Font("Century", Font.PLAIN, 12));
        rbtn_GenderM.setBounds(90, 117, 96, 23);
        pnl_Register.add(rbtn_GenderM);

        rbtn_GenderF = new JRadioButton("Femenino");
        rbtn_GenderF.setBackground(new Color(139, 177, 199));
        rbtn_GenderF.setFont(new Font("Century", Font.PLAIN, 12));
        rbtn_GenderF.setBounds(194, 116, 96, 23);
        pnl_Register.add(rbtn_GenderF);

        Gender = new ButtonGroup();
        Gender.add(rbtn_GenderM);
        Gender.add(rbtn_GenderF);

        JLabel lbl_Hobbie = new JLabel("Hobbies:");
        lbl_Hobbie.setBounds(32, 211, 48, 14);
        pnl_Register.add(lbl_Hobbie);

        chckbx_Soccer = new JCheckBox("Futbol");
        chckbx_Soccer.setBackground(new Color(139, 177, 199));
        chckbx_Soccer.setBounds(90, 207, 99, 23);
        pnl_Register.add(chckbx_Soccer);

        chckbx_Gym = new JCheckBox("Gimnasio");
        chckbx_Gym.setBackground(new Color(139, 177, 199));
        chckbx_Gym.setBounds(90, 233, 99, 23);
        pnl_Register.add(chckbx_Gym);

        chckbx_Games = new JCheckBox("Video Juegos");
        chckbx_Games.setBackground(new Color(139, 177, 199));
        chckbx_Games.setBounds(191, 207, 110, 23);
        pnl_Register.add(chckbx_Games);

        chckbx_Read = new JCheckBox("Leer");
        chckbx_Read.setBackground(new Color(139, 177, 199));
        chckbx_Read.setBounds(191, 233, 99, 23);
        pnl_Register.add(chckbx_Read);

        chckbx_ListenM = new JCheckBox("Escuchar Musica");
        chckbx_ListenM.setBackground(new Color(139, 177, 199));
        chckbx_ListenM.setBounds(304, 233, 142, 23);
        pnl_Register.add(chckbx_ListenM);

        chckbx_Swim = new JCheckBox("Natación");
        chckbx_Swim.setBackground(new Color(139, 177, 199));
        chckbx_Swim.setBounds(304, 207, 99, 23);
        pnl_Register.add(chckbx_Swim);


        JLabel lbl_Estu = new JLabel("Estudios:");
        lbl_Estu.setBounds(32, 273, 63, 14);
        pnl_Register.add(lbl_Estu);

        comboBox = new JComboBox();
        comboBox.setBounds(90, 269, 200, 22);
        pnl_Register.add(comboBox);

        btn_Save = new JButton("");
        btn_Save.setForeground(new Color(0, 0, 0));
        btn_Save.setToolTipText("Guardar formulario");
        btn_Save.setIcon(new ImageIcon(View_Register.class.getResource("/View/Resources/Pics/save.png")));
        btn_Save.setBounds(425, 270, 50, 50);
        pnl_Register.add(btn_Save);

        btn_Photo = new JButton("Cargar");
        btn_Photo.setFont(new Font("Century", Font.PLAIN, 9));
        btn_Photo.setBounds(386, 177, 78, 23);
        pnl_Register.add(btn_Photo);

        //Intaciar al controlador
        LogicEvent le = new LogicEvent(this);

        btn_Photo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                le.actionPerformed(e); // Llamar al ActionListener del botón "Cargar foto" en LogicEvent
            }
        });

        btn_Save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                le.actionPerformed(e); // Llamar al ActionListener del botón "Guardar" en LogicEvent
            }
        });
    }

    public void setPhotoLocation(String imagePath) {
        // Mostrar la imagen seleccionada en el JLabel
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(lbl_Photo.getWidth(), lbl_Photo.getHeight(), Image.SCALE_DEFAULT));
        lbl_Photo.setIcon(imageIcon);
    }

    public String[] getSelectedHobbies() {
        List<String> hobbiesList = new ArrayList<>();
        if (chckbx_Soccer.isSelected()) {
            hobbiesList.add("Futbol");
        }
        if (chckbx_Games.isSelected()) {
            hobbiesList.add("Video Juegos");
        }
        if (chckbx_Gym.isSelected()) {
            hobbiesList.add("Gimnasio");
        }
        if (chckbx_Read.isSelected()) {
            hobbiesList.add("Leer");
        }
        if (chckbx_ListenM.isSelected()) {
            hobbiesList.add("Escuchar Musica");
        }
        if (chckbx_Swim.isSelected()) {
            hobbiesList.add("Natación");
        }

        return hobbiesList.toArray(new String[0]);
    }

    public void clearFields() {
        // Limpiar los campos de texto
        txt_Names.setText("");
        txt_Cedula.setText("");
        spn_Age.setValue(0);

        // Limpiar los botones de radio
        Gender.clearSelection();
        rbtn_GenderM.setSelected(true); // Establecer el valor predeterminado

        // Limpiar las casillas de verificación
        chckbx_Soccer.setSelected(false);
        chckbx_Games.setSelected(false);
        chckbx_Gym.setSelected(false);
        chckbx_Read.setSelected(false);
        chckbx_ListenM.setSelected(false);
        chckbx_Swim.setSelected(false);

        // Restablecer la selección predeterminada en el ComboBox
        comboBox.setSelectedIndex(0);
    }

    public void resetFieldBackground() {
        // Restaurar el color de fondo de los campos de texto
        txt_Names.setBackground(Color.WHITE);
        txt_Cedula.setBackground(Color.WHITE);
        spn_Age.setBackground(Color.WHITE);
    }
}
