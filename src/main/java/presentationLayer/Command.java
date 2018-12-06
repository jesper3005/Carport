/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationLayer;

import exceptions.FogException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author oerte
 */
abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put("FlatRoof", new FlatRoof());
        commands.put("PointedRoof", new PointedRoof());
        commands.put("OrderRequest", new OrderRequest());
        commands.put("Admin", new Admin());
        commands.put("AddProduct", new AddProduct());
        commands.put("UpdateProduct", new UpdateProduct());
        commands.put("SearchResult", new SearchResult());
        commands.put("sendOrder", new CreateOrderFlatRoof());
        commands.put("toLogin", new toLogin());
        commands.put("toRegi", new toRegi());
        commands.put(("login"), new Login());

    }

    static Command from(HttpServletRequest request) {
        String commandName = request.getParameter("command");
        if (commands == null) {
            initCommands();
        }
        return commands.getOrDefault(commandName, new UnknownCommand());
    }

    abstract String execute(HttpServletRequest request, HttpServletResponse response)
            throws FogException;

}
