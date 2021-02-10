package project1;

import java.io.ByteArrayInputStream;

import java.util.Base64;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Test {
    public Test() {
        super();
    }
    public static void main(String[] args) throws Exception {
        String s = "<root>\n" + 
        "			<ns1v2:Attachments>\n" + 
        "				<ns1v2:EmbeddedDataObject id=\"cid:UCMFA00135568\" fileName=\"626311.jpg\" fileType=\"image/jpeg\">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</ns1v2:EmbeddedDataObject>\n" + 
        "				<ns1v2:EmbeddedDataObject id=\"cid:UCMFA00135583\" fileName=\"SampleMessage.txt\" fileType=\"text/plain\">aGVsbG8gd29ybGQ=</ns1v2:EmbeddedDataObject>\n" + 
        "			</ns1v2:Attachments>\n" + 
        "			</root>";
        DocumentBuilderFactory factory =DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        // This tag throws parsing exception while generating soap envelope over this payload
        //We donot have to validate the xml. So it is okay to remove the tag
        //removeTag(inputStr, "!DOCTYPE");
        Document doc = builder.parse(new ByteArrayInputStream(s.getBytes("UTF-8")));                                          
        Element ele=doc.getDocumentElement();
        
        ele.normalize();
        Element atchElement = (Element)ele.getChildNodes().item(1);
        NodeList atchNl = atchElement.getChildNodes();
        System.out.println("elemts by tag name:"+atchNl.getLength());
            //MessageAttachment [] mAtchArr = new MessageAttachment[atchNl.getLength()];
        for(int i=0;i<atchNl.getLength();i++){
            if(atchNl.item(i) instanceof Element ){
            //MessageAttachment mAtch = new MessageAttachment();
            Element embeddedAtch = (Element)atchNl.item(i);
            System.out.println("printing attachment....");
            System.out.println(Base64.getDecoder().decode(atchNl.item(i).getNodeValue().getBytes("UTF-8")));
           
            }
        }
    }
}

