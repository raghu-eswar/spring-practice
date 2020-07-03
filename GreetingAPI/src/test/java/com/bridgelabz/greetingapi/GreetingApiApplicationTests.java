package com.bridgelabz.greetingapi;

import com.sun.tools.javac.util.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.Scanner;

@SpringBootTest
class GreetingApiApplicationTests {

    @Test
    void givenCurlCommandWithUrlEndPointHello_GreetingAPI_shouldReturnHelloWorld() {
        try {
            Process process = Runtime.getRuntime().exec("curl http://localhost:8080/hello/home");
            String result = "";
            Scanner scanner = new Scanner(process.getInputStream());
            scanner.useDelimiter("\r\n");
            while (scanner.hasNext())
                result = result+scanner.next();
            scanner.close();
            Assert.check(result.equals("Hello World!..."));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void givenCurlCommandWithUrlEndPointAsEmpty_GreetingAPI_shouldReturnHelloWorld() {
        try {
            Process process = Runtime.getRuntime().exec("curl http://localhost:8080/hello");
            String result = "";
            Scanner scanner = new Scanner(process.getInputStream());
            scanner.useDelimiter("\r\n");
            while (scanner.hasNext())
                result = result+scanner.next();
            scanner.close();
            Assert.check(result.equals("Hello World!..."));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void givenCurlCommandWithUrlEndPointAsUser_GreetingAPI_shouldGreetUser() {
        try {
            Process process = Runtime.getRuntime().exec("curl http://localhost:8080/hello/user?firstName=RAGHU&lastName");
            String result = "";
            Scanner scanner = new Scanner(process.getInputStream());
            scanner.useDelimiter("\r\n");
            while (scanner.hasNext())
                result = result+scanner.next();
            scanner.close();
            Assert.check(result.equals("Hello RAGHU  ..."));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
