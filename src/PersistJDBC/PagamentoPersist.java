package PersistJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Curso;
import Model.Pagamento;
import Model.Usuario;
import bancoDados.AcessoBDMysql;

public class PagamentoPersist {
	  public Connection AcessoBD;
	    PreparedStatement stmt;
	    ResultSet rs;
	    public PagamentoPersist(){
	        this.AcessoBD = new AcessoBDMysql().getConnection();
	    }

		public String inserir(Pagamento pagamento) {
	        String cmdSql = "INSERT INTO pagamento (cpf,curso,dtaInscricao)"
	                + " VALUES (?,?,?) ";
	        String retorno="";
	        try{
	            stmt = AcessoBD.prepareStatement(cmdSql,Statement.RETURN_GENERATED_KEYS);
	            
	            stmt.setString(3, pagamento.getCpf());
	            stmt.setString(4, pagamento.getCurso());
	            stmt.setString(5, pagamento.getDtaInscricao());
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

		public List<Pagamento> listar() {
			ArrayList<Pagamento> pagamentos = new ArrayList<>();
			String sql ="select * from usuario";
			try {
				stmt = AcessoBD.prepareStatement(sql);
				rs = stmt.executeQuery();
				while (rs.next()) {
					Pagamento p = new Pagamento();
					p.setId(rs.getInt("id"));
					p.setCpf(rs.getString("cpf"));
					p.setCurso(rs.getString("cuso"));
					p.setDtaInscricao(rs.getString("dtaIncricao"));
					pagamentos.add(p);
					
				}
			} catch (Exception ex) {
				  throw new RuntimeException(ex);
			}
			return pagamentos;
		}
	    public int Atualizar (Pagamento pagamento){
	        String cmdSql = "UPDATE pagamento SET "
	                + "cpf = ?, curso = ?,dtaIncricao = ?"
	                + " WHERE id = ?";
	        try{
	            stmt = AcessoBD.prepareStatement(cmdSql);
	            
	            stmt.setString(1, pagamento.getCpf());
	            stmt.setString(2, pagamento.getCurso());
	            stmt.setString(3, pagamento.getDtaInscricao());
	            stmt.executeUpdate();
	            return pagamento.getId();
	        }catch(SQLException ex){
	            throw new RuntimeException(ex);
	        }
	    }
	    public void Excluir(int idPagamento){
	        String sql = " DELETE FROM pagamento WHERE id = "+idPagamento;
	        
	        try{
	            stmt = AcessoBD.prepareStatement(sql);
	            stmt.execute();
	            stmt.close();
	        }catch(SQLException ex){
	            
	            throw new RuntimeException(ex);
	        }
	    }
	    
}
