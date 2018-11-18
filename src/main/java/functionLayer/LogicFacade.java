/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionLayer;

import dbAccess.ProductMapper;
import java.util.List;

/**
 *
 * @author oerte
 */
public class LogicFacade {

    public static ProductMapper pm = new ProductMapper();

    public static List<Produkt> getAllProduktFromDatabase() {
        List<Produkt> produktList = pm.products();
        return produktList;
    }

}
