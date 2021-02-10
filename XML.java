package project1;

import java.io.ByteArrayInputStream;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import org.xml.sax.SAXException;

public class XML {
    public static void main(String [] args) throws ParserConfigurationException, SAXException, IOException {
   String xml = "<?xml version='1.0' encoding='UTF-8'?><BuyerRegistration> <Company> <Name>ABC Consulting</Name></Company></BuyerRegistration>";
    DocumentBuilderFactory factory =DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document doc = builder.parse(new ByteArrayInputStream(xml.getBytes("UTF-8")));            
    Element ele=doc.getDocumentElement();
    ele.normalize();
    System.out.println(ele.getNodeName());
    Element nl = (Element)ele.getElementsByTagName("Company").item(0);
    System.out.println(nl.getElementsByTagName("Name").item(0).getChildNodes().item(0).getNodeValue());
    }
}
