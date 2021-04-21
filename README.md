# SOAP DEMO 🧼
A demo project to demonstrate how to connect to SOAP endpoint via Spring

## Implementation Note 🚧
1. Define schema for both Request and Response from SOAP endpoint a few thing to understand
    - We need to define BOTH REQUEST AND RESPONSE in **soap:Body**
    - XmlRootElement often be the className of the object
    - Still not understand about **XmlAccessorType** yet
    - **ObjectFactory** this tell the marshaller where is the object to serialize/deserialize from xml 
    - **package-info.java** We need this to define the namespace for the XML Schema
   
2. Create a Configuration class to define Bean for both marshaller and soapConnector
    - Marshaller is a serializer for POJO -> XML one thing to note that we need to tell which ContextPath we store the XML Schema that it can lookup
    - SOAPConnector act as HTTP Client for making request to SOAP endpoint we need to tell it base path and which marshaller for serializing
   
3. Create a SOAPConnector which extend WebServiceGatewaySupport this one act as generic SOAP client for any endpoint to SOAP
    - This also serialize the request/response object. You can see it from **marshalSendAndReceive**
   
4. On the demoController usage we using the soapConnector to performing request to SOAP endpoint
    - The response need to be cast since the interface on SOAPConnector is generic to object
   
5. A little note on build.gradle
    - We need to add org.springframework.boot:spring-boot-starter-web-services for WebServiceGatewaySupport
    - For Marshaller we need to use jaxb-api and jaxb-runtime install in as in compile time only

### Reference 📚
* [NumberToWords API](https://documenter.getpostman.com/view/8854915/Szf26WHn?version=latest)
* [javax.xml.bind.JAXBException Implementation of JAXB-API has not been found on module path or classpath [duplicate]](https://stackoverflow.com/questions/51916221/javax-xml-bind-jaxbexception-implementation-of-jaxb-api-has-not-been-found-on-mo)
* [Spring Boot SOAP Client – WebServiceTemplate Example](https://howtodoinjava.com/spring-boot/spring-soap-client-webservicetemplate/) <-- Primary inspiration