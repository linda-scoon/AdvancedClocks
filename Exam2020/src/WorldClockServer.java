import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 */

/**
 * @author lns18qlr
 *
 */
public class WorldClockServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int port = 8888;

		try (ServerSocket server = new ServerSocket(port)) {

			while (true) {
				// starting server
				System.out.println("Waiting for connection");
				Socket client = server.accept();
				System.out.println("Connected");

				// sending data to client
				PrintWriter out = new PrintWriter(client.getOutputStream(), true);
				out.println("0 Home - UK");
				out.println("1 France");
				out.println("2 Finland");
				out.println("3 Saudi Arabia");
				out.println("4 Azerbaijan");
				out.println("5 Uzbekistan");
				out.println("10 Australia");
				out.println("11 Micronesia");

				// closing connection
				client.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
