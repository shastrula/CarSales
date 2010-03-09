/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.app.cars.controller;

import com.app.cars.beans.Car;
import com.app.cars.svc.InventorySvc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import org.apache.log4j.Logger;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/** 
 *
 * @author shastrula
 */
public class JSonSearchController extends SimpleFormController {
private InventorySvc inventorySvc;
private static Logger logger = Logger.getLogger(JSonSearchController.class);

    public void setInventorySvc(InventorySvc inventorySvc) {
        this.inventorySvc = inventorySvc;
    }
    public JSonSearchController() {
        //Initialize controller properties here or 
        //in the Web Application Context

        //setCommandClass(MyCommand.class);
        //setCommandName("MyCommandName");
        //setSuccessView("successView");
        //setFormView("formView");
    }
    
    @Override
    protected void doSubmitAction(Object command) throws Exception {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {
        return new Object();
    }

    //Use onSubmit instead of doSubmitAction 
    //when you need access to the Request, Response, or BindException objects
    
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

    @Override
    protected ModelAndView showForm(HttpServletRequest request, HttpServletResponse response, BindException errors, Map controlModel) throws Exception {

        String carModel = request.getParameter("model");
        logger.info("model="+carModel);
        response.getWriter().print(JSONArray.fromObject(inventorySvc.searchCarModels(carModel)));
        response.getWriter().flush();

        return null;
    }
    

}