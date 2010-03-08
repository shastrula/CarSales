/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.app.cars.controller;

import com.app.cars.beans.SearchCars;
import com.app.cars.svc.InventorySvc;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/** 
 *
 * @author shastrula
 */
public class HomePageController extends SimpleFormController {
private InventorySvc inventorySvc;

    public InventorySvc getInventorySvc() {
        return inventorySvc;
    }

    public void setInventorySvc(InventorySvc inventorySvc) {
        this.inventorySvc = inventorySvc;
    }
    public HomePageController() {
        //Initialize controller properties here or 
        //in the Web Application Context

        //setCommandClass(MyCommand.class);
        //setCommandName("MyCommandName");
        //setSuccessView("successView");
        //setFormView("formView");
    }

    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {
        return new SearchCars();
    }
    
    @Override
    protected void doSubmitAction(Object command) throws Exception {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    protected ModelAndView showForm(HttpServletRequest request, HttpServletResponse response, BindException errors, Map controlModel) throws Exception {
    controlModel = new HashMap();
    controlModel.put("availableCarModels", inventorySvc.showAvailableCarModels());
    controlModel.put("cars", inventorySvc.showCars());
        return super.showForm(request, response, errors, controlModel);
    }

    //Use onSubmit instead of doSubmitAction 
    //when you need access to the Request, Response, or BindException objects
    /*
    @Override
    protected ModelAndView onSubmit(
            HttpServletRequest request, 
            HttpServletResponse response, 
            Object command, 
            BindException errors) throws Exception {
        ModelAndView mv = new ModelAndView(getSuccessView());
        //Do something...
        return mv;
    }
    */



}