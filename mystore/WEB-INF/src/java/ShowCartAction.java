
package com.koliamorev;

import javax.servlet.http.*;
import org.apache.struts.action.*;

import java.util.List;
import java.util.ArrayList;

public class ShowCartAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession();
       
        List cart = (List)session.getAttribute("cart");
        
        if (cart == null) {
            cart = new ArrayList();
            session.setAttribute("cart", cart);
        }

        request.setAttribute("cart", cart);
        
        return mapping.findForward("success");
    }
}

