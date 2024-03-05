package br.edu.fatecitaquera.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.fatecitaquera.model.Student;
import br.edu.fatecitaquera.util.ConnectionFactory;

public class StudentDAO {
	// classes de banco de dados
	private Connection conn; // abre a conexao do banco de dados
	private PreparedStatement ps; // permite que scripts SQL sejam executados a partir do Java
	private ResultSet rs; // representa as tabelas
	// classe JavaBean
	private Student student;

	public StudentDAO() throws Exception {
		// chama a classe ConnectionFactory e estabele uma conexao
		try {
			this.conn = ConnectionFactory.getConnection();
		} catch (Exception e) {
			throw new Exception("erro: \n" + e.getMessage());
		}
	}

	// metodo de salvar
	public void salvar(Student student) throws Exception {
		if (student == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "INSERT INTO student (ra, nome, email, endereco, "
					+ "data_nascimento, periodo) values (?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, student.getRa());
			ps.setString(2, student.getNome());
			ps.setString(3, student.getEmail());
			ps.setString(4, student.getEndereco());
			ps.setDate(5, new java.sql.Date(student.getDataNascimento().getTime()));
			ps.setString(6, student.getPeriodo());
			ps.executeUpdate();
		} catch (SQLException sqle) {
			throw new Exception("Erro ao inserir dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}
	
	// Listar todos os Students
	public List<Student> todosStudents() throws Exception {
		try {
			ps = conn.prepareStatement("SELECT * FROM student");
			rs = ps.executeQuery();
			List<Student> list = new ArrayList<Student>();
			
			while (rs.next()) {
				int ra = rs.getInt("ra");
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				String endereco = rs.getString("endereco");
				Date dataNascimento = rs.getDate("data_nascimento");
				String periodo = rs.getString("periodo");
				list.add(new Student(ra, nome, email, endereco, dataNascimento, periodo));
			}
			return list;
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}

}
