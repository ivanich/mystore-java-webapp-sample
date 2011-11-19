
package com.koliamorev;

import javax.servlet.http.*;
import org.apache.struts.action.*;

import java.util.List;
import java.util.ArrayList;

public class OrderItemAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        OrderForm orderForm = (OrderForm) form;
        HttpSession session = request.getSession();
        List cart = (List)session.getAttribute("cart");
        
        if (cart == null) {
            cart = new ArrayList();
        }

        Item item = new Item();
        item.setId(Integer.decode(orderForm.getId()).intValue());
        item.setQuantity(Integer.decode(orderForm.getQuantity()).intValue());
        
        cart.add(item);
        session.setAttribute("cart", cart);
        
        return mapping.findForward("success");
    }
}

