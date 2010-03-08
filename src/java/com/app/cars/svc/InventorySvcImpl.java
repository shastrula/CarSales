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
public class InventorySvcImpl implements InventorySvc{
    private List<CarModel> carModel;
    private List<Car> cars;

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

}
