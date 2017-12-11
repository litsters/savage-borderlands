package server;

import org.eclipse.jetty.http.pathmap.ServletPathSpec;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.resource.PathResource;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.eclipse.jetty.websocket.server.WebSocketUpgradeFilter;

import java.io.File;
import java.nio.file.Path;

public class JettyServer {
    private final int MAX_THREADS = 100;
    private final int MIN_THREADS = 10;
    private final int IDLE_TIMEOUT = 120;

    private Server server;

    public void start(int portNumber) throws Exception{
        QueuedThreadPool threadPool = new QueuedThreadPool(MAX_THREADS, MIN_THREADS, IDLE_TIMEOUT);

        server = new Server(threadPool);
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(portNumber);
        server.setConnectors(new Connector[] {connector});

        Path webRootPath = new File("server/site/").toPath().toRealPath();

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        context.setBaseResource(new PathResource(webRootPath));
        context.setWelcomeFiles(new String[] { "index.html" });
        server.setHandler(context);

        // Add the websocket filter
        WebSocketUpgradeFilter wsfilter = WebSocketUpgradeFilter.configureContext(context);
        wsfilter.getFactory().getPolicy().setIdleTimeout(11000);
        wsfilter.addMapping(new ServletPathSpec("/connect"), new ClientSocketCreator());

        // NOTE! If you don't add the DefaultServlet, your
        // resources won't get served!
        ServletHolder holderDefault = new ServletHolder("default", DefaultServlet.class);
        holderDefault.setInitParameter("dirAllowed", "true");
        context.addServlet(holderDefault, "/");

        server.start();
        server.join();

    }

    void stop() throws Exception {
        server.stop();
    }
}
