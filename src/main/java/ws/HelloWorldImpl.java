package ws;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService(endpointInterface = "ws.HelloWorldIF")
public class HelloWorldImpl implements HelloWorldIF {

    int connectionCounter = 0;

    @Override
    public String sayHello(String name) {
      connectionCounter++;
      System.out.println("\nConnection nr. " + connectionCounter);
      return "Hello " + name;
    }

  public static void main(String[] args) {
    System.out.println("Server is waiting for incoming connections...");
    Endpoint.publish("http://localhost:8888/webservice/helloworld", new HelloWorldImpl());
  }

}
