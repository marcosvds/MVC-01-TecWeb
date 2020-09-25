package br.insper.edu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO {
	
	private Connection connection = null;
	
	public DAO () throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost/aulajsp", "root", "295166");
	}
	
	public List<Pessoa> getLista() throws SQLException {
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Pessoa");
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
		Pessoa pessoa = new Pessoa();
			pessoa.setId(rs.getInt("id"));
			pessoa.setNome(rs.getString("nome"));
			pessoa.setIdade(rs.getInt("idade"));
			pessoas.add(pessoa);
		}
		
		rs.close();
		stmt.close();
		
		return pessoas;
	}
	
	public void adiciona(Pessoa pessoa) throws SQLException {
		
		String sql = "INSERT INTO Pessoa" + "(nome,idade) values(?,?)";
		
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1,pessoa.getNome());
		stmt.setInt(2,pessoa.getIdade());
		stmt.execute();
		stmt.close();
	}
	
	public void close() throws SQLException {
		connection.close();
	}
	
}
