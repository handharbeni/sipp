/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.meda.apit.database.connection;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author PT. Data Bumi Indonesia
 */
public class ToolsKonfigurasi {
    //private static final String THEFILE = System.getProperty("user.home")+"\\SIPP.conf";
    private static final String THEFILE = "SIPP.conf";
    
    public static boolean cekFileKonf() {
        File f = new File(THEFILE);
        return  f.exists();
    }
    
    public static void buatFileKonf() {
        try {
            System.out.println(THEFILE);
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder(); 
           
           // root elements
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("konfigurasi");
            doc.appendChild(rootElement);

            rootElement.appendChild(buatChild(doc, "DbApp", "-","-","-"));
            rootElement.appendChild(buatChild(doc, "DbServ", "-","-","-"));
            rootElement.appendChild(buatChild(doc, "DbSismiop", "jdbc:oracle:thin:@localhost:1521:dbsis","orauser","orapwd"));
            
        // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(THEFILE));
            transformer.transform(source, result);
           
        } catch (Exception pce) {
		pce.printStackTrace();
	}
    }
    
    private static Element buatChild(Document doc, String nmChild, String kon, String user, String pwd) {
        Element a = doc.createElement(nmChild);
        
        Element b = doc.createElement("ConnStr");
        b.appendChild(doc.createTextNode(kon));
        a.appendChild(b);
        Element c = doc.createElement("User");
        c.appendChild(doc.createTextNode(user));
        a.appendChild(c);
        Element d = doc.createElement("Pwd");
        d.appendChild(doc.createTextNode(pwd));
        a.appendChild(d);
        
        return a;
    }
    
    public static Konfigurasi bacaKonf() {
        Konfigurasi konfigurasi = new Konfigurasi();

        try {
            File f = new File(THEFILE);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(f);
            
            doc.getDocumentElement().normalize();
            
            prosesBacaKonf("DbApp", doc, konfigurasi);
            prosesBacaKonf("DbServ", doc, konfigurasi);
            prosesBacaKonf("DbSismiop", doc, konfigurasi);
            
        } catch (Exception e) {}
        
        return konfigurasi;
    }
    
    private static void prosesBacaKonf(String nmEl, Document doc, Konfigurasi konf) {
        NodeList nList = doc.getElementsByTagName(nmEl);
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                switch (nmEl) {
                    case "DbApp":
                        konf.setDbAppConnStr(eElement.getElementsByTagName("ConnStr").item(0).getTextContent());
                        konf.setDbAppUser(eElement.getElementsByTagName("User").item(0).getTextContent());
                        konf.setDbAppPwd(eElement.getElementsByTagName("Pwd").item(0).getTextContent());
                        break;
                    case "DbServ":
                        konf.setDbServConnStr(eElement.getElementsByTagName("ConnStr").item(0).getTextContent());
                        konf.setDbServUser(eElement.getElementsByTagName("User").item(0).getTextContent());
                        konf.setDbServPwd(eElement.getElementsByTagName("Pwd").item(0).getTextContent());
                        break;
                    case "DbSismiop":
                        konf.setDbSisConnStr(eElement.getElementsByTagName("ConnStr").item(0).getTextContent());
                        konf.setDbSisUser(eElement.getElementsByTagName("User").item(0).getTextContent());
                        konf.setDbSisPwd(eElement.getElementsByTagName("Pwd").item(0).getTextContent());
                        break;
                }
            }
        }
    }
}
