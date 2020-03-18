package io.tony.leetcode;


import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;

public class SocketTest {
  public static void main(String[] args) throws IOException {

    /*Socket socket = new Socket();
    socket.setSoTimeout(5000);
    socket.connect(new InetSocketAddress("139.59.61.1", 53658), 5000);
    System.out.println(socket.isConnected());

    socket.close();*/
    URL url = new URL("https://www.liesauer.net/yogurt/subscribe?ACCESS_TOKEN=DAYxR3mMaZAsaqUb");
    URLConnection urlConnection = url.openConnection();
    urlConnection.connect();
    InputStream inputStream = urlConnection.getInputStream();

  }
}
