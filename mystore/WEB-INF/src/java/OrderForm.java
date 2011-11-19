
package com.koliamorev;

import org.apache.struts.action.*;
import javax.servlet.http.*;

public class OrderForm extends ActionForm {
    private String id;
    private String quantity;

    public String getId() {
        return id;
    }

    public void setId(String string) {
        id = string;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String string) {
        quantity = string;
    }

    public void reset(ActionMapping mapping, HttpServletRequest request) {
        id = null;
        quantity = null;
    }

    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();

        if (quantity==null || quantity.trim().equals("")) {
            errors.add("quantity", 
                    new ActionError("orderItem.quantity.problem"));
        }
        
        return errors;
    }
}

