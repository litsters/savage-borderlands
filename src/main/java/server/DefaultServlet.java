package server;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DefaultServlet extends HttpServlet{
    private final String WEB_ROOT = "server/site/";
    private final String DEFAULT_PAGE = "index.html";
    private final String PAGE_404 = "404.html";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathString = request.getRequestURI();
        if(pathString.matches("/")){
            pathString = DEFAULT_PAGE;
        }

        int responseCode;

        byte[] result = new byte[0];

        try{
            result = Files.readAllBytes(Paths.get(WEB_ROOT + pathString));
            responseCode = HttpServletResponse.SC_OK;
        }catch(IOException e){
            try {
                result = Files.readAllBytes(Paths.get(WEB_ROOT + PAGE_404));
                responseCode = HttpServletResponse.SC_OK;
            }catch(IOException error404){
                responseCode = HttpServletResponse.SC_NOT_FOUND;
            }
        }

        response.setStatus(responseCode);
        OutputStream os = response.getOutputStream();
        os.write(result);
        os.close();
    }
}
