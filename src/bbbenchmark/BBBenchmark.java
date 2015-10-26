/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbbenchmark;

import java.net.URI;
import java.net.URISyntaxException;

public class BBBenchmark {

    public static void main(String[] args) {
        try {
            URI uri = new URI("ws://localhost:1337/?userToken=test");
            //URI uri = new URI("ws://54.68.93.8:1337/?userToken=test");
            for (int i = 0; i < 2000; i++) {
                // open websocket
                final WebsocketClientEndpoint clientEndPoint = new WebsocketClientEndpoint(uri);
                System.out.println(i);
                // add listener
                clientEndPoint.addMessageHandler(new WebsocketClientEndpoint.MessageHandler() {
                    public void handleMessage(String message) {
                        System.out.println(message);
                    }
                });

            // send message to websocket
                //clientEndPoint.sendMessage("{'event':'addChannel','channel':'ok_btccny_ticker'}");
                clientEndPoint.sendMessage("{\"type\":\"service-request\",\"data\":{}}");

            }

            // wait 5 seconds for messages from websocket
            //Thread.sleep(5000);

        } catch (URISyntaxException ex) {
            System.err.println("URISyntaxException exception: " + ex.getMessage());
        }
    }
}
