package PlaywrightSession;
public class Playwright_Architecture {
    /*
    Selenium Architecture:
    **********************
        Selenium works on the HTTP connection protocol. It means after you trigger the test,
        the complete Selenium code written by us (Client) will be converted to JSON format.
        Generated JSON is sent to the browser driver (Server) through HTTP protocol.

      Selenium Client Library(Java, Python, C#)
            <-----------> {JSON} Wire Protocol over HTTP
                             <----------->Browser Driver(Chrome, Firefox, IE, Safari) HTTP Over HTTP Server
                                        <----------->Browser(Chrome, Firefox, IE, Safari) HTTP Over HTTP Server

     Playwright Architecture:
     **********************
        Playwright works on Web socket connection protocol, it means once you will trigger the test,
        the code will be converted into JSON format and will be sent to the server using Web socket protocol.

                WebSockets                  Browsers
        TEST <--------------> Playwright <--------------> Chrome, Firefox, IE, Safari
               All Commands

The difference between Web socket connection Protocol and HTTP connection protocol:
********************************************
                                WebSocket Connection
                                =====================
Client ------------------------Request----------------------------------> Server/Cloud
Client <------------------------HandShake-------------------------------- Server/Cloud
Client <------------------------Web Socket------------------------------> Server/Cloud

                                        VS
                                   HTTP Connection
                                =====================
Client ------------------------Request----------------------------------> Server/Cloud
Client <------------------------Response--------------------------------- Server/Cloud
Client -------------------------Connection Terminated-------------------- Server/Cloud

*******************************************************************************************
Selenium sends each command as a separate HTTP request and receives JSON responses.
So, every action, such as opening the browser, clicking an element, or sending keys in a text box,
is sent as a separate HTTP request. Additionally, after completion of every request,
the connection between server and client will be terminated, which needed to be re-established for
the next request.

     */
}
