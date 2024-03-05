package br.edu.fatecitaquera.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.fatecitaquera.dao.StudentDAO;
import br.edu.fatecitaquera.model.Student;

@WebServlet("/ServletStudent")
public class ServletStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// metodo para conversao de String para data
	private Date strToDate(String data) throws Exception {
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Date dataF = formato.parse(data);
		return dataF;
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Student student = new Student();
		StudentDAO dao;
		String cmd = request.getParameter("cmd");
		try {
			if (cmd.equals("include") || cmd.equals("atualizar")) {
				student.setRa(Integer.parseInt(request.getParameter("txtRa")));
				student.setNome(request.getParameter("txtNome"));
				student.setEmail(request.getParameter("txtEmail"));
				student.setEndereco(request.getParameter("txtEndereco"));
				student.setPeriodo(request.getParameter("cmbPeriodo"));
				student.setDataNascimento(strToDate(request.getParameter("txtData")));
			} else {
				student.setRa(Integer.parseInt(request.getParameter("txtRa")));
			}
		} catch (Exception e) {
			// System.out.println("Erro na data");
			System.out.println(e.getMessage());
		}
		try {
			dao = new StudentDAO();
			// Dispatcher - direciona para uma nova página
			// RequestDispatcher rd = null;
			if (cmd.equalsIgnoreCase("include")) {
				dao.salvar(student);
			}
			// executa a ação de direcionar para a página JSP
			// rd.forward(request, response);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
}
