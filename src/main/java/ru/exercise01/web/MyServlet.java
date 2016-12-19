package ru.exercise01.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

import  ru.exercise01.util.MakeUrlList;

/**
 * Created by Egor on 18.12.16.
 */
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String readUrl = request.getParameter("UrlValue");
        final MakeUrlList makeUrlList =  new MakeUrlList(readUrl);
        request.setAttribute("listLinks",makeUrlList.getList());
        request.getRequestDispatcher("/downloadUrl.jsp").forward(request, response);

    }
}
