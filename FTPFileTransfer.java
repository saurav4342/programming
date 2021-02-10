
import oracle.xdo.delivery.DeliveryResponse;
import oracle.xdo.delivery.DeliveryManager;
import oracle.xdo.delivery.DeliveryPropertyDefinitions;
import oracle.xdo.delivery.DeliveryRequest;

public class FTPFileTransfer {

	public FTPFileTransfer() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// create delivery manager instance
		try{
	     DeliveryManager dm = new DeliveryManager();
	     // create a delivery request
	     DeliveryRequest req = dm.createRequest(DeliveryManager.TYPE_SFTP);
	 
	     // set hostname of the FTP server
	     req.addProperty(DeliveryPropertyDefinitions.SFTP_HOST, "rws3260575.us.oracle.com");
	     // set port# of the FTP server
	   //  req.addProperty(DeliveryPropertyDefinitions.FTP_PORT, "21");
	     // set username and password to access WebDAV server
	     req.addProperty(DeliveryPropertyDefinitions.SFTP_USERNAME, "oracle");
	     req.addProperty(DeliveryPropertyDefinitions.SFTP_PASSWORD, "osn61new");
	     // set the remote directory that you want to send your document to
	   req.addProperty(DeliveryPropertyDefinitions.SFTP_REMOTE_DIRECTORY, "/u01/oracle/Documents");
	     // set the remote file name 
	     req.addProperty(DeliveryPropertyDefinitions.SFTP_REMOTE_FILENAME, "invoice.xml");
	     // set the document
	     req.setDocument("C:/Users/saurnaya.ORADEV/Documents/test.xyz");
	 
	     // submit the request
	     req.submit();
	     // close the request
	     req.close();
		}catch(Exception e)
		 {
			 System.out.println("Test exception");
			 e.printStackTrace();
}


	}

}
