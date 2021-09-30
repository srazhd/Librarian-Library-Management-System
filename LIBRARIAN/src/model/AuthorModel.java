
package model;

import java.sql.PreparedStatement;
import java.sql.Statement;

public class AuthorModel {
    private Statement stmnt = null;
    public boolean insertintoAuthor(String authorName, String authorDes) throws Exception{
        DatabaseAccess.connectToMySql();
        String sql = "insert into author(authorName,authorDes) values(?,?)";
        PreparedStatement s = DatabaseAccess.connection.prepareStatement(sql);
        s.setString(1, authorName);
        s.setString(2, authorDes);
        
        int i = s.executeUpdate();
        
        if (i == 1){
            return true;
        }
        else{
            return false;
        }
    }
}
