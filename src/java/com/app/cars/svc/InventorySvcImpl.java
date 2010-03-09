/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.app.cars.svc;

import com.app.cars.beans.Car;
import com.app.cars.beans.CarModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author shastrula
 */
public class InventorySvcImpl implements InventorySvc{
    private List<CarModel> carModel;
    private List<Car> cars;
    private Logger logger = Logger.getLogger(InventorySvcImpl.class);

    public void setCarModel(List<CarModel> carModel) {
        this.carModel = carModel;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<CarModel> showAvailableCarModels() {
        return carModel;
    }

    public List<Car> showCars() {
       return cars;
    }

    public List<Car> searchCarModels(String model) {
        Iterator it = cars.iterator();

        logger.info("Cars->"+cars);
        Car car = null;

        List<Car> carList = new ArrayList<Car>();

        while(it.hasNext()){
            car = (Car) it.next();
            logger.info(car);
            if(car.getModel().getModel().equalsIgnoreCase(model)){
                carList.add(car);
            }
        }
        return carList;
    }


}
