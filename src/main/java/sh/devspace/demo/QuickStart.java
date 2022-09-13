package sh.devspace.demo;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

/**
 * A java simple for DevSpace
 *
 * @author heroyin
 */
public class QuickStart
{
    public static void main( String[] args ) throws IOException
    {
		HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/", new MyHandler());
        server.setExecutor(null); 
        server.start();
	}
	
	static class MyHandler implements HttpHandler {
		
        @Override
        public void handle(HttpExchange t) throws IOException {
            String response = "<html>" +  
              "<head>" +  
              " <title>DevSpace Demo</title>" +
              "	<link rel=\"stylesheet\" href=\"https://devspace.sh/css/quickstart.css\">" +  
              "</head>" +  
              "<body>" +  
              " <section>" +
              "  <div class='container'>" +
              "   <div class='left'>" +
              "     <h1>You deployed this project with<img class='logo' src='https://static.loft.sh/branding/logos/devspace/horizontal/mono/devspace_horizontal_mono.svg' alt='DevSpace' /></h1>" +
              "     <h2>Now it's time to code:</h2>" +
              "     <ol>" +
              "       <ul class='dots'>" +
              "         <li class='red'></li>" +
              "         <li class='yellow'></li>" +
              "         <li class='blue'></li>" +
              "       </ul>" +
              " 			<li>Edit this text in <code>src/main/java/sh/devspace/demo/QuickStart.java</code> and save the file</li>" +
              "	  		<li>Restart the application with <code>./build.sh run</code></li>" +
              "		  	<li>Reload browser to see the changes</li>" +
              "      </ol>" +
              "     </div>" +
              "     <div><img src='https://static.loft.sh/devspace/quickstarts/devspace-astronaut.gif' /></div>" +
              "   </div>" +
              " </section>" +
              "</body>" +  
              "</html>";
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

}
