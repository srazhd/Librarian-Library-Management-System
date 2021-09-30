/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author sunam
 */
public class BookViewModel {
    private Statement stmnt = null;

   
    public ResultSet getBookInfo(String s) throws Exception{
        DatabaseAccess.connectToMySql();
        stmnt = DatabaseAccess.connection.createStatement();
        String sql = "select * from book where bookID ="+ s;
        return stmnt.executeQuery(sql);
    }
}
