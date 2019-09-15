package first;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet(name = "RandomJson", urlPatterns = {"/getRandomNumber", "/randomJson"})
public class RandomJson extends HttpServlet {

    private static final String PARAMETER = "giveRandomNumber";
    private static final String EXPECTED_VALUE = "true";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("application/json");
        PrintWriter writer = response.getWriter();
        String giveRandomNumber = request.getParameter(PARAMETER);

        if (EXPECTED_VALUE.equals(giveRandomNumber)) {

        } else {
            writer.println("<h2>DONE!</h2>");
        }

        Random random = new Random();
        writer.println(random.nextInt());

    }

}
