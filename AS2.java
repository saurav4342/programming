package project1;

import oracle.xdo.delivery.DeliveryException;
import oracle.xdo.delivery.DeliveryManager;
import oracle.xdo.delivery.DeliveryPropertyDefinitions;
import oracle.xdo.delivery.DeliveryRequest;
import oracle.xdo.delivery.DeliveryResponse;
import oracle.xdo.delivery.InvalidFactoryException;
import oracle.xdo.delivery.UndefinedRequestTypeException;

public class AS2 {
    public static void main(String[] args) throws InvalidFactoryException, UndefinedRequestTypeException,
                                                  DeliveryException {
        DeliveryManager dm = new DeliveryManager();
          // create a delivery request
          DeliveryRequest req = dm.createRequest(DeliveryManager.TYPE_AS2);
        
          // set AS2 message properties 
          req.addProperty(DeliveryPropertyDefinitions.AS2_FROM, "john");
          req.addProperty(DeliveryPropertyDefinitions.AS2_TO, "doe");
          req.addProperty(DeliveryPropertyDefinitions.AS2_SUBJECT, "My EDI Message");
          req.addProperty(DeliveryPropertyDefinitions.AS2_CONTENT_TYPE, "applications/EDIFACT");
        
          // set HTTP properties
          req.addProperty(DeliveryPropertyDefinitions.AS2_HTTP_HOST, "den00sjq.us.oracle.com");
          req.addProperty(DeliveryPropertyDefinitions.AS2_HTTP_PORT, "10080");
          req.addProperty(DeliveryPropertyDefinitions.AS2_HTTP_REMOTE_DIRECTORY, "abcd");
          req.addProperty(DeliveryPropertyDefinitions.AS2_HTTP_REMOTE_FILENAME, "as2123.txt");
          
          req.addProperty(DeliveryPropertyDefinitions.AS2_MESSAGE_ENCRYPTION, "true");
          req.addProperty(DeliveryPropertyDefinitions.AS2_COMPRESSED, "true");


          req.addProperty(DeliveryPropertyDefinitions.AS2_MESSAGE_SIGNATURE, "true");
          req.addProperty(DeliveryPropertyDefinitions.AS2_SENDER_PKCS12_FILE, "C:\\osnwork\\as2-jars\\as2_certs.p12");
          req.addProperty(DeliveryPropertyDefinitions.AS2_SENDER_PKCS12_PASSWORD, "testas2");

         req.addProperty(DeliveryPropertyDefinitions.AS2_HTTP_ENCTYPE, "AS2_HTTP_ENCTYPE_SSL");
         req.addProperty(DeliveryPropertyDefinitions.AS2_DISPOSITION_NOTIFICATION_TO, "/my/receipt/dir");
         req.addProperty(DeliveryPropertyDefinitions.AS2_REQUIRE_RECEIPT, "true");
         req.addProperty(DeliveryPropertyDefinitions.AS2_DISPOSITION_NOTIFICATION_OPTIONS, "signed-receipt-protocol=optional, pkcs7-signature; signed-receipt-micalg=optional, SHA256");
          // set the document
          req.setDocument("C:\\temp\\test.txt");
          // submit the request
          DeliveryResponse res = req.submit();
          // close the request
          req.close();
    }
}
