package PersistJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Model.Curso;
import bancoDados.AcessoBDMysql;

public class CursoPersist {
    public Connection AcessoBD;
    PreparedStatement stmt;
    ResultSet rs;
    public CursoPersist(){
        this.AcessoBD = new AcessoBDMysql().getConnection();
    }
    
    
	public String inserir(Curso curso) {
        String cmdSql = "INSERT INTO curso (curso,nome,valor,site)"
                + " VALUES (?,?,?,?) ";
        String retorno="";
        try{
            stmt = AcessoBD.prepareStatement(cmdSql,Statement.RETURN_GENERATED_KEYS);
            
            stmt.setString(1, curso.getNome());
            stmt.setString(2, curso.getSite());
            stmt.setString(3, curso.getValor());
            stmt.execute();
            final ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()){
               retorno = ""+rs.getInt(1);
            }
            stmt.close();
            return retorno;
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }
	}
	public List<Curso> listar() {
		ArrayList<Curso> cursos = new ArrayList<>();
		String sql ="select * from cliente";
		try {
			stmt = AcessoBD.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Curso c = new Curso();
				c.setId(rs.getInt("id"));
				c.setNome(rs.getString("nome"));
				c.setValor(rs.getString("valor"));
				c.setSite(rs.getString("site"));

				cursos.add(c);
				
			}
		} catch (Exception ex) {
			  throw new RuntimeException(ex);
		}
		return cursos;
	}
    public int Atualizar (Curso	 curso){
        String cmdSql = "UPDATE cliente SET "
                + "cpf = ?, email = ?,nome = ?"
                + " WHERE id = ?";
        try{
            stmt = AcessoBD.prepareStatement(cmdSql);
            
            stmt.setString(1, curso.getNome());
            stmt.setString(2, curso.getValor());
            stmt.setString(3, curso.getSite());
            stmt.executeUpdate();
            return curso.getId();
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }
    }
    public void Excluir(int idCurso){
        String sql = " DELETE FROM cliente WHERE id = "+idCurso;
        
        try{
            stmt = AcessoBD.prepareStatement(sql);
            stmt.execute();
            stmt.close();
        }catch(SQLException ex){
            
            throw new RuntimeException(ex);
        }
    }
}
