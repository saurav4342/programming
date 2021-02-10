package project1;
import com.jcraft.jsch.*;

import java.io.File;
import java.io.FileInputStream;

public class SFTP {
    public static void main(String [] args) throws JSchException {
      SFTP s = new SFTP();
      s.send("C:\\osnwork\\svn\\SharedLibraries\\xdo-core.jar");
    }
    public void send (String fileName) {
        String SFTPHOST = "rws3260575.us.oracle.com";
        int SFTPPORT = 22;
        String SFTPUSER = "oracle";
        String SFTPPASS = "osn61new";
        String SFTPWORKINGDIR = "/u01/oracle/Documents";

        Session session = null;
        Channel channel = null;
        ChannelSftp channelSftp = null;
        System.out.println("preparing the host information for sftp.");

        try {
            JSch jsch = new JSch();
            session = jsch.getSession(SFTPUSER, SFTPHOST, SFTPPORT);
            session.setPassword(SFTPPASS);
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.connect();
            System.out.println("Host connected.");
            channel = session.openChannel("sftp");
            channel.connect();
            System.out.println("sftp channel opened and connected.");
            channelSftp = (ChannelSftp) channel;
            channelSftp.cd(SFTPWORKINGDIR);
            File f = new File(fileName);
            channelSftp.put(new FileInputStream(f), f.getName());
           System.out.println("File transfered successfully to host.");
        } catch (Exception ex) {
            System.out.println("Exception found while tranfer the response.");
        } finally {
            channelSftp.exit();
            System.out.println("sftp Channel exited.");
            channel.disconnect();
            System.out.println("Channel disconnected.");
            session.disconnect();
            System.out.println("Host Session disconnected.");
        }
    }   
}

