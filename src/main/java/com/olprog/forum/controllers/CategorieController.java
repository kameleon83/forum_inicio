package com.olprog.forum.controllers;

import com.olprog.forum.dao.CategorieDAO;
import com.olprog.forum.entities.CategorieEntity;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/categories")
public class CategorieController extends HttpServlet {
    private static final String VUES = "/views/categorie/";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            actionGetCheck(req, resp);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public void lireToutesLescategories(HttpServletRequest req,HttpServletResponse resp, String maVue)  {
        req.setAttribute("categories", new CategorieDAO().read());
        maVue = VUES + "read.jsp";
        envoiALaVue(req, resp, maVue);
    }

    public void nouvelleCategorie(HttpServletRequest req,HttpServletResponse resp){
        req.setAttribute("categories", new CategorieDAO().read());
        envoiALaVue(req, resp, VUES + "getForm.jsp");
    }

    public void envoiALaVue(HttpServletRequest req,HttpServletResponse resp, String maVue){
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(maVue);
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    public void actionGetCheck(HttpServletRequest req,HttpServletResponse resp){
        String maVue = VUES + "index.jsp";
        String action = req.getParameter("action");
        if (action.equals("read")) {
            lireToutesLescategories(req,resp, maVue);
        }else if(action.equals("new")){
            nouvelleCategorie(req, resp);
        }
    }

}











//                categorieDAO = new CategorieDAO();
//                CategorieEntity categorieEntity = new CategorieEntity();
//                categorieEntity.setNom("Test2");
//                categorieEntity.setDateUpdate(new Date());
//                categorieEntity.setDateCreation(new Date());
//                categorieDAO.createOrUpdate(categorieEntity);


