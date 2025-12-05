package com.example.book;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/api/books")
public class BookServlet extends HttpServlet {

    private final List<Book> books = new ArrayList<>();
    private final Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(gson.toJson(books));
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Book book = gson.fromJson(request.getReader(), Book.class);
        books.add(book);
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(gson.toJson(book));
        out.flush();
    }

    static class Book {
        private String title;
        private String author;

        public String getTitle() { return title; }
        public void setTitle(String title) { this.title = title; }

        public String getAuthor() { return author; }
        public void setAuthor(String author) { this.author = author; }
    }
}