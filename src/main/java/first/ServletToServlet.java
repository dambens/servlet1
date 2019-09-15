package first;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;
import java.util.logging.Logger;

@WebServlet(name = "getServlet", urlPatterns = {"/servletToServlet", "/servletCommunication"})
public class ServletToServlet extends HttpServlet {
    final Logger logger = Logger.getLogger(ServletToServlet.class.getSimpleName());
    final String SERVER_ADDRESS = "http://localhost:8080/servlet1/randomJson";
    private static final String PARAMETER = "giveRandomNumber";
    private static final String EXPECTED_VALUE = "true";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        String giveRandomNumber = request.getParameter(PARAMETER);

        if (EXPECTED_VALUE.equals(giveRandomNumber)) {
            writer.println("<h1>" + getRandomNumber() + "</h1>");
        } else {
            writer.println("<h2>DONE!</h2>");
        }

    }

    private String getRandomNumber() throws IOException {
        URL url = new URL(SERVER_ADDRESS);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        connection.connect();
        logger.info("Response code: " + connection.getResponseCode());
        String line = new BufferedReader(new InputStreamReader(connection.getInputStream())).readLine();
        return line;
    }
}

