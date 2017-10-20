package server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import database.fileStructure.PathMaster;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PageHandler implements HttpHandler {
    private static final String DEFAULT_PAGE = "index.html";
    private static final String LOC_404 = "404.html";

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        URI uri = exchange.getRequestURI();
        String pathString = uri.getPath();

        if(pathString.matches("/")){
            pathString = DEFAULT_PAGE;
        }

        int responseCode = 0;
        int bodyIsEmptyCode = 0;

        Path path = Paths.get(PathMaster.getHtmlRoot() + pathString);
        byte[] result = new byte[0];

        try{
            result = Files.readAllBytes(path);
            responseCode = HttpURLConnection.HTTP_OK;
            bodyIsEmptyCode = 0;
        }catch(IOException e){
            try {
                path = Paths.get(PathMaster.getHtmlRoot() + LOC_404);
                result = Files.readAllBytes(path);
                bodyIsEmptyCode = 0;
            }catch(IOException error404){
                bodyIsEmptyCode = -1;
                responseCode = HttpURLConnection.HTTP_NOT_FOUND;
            }
        }

        exchange.sendResponseHeaders(responseCode, bodyIsEmptyCode);

        OutputStream os = exchange.getResponseBody();
        os.write(result);
        os.close();
    }
}
