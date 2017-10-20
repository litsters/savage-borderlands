package server;

import com.google.gson.JsonParseException;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import command.*;
import database.serialization.Serializer;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;

public class CommandHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        InputStreamReader reader = new InputStreamReader(httpExchange.getRequestBody());
        CommandResult commandResult;
        try{
            CommandData commandData = (CommandData)Serializer.get().deserialize(reader, CommandData.class);
            Command command = ServerCommandFactory.get().generateCommand(commandData);
            commandResult = command.execute();
        }catch(NoSuchCommandException | JsonParseException | MissingFieldException e){
            commandResult = new CommandResult();
            commandResult.addValue("error", e);
        }catch(Exception e){
            e.printStackTrace();
            commandResult = new CommandResult();
            commandResult.addValue("error", e);
        }

        //0 means something is coming back
        httpExchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpExchange.getResponseBody());
        Serializer.get().serialize(commandResult, outputStreamWriter);
        outputStreamWriter.close();
    }
}
