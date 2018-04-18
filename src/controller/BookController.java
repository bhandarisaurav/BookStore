package controller;

import dbUtils.DBConnection;
import domain.Book;
import service.BookService;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


@WebServlet(name = "BookController", urlPatterns = "/book")
public class BookController extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        String action = request.getParameter("action");
        System.out.println("action: " + action);
        if (action.equalsIgnoreCase("addNew")) {
            String name = request.getParameter("name");
            String author = request.getParameter("author");
            String category = request.getParameter("category");
            String isbn = request.getParameter("isbn");
            String price = request.getParameter("price");
            String purchased_date = request.getParameter("purchased_date");
            Boolean isSaved = new BookService().saveBook(new Book(name, author, isbn, price, category, purchased_date));
            if (isSaved) {
                System.out.println("saved = ");
                response.sendRedirect("/book");
            }
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        String table_name = "book";
        Connection con = new DBConnection().getConnection();
        String query = "SELECT * FROM " + table_name;

        Book book = new Book();

        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                book.setId(rs.getString("id"));
                book.setName(rs.getString("name"));
                book.setAuthor(rs.getString("author"));
                book.setCategory(rs.getString("category"));
                book.setIsbn(rs.getString("isbn"));
                book.setPrice(rs.getString("price"));
                book.setPurchased_date(rs.getString("purchased_date"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        request.setAttribute("booklist",book);
        RequestDispatcher rd = request.getRequestDispatcher("/booklist.jsp");
        rd.forward(request,response);
    }
}