package Model;

import java.io.File;
import java.io.IOException;

import LibreriaV2.Archivos;

public class PersonDAO implements Settings{

	private Archivos f;

	public PersonDAO() {
		f= new Archivos(mainPath);
		f.create(0);

	}

	public boolean writerPerson(Person p) throws IOException {
	    // Se crea un archivo con el nombre basado en el nombre de la persona y la fecha actual
	    String fileName = p.getName() + "_" + System.currentTimeMillis() + ".txt";
	    File personFile = new File(mainPath, fileName);
	    f.setFile(personFile);
	    
	    // Concatena la ubicación de la foto con la información de la persona
	    String personInfo = p.personalInfo() + ";" + p.getPhotoPath() + "\n";
	    
	    // Guarda la información en el archivo
	    return f.writerFile(personInfo, false);
	}
}


