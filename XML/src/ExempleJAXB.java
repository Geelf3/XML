import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class ExempleJAXB {

	private static final String NOM_FITXER = "exemple.xml";
	private static final String NOM_FITXER2 = "exemple2.xml";
	private static final String NOM_FITXER3 = "exemple3.xml";
		
	
	public static void main(String[] args) {
		Empleat currito = new Empleat(133, "home", 40, "Xavi", "Big Boss", "P@ssW0rd");
		Empleat currito2 = new Empleat();
		Empleat currito3 = new Empleat(135, "home", 32, "Chema", "Delegat", "P@ssW0rd");
		Empleat currito4 = new Empleat(137, "dona", 23, "Marta", "Dessigner", "P@ssW0rd");
		Empleat currito5 = new Empleat(139, "dona", 23, "karla", "Mindundi", "P@ssW0rd");
		Empleat currito6 = new Empleat(141, "dona", 34, "Juanola", "Submindundi", "P@ssW0rd");
		Staff curritos = new Staff();
		try {
//			objecteAXml(currito);
//			currito2 = XmlAObjecte();
//			System.out.println(currito2);
//			//ArrayList<Empleat> myStaff = new ArrayList<Empleat>();
//			Staff myStaff = new Staff();
//			myStaff.add(currito);
//			myStaff.add(currito3);
//			myStaff.add(currito4);
//			myStaff.add(currito5);
//			myStaff.add(currito6);
//	
//			
//			marshalLlista(myStaff, new File("llistaEmpleats.xml"));
			
			curritos = unmarshallLlista(new File("llistaEmpleats2.xml"));
			
			for (Empleat x : curritos.getCurrantes()) {
				System.out.println(x);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void marshalLlista(Staff myStaff, File fitxer) {
		try {
			JAXBContext contexte = JAXBContext.newInstance(Staff.class);
			BufferedWriter writer = null;
			writer = new BufferedWriter(new FileWriter(fitxer));
			Marshaller m = contexte.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(myStaff, writer);
			writer.close();
		} catch (JAXBException | IOException e) {
			e.printStackTrace();
		}
		
	}

	private static void objecteAXml(Empleat currante) {
		// creem el context --> classe que fa la traduccio a XML
		try {
			JAXBContext context = JAXBContext.newInstance(Empleat.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(currante, new File(NOM_FITXER));
			m.marshal(currante, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	private static Empleat XmlAObjecte() {
		try {
			JAXBContext contexte = JAXBContext.newInstance(Empleat.class);
			Unmarshaller um = contexte.createUnmarshaller();
			Empleat currante = (Empleat)um.unmarshal(new File(NOM_FITXER2));
			return currante;
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static Staff unmarshallLlista(File entryFile) {
		try {
			BufferedReader reader = null;
			reader = new BufferedReader(new FileReader(entryFile));
			JAXBContext contexte = JAXBContext.newInstance(Staff.class);
			Unmarshaller um = contexte.createUnmarshaller();
			Staff currantes = (Staff)um.unmarshal(reader);
			reader.close();
			return currantes;
		} catch (JAXBException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
