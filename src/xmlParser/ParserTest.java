package xmlParser;

import java.io.IOException;
import java.util.List;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import pojos.Asignatura;

public class ParserTest {

	public static void main(String[] args) throws SAXException, IOException {
		XmlHandler handler = new XmlHandler();
		XMLReader p = XMLReaderFactory.createXMLReader();
		p.setContentHandler(handler);
		p.parse("datos.xml");
		List<Asignatura> lsita = handler.GetListaAsignaturas();
		for (Asignatura asignatura : lsita) {
			System.out.println(asignatura);
		}
	}

}
