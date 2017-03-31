/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emergencyservices;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;

/**
 *
 * @author Methun
 */
public class utility {
    public  String sendPostRequest(String station_type,String district_id) throws IOException {

    HttpConnection httpConn = null;
      String url = "http://bes.elitesbd.com/index.php/j2me_service/get_stations_test/";
    InputStream is = null;
    OutputStream os = null;

    try {
      // Open an HTTP Connection object
      httpConn = (HttpConnection)Connector.open(url);
      // Setup HTTP Request to POST
      httpConn.setRequestMethod(HttpConnection.POST);

      httpConn.setRequestProperty("User-Agent",
        "Profile/MIDP-1.0 Confirguration/CLDC-1.0");
      httpConn.setRequestProperty("Accept_Language","en-US");
      //Content-Type is must to pass parameters in POST Request
      httpConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

      // This function retrieves the information of this connection
      getConnectionInformation(httpConn);


      os = httpConn.openOutputStream();

      String params;
      params = "submit=" + "submit";
       params += "&station_type=" + station_type;
        params += "&district_id=" + district_id;
        System.out.println("params is : "+ params);

      os.write(params.getBytes());

      /**Caution: os.flush() is controversial. It may create unexpected behavior
            on certain mobile devices. Try it out for your mobile device **/

      //os.flush();

      // Read Response from the Server

      StringBuffer sb = new StringBuffer();
      is = httpConn.openDataInputStream();
      int chr;
      while ((chr = is.read()) != -1)
        sb.append((char) chr);

      // Web Server just returns the birthday in mm/dd/yy format.
      //System.out.println(name+"'s Birthday is " + sb.toString());
      return sb.toString();
      } finally {
        if(is!= null)
           is.close();
          if(os != null)
            os.close();
      if(httpConn != null)
            httpConn.close();
    }
    

    }
    void getConnectionInformation(HttpConnection hc) {

    System.out.println("Request Method for this connection is " + hc.getRequestMethod());
    System.out.println("URL in this connection is " + hc.getURL());
    System.out.println("Protocol for this connection is " + hc.getProtocol()); // It better be HTTP:)
    System.out.println("This object is connected to " + hc.getHost() + " host");
    System.out.println("HTTP Port in use is " + hc.getPort());
    System.out.println("Query parameter in this request are  " + hc.getQuery());

    }
    
}
