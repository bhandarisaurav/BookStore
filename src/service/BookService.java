package service;

import dbUtils.DBConnection;
import domain.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookService {

    String table_name = "book";
    Connection con = new DBConnection().getConnection();
    Book book = new Book();


    public boolean saveBook(Book book) {

        String query = "INSERT INTO" + table_name + "(name, author, category,isbn,price,purchased_date) VALUES(?,?,?,?,?,?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, book.getName());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setString(3, book.getCategory());
            preparedStatement.setString(4, book.getIsbn());
            preparedStatement.setString(5, book.getPrice());
            preparedStatement.setString(6, book.getPurchased_date());

            return preparedStatement.executeUpdate() != 0;


        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("query = " + query);
        return false;
    }
}