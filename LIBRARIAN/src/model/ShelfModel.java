
package model;

import java.sql.PreparedStatement;
import java.sql.Statement;

public class ShelfModel {
    private Statement stmnt = null;
    public boolean insertintoShelf(String shelfName, String shelfDes) throws Exception{
        DatabaseAccess.connectToMySql();
        String sql = "insert into shelf(shelfName,shelfDes) values(?,?)";
        PreparedStatement s = DatabaseAccess.connection.prepareStatement(sql);
        s.setString(1, shelfName);
        s.setString(2, shelfDes);
        
        int i = s.executeUpdate();
        
        if (i == 1){
            return true;
        }
        else{
            return false;
        }
    }
}
