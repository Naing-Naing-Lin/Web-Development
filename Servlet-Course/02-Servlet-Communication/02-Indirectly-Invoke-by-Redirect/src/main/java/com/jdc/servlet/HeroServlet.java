package com.jdc.servlet;

import java.io.IOException;

import com.jdc.entity.Hero;
import com.jdc.entity.Hero.HeroType;
import com.jdc.service.HeroService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/redirect", "/hero-save", "/hero-list" })
public class HeroServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private HeroService service = new HeroService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		var page = switch (req.getServletPath()) {
		case "/redirect" -> "/hero/hero-form.jsp";
		case "/hero-list" -> {

			var heroList = service.findAll();
			req.setAttribute("heroList", heroList);
			yield "/hero/hero-list.jsp";

			}
		default -> throw new RuntimeException();
		};
		
		getServletContext().getRequestDispatcher(page).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		var name = req.getParameter("name");
		var heroType = req.getParameter("type");
		
		Hero hero = new Hero();
		hero.setName(name);
		hero.setHeroType(HeroType.valueOf(heroType));
		
		var result = service.save(hero);
		
		req.setAttribute("info", result == true ? "Saved Successfully" : "Failed to save");
		
		//getServletContext().getRequestDispatcher("/hero/info.jsp").forward(req, resp);
		
		resp.sendRedirect(req.getContextPath().concat("/hero-list"));
	}
}
