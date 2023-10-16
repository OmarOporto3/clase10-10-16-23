package org.example;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.server.Request;

import java.io.IOException;
import java.time.LocalDate;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Main {
    public static void main(String[] args) {
        Server server = new Server(8080);

        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setDirectoriesListed(true);
        resourceHandler.setWelcomeFiles(new String[]{"index.html"});
        resourceHandler.setResourceBase("./src/main/java/org/example");

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new org.eclipse.jetty.server.Handler[]{resourceHandler, new CustomHandler()});

        server.setHandler(handlers);

        try {
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static class CustomHandler extends AbstractHandler {
        @Override
        public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
                throws IOException, ServletException {

            response.setContentType("text/html;charset=utf-8");

            response.setStatus(HttpServletResponse.SC_OK);

            RegisterFactory factory = new RegisterFactory();
            System.out.println(factory.condorList.get(0).location());

            String variable = factory.condorList.get(5).id();

            //LocalDate variable = factory.condorList.get(9).date();
            String content = "<html><body>";
            content += "<h1>Register of Condors in 2022</h1>";
            content += "<h2>Location of the specimens.</h2>";
            content += "<ul>";
            for (int i = 0; i < 10; i++) {
                content += "<li>id: "+ factory.getCondorIds().get(i)+" Located in"+factory.getCondorLocations().get(i)+" </li>";
            }
            content += "</ul>";
            content += "<h2>Specimens of Condors registered in Colombia in 2022?</h2>";
            content += "<h4>There are "+factory.getCuantityOnCountry("Colombia").size()+" specimens in Colombia</h4>";
            content += "<button onclick='redirigirURLAleatoria()'>Randomize</button>";
            content += "<script>";
            content += "function redirigirURLAleatoria() {";
            content += "   var enlaces = ['saludar1', 'saludar2', 'saludar3'];";
            content += "   var enlaceAleatorio = enlaces[Math.floor(Math.random() * enlaces.length)];";
            content += "   window.location.href = '/' + enlaceAleatorio;";
            content += "}";
            content += "</script>";
            content += "</body></html>";

            response.getWriter().print(content);

            baseRequest.setHandled(true);
        }
    }
}