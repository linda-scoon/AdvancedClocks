import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

/**
 * @author lns18qlr Clock Client
 */
public class ClockClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ArrayList<Clock> clocks = new ArrayList<>();
		int port = 8888;
		String host = "localhost";

		try (Socket client = new Socket(host, port)) {

			// getting streams
			BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			PrintWriter out = new PrintWriter(client.getOutputStream());

			String inputText;
			while ((inputText = in.readLine()) != null) {

				// breaking down text
				String location = inputText.substring(2);
				int timeDiff = Integer.parseInt(inputText.substring(0, 1));

				// adding new clock to array
				clocks.add(new Clock(timeDiff, location));

			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// printing time
		for (Clock clock : clocks) {
			System.out.println(clock.toString());
		}
	}

}
