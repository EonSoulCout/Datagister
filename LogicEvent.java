package Controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import Model.Person;
import Model.PersonDAO;
import View.View_Register;

public class LogicEvent implements ActionListener {

    private View_Register vr;
    private Person p = new Person();
    private PersonDAO pdao = new PersonDAO();
    private String imagePath = null;

    public LogicEvent(View_Register vr) {
        super();
        this.vr = vr;
        this.vr.btn_Photo.addActionListener(this);
        this.vr.btn_Save.addActionListener(this);
        loadStudieslvl();
    }

    private void loadStudieslvl() {
        String[] Studies = { "Primaria", "Secundaria", "Superior", "Posgrado", "Doctorado" };
        for (String st : Studies) {
            vr.comboBox.addItem(st);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vr.btn_Photo) {
            // Desactivar el ActionListener para evitar la activación múltiple
            vr.btn_Photo.removeActionListener(this);

            // Acción para el botón "Cargar foto"
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Imagenes", "jpg", "png", "jpeg");
            fileChooser.setFileFilter(filter);
            int result = fileChooser.showOpenDialog(vr);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                imagePath = selectedFile.getAbsolutePath();
                vr.setPhotoLocation(imagePath); // Mostrar la imagen seleccionada en la vista
            }

            // Volver a activar el ActionListener después de completar la acción
            vr.btn_Photo.addActionListener(this);
        } else if (e.getSource() == vr.btn_Save) {
            // Desactivar el ActionListener para evitar la activación múltiple
            vr.btn_Save.removeActionListener(this);

            // Acción para el botón "Guardar"
            // Verificar si todos los campos están llenos
            if (!validateData()) {
                return; // Salir del método si algún campo está vacío
            }
            if (imagePath != null) {
                try {
                    // Mostrar mensaje de foto cargada con éxito
                    JOptionPane.showMessageDialog(vr, "Foto cargada con éxito");

                    // Continuar con el proceso de guardar
                    p.setName(vr.txt_Names.getText());
                    p.setAge(Integer.parseInt(vr.spn_Age.getValue().toString()));
                    p.setDni(Long.parseLong(vr.txt_Cedula.getText()));

                    if (vr.rbtn_GenderF.isSelected()) {
                        p.setGender("Femenino");
                    } else {
                        p.setGender("Masculino");
                    }

                    p.setLvlestudy(vr.comboBox.getSelectedItem().toString());
                    p.setHobbies(vr.getSelectedHobbies());

                    // Guardar la ubicación de la foto en el objeto Person
                    p.setPhotoPath(imagePath);

                    // Guardar la información llamando al método para guardar la información
                    pdao.writerPerson(p);

                    JOptionPane.showMessageDialog(vr, "Registro exitoso");
                    vr.clearFields();
                    vr.resetFieldBackground();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }

            // Volver a activar el ActionListener después de completar la acción
            vr.btn_Save.addActionListener(this);
        }
    }


    private boolean validateData() {
        boolean estate = true;

        if (Validate.ValidateNames(vr.txt_Names.getText())) {
            vr.txt_Names.setBackground(Color.green);
        } else {
            vr.txt_Names.setBackground(Color.red);
            estate = false;
            JOptionPane.showMessageDialog(vr, "Por favor, complete todos los campos antes de guardar.");
        }

        if (Validate.ValidateDNI(Long.parseLong(vr.txt_Cedula.getText()))) {
            vr.txt_Cedula.setBackground(Color.green);
        } else {
            vr.txt_Cedula.setBackground(Color.red);
            estate = false;
            JOptionPane.showMessageDialog(vr, "Por favor, complete todos los campos antes de guardar.");
        }

        if (Validate.ValidateAge(Integer.parseInt(vr.spn_Age.getValue().toString()))) {
            vr.spn_Age.setBackground(Color.green);
        } else {
            vr.spn_Age.setBackground(Color.red);
            estate = false;
            JOptionPane.showMessageDialog(vr, "Por favor, complete todos los campos antes de guardar.");
        }

        if (imagePath == null) {
            estate = false;
            JOptionPane.showMessageDialog(vr, "Por favor, complete todos los campos antes de guardar.");
        }

        return estate;
    }
}
