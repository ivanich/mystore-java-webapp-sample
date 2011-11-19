
package com.koliamorev;

import javax.servlet.http.*;
import org.apache.struts.action.*;

import java.util.List;
import java.util.ArrayList;
import java.sql.*;
import javax.sql.DataSource;

import com.koliamorev.Item;

public class ListItemsAction extends Action {
    private List items;
    private Connection connection;

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        try {
            DataSource dataSource = getDataSource(request);
            connection = dataSource.getConnection();
            populate();
        } catch (Exception e) {
        }

        request.getSession().setAttribute("goods", items);
        
        return mapping.findForward("success");
    }

    void populate() throws SQLException {
        Statement s = connection.createStatement(); 
        String sql = "SELECT id, name, price, quantity FROM items"; 
        ResultSet rs = s.executeQuery(sql); 
        items = new ArrayList();
        while (rs.next()) {
            Item item = new Item();
            item.setId(rs.getInt(1));
            item.setName(rs.getString(2));
            item.setPrice(rs.getFloat(3));
            item.setQuantity(rs.getInt(4));
            items.add(item);
        } 
        rs.close(); 
        s.close(); 
    }
}

