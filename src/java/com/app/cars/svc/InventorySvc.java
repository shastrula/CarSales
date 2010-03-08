/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.app.cars.svc;

import com.app.cars.beans.Car;
import com.app.cars.beans.CarModel;
import java.util.List;

/**
 *
 * @author shastrula
 */
public interface InventorySvc {
List<CarModel> showAvailableCarModels();
List<Car> showCars();
}
