package ws;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class HelloWorldClient {

  public static void main(String[] args) throws MalformedURLException {
    // get wsdl definition
    System.out.println("Start client");
    URL wsdlUrl = new URL("http://localhost:8888/webservice/helloworld?wsdl");

    //Call method based on definition
    QName qname = new QName("http://ws/", "HelloWorldImplService");
    Service service = Service.create(wsdlUrl, qname);
    HelloWorldIF helloWorldInterface = service.getPort(HelloWorldIF.class);
    System.out.println("Call WS: " + helloWorldInterface.sayHello("JAX-WS client"));

    // finish
    System.out.println("Stop client");

  }


}
