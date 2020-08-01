package ru.javaops.masterjava;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import ru.javaops.masterjava.xml.schema.Payload;
import ru.javaops.masterjava.xml.util.XPathProcessor;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXB;
import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

class PersonalNamespaceContext implements NamespaceContext {

    public String getNamespaceURI(String prefix) {
        if (prefix == null) throw new NullPointerException("Null prefix");
        else if ("pre".equals(prefix)) return "http://javaops.ru";
        else if ("xml".equals(prefix)) return XMLConstants.XML_NS_URI;
        return XMLConstants.NULL_NS_URI;
    }

    // This method isn't necessary for XPath processing.
    public String getPrefix(String uri) {
        throw new UnsupportedOperationException();
    }

    // This method isn't necessary for XPath processing either.
    public Iterator getPrefixes(String uri) {
        throw new UnsupportedOperationException();
    }

}

public class MainXml {

     private String xmlFilePath = "src/test/resources/payload.xml";
     private File xmlFile = new File(xmlFilePath);

     Payload payload = JAXB.unmarshal(xmlFile, Payload.class);

     void printXmlFile() {
         System.out.println(payload);
     }

     private void getDocument(String projectName){
         DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
         factory.setNamespaceAware(true); // never forget this!
         DocumentBuilder builder = null;
         Document doc = null;
         try {
             builder = factory.newDocumentBuilder();
             doc = builder.parse(xmlFilePath);
             final NodeList userNodes = doc.getElementsByTagName("User");
             for (int i = 0; i < userNodes.getLength(); i++) {
                 final NodeList childNodes = userNodes.item(i).getChildNodes();
                 for (int j = 0; j < childNodes.getLength(); j++) {
                     System.out.println(childNodes.item(j).getTextContent());
                 }
             }
         } catch (ParserConfigurationException | SAXException | IOException e) {
             e.printStackTrace();
         }
         XPathFactory xPathFactory = XPathFactory.newInstance();
         XPath xpath = xPathFactory.newXPath();
         XPathExpression projectNameExpr;
         XPathExpression groupNameExpr = null;
         XPathExpression projectDescExpr;
         XPathExpression userCountExpr;
         XPathExpression expr;
         try {
             userCountExpr = xpath.compile("count(//User)");
             groupNameExpr = xpath.compile("/*[name()='Payload']/*[name()='Users']/*[name()='User']/*[name()='group']/text()");
             projectNameExpr = xpath.compile("/*[name()='Payload']/*[name()='Users']/*[name()='User']/*[name()='group']/text()");
//             projectNameExpr = xpath.compile("/Payload/Groups/Group/@Project");
//             expr = xpath.compile("//book[author='Neal Stephenson']/title/text()");
             xpath.setNamespaceContext(new PersonalNamespaceContext());
             expr = xpath.compile("//pre:book[pre:author='Neal Stephenson']/pre:title/text()");

             Object projectNameExprResult = projectNameExpr.evaluate(doc, XPathConstants.NODESET);
             NodeList projectNameNodes = (NodeList) projectNameExprResult;

             final Object userCountObject = userCountExpr.evaluate(doc, XPathConstants.NUMBER);
             Double groupCount = (Double) userCountObject;
             for (int i = 0; i < projectNameNodes.getLength(); i++) {
                 System.out.println(projectNameNodes.item(i).getNodeValue());
             }
             System.out.println("User's group count: " + groupCount);
         } catch (XPathExpressionException e) {
             e.printStackTrace();
         }
     }

    public static void main(String[] args) {
        MainXml mainXml = new MainXml();
        mainXml.printXmlFile();
        mainXml.getDocument("MasterJava");

    }
}
