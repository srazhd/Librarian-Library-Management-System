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
public class HomeModel {
    private Statement stmnt = null;
    public boolean insertintoBook(String bookName, String bookDes, String bookAuthor, String bookShelf) throws Exception{
        DatabaseAccess.connectToMySql();
        String sql = "insert into book(bookName,bookDes, bookAuthor, bookShelf) values(?,?,?,?)";
        PreparedStatement s = DatabaseAccess.connection.prepareStatement(sql);
        s.setString(1, bookName);
        s.setString(2, bookDes);
        s.setString(3, bookAuthor);
        s.setString(4, bookShelf);
        
        int i = s.executeUpdate();
        
        if (i == 1){
            return true;
        }
        else{
            return false;
        }
    }
    public ResultSet getAuthorInfo() throws Exception{
        DatabaseAccess.connectToMySql();
        stmnt = DatabaseAccess.connection.createStatement();
        String sql = "select * from author";
        return stmnt.executeQuery(sql);
    }
    public ResultSet getShelfInfo() throws Exception{
        DatabaseAccess.connectToMySql();
        stmnt = DatabaseAccess.connection.createStatement();
        String sql = "select * from shelf";
        return stmnt.executeQuery(sql);
    }
    public ResultSet getBookInfo() throws Exception{
        DatabaseAccess.connectToMySql();
        stmnt = DatabaseAccess.connection.createStatement();
        String sql = "select * from book";
        return stmnt.executeQuery(sql);
    }
    public ResultSet getBookInfoLike(String s) throws Exception{
        DatabaseAccess.connectToMySql();
        stmnt = DatabaseAccess.connection.createStatement();
        String sql = "select * from book where bookName like '"+s+"%' ";
        return stmnt.executeQuery(sql);
    }
}
