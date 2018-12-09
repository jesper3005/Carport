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
        
        //The two carport creation site
        commands.put("flatRoof", new FlatRoof());
        commands.put("pointedRoof", new PointedRoof());
        
        //See order and request the order site
        commands.put("orderRequestFlat", new OrderRequestFlatRoof());
        commands.put("orderRequestPointed", new OrderRequestPointedRoof());
        
        //Send order request site
        commands.put("sendOrderFlat", new CreateOrderFlatRoof());
        commands.put("sendOrderPointed", new CreateOrderPointedRoof());
        
        //Admin
        commands.put("Admin", new Admin());
        commands.put("AddProduct", new AddProduct());
        commands.put("UpdateProduct", new UpdateProduct());
        commands.put("SearchResult", new SearchResult());
<<<<<<< HEAD
        commands.put("manageOrders", new manageOrders());
=======
        commands.put("manageOrders", new ManageOrders());
        commands.put("updateOrderStatus", new UpdateOrderStatus());
>>>>>>> aa5b5875f7a1ddb150c28683833cc155773c39c1
        
        //Navigator for hyperlinks
        commands.put("toNavigator", new Navigator());
        
        //Login
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
