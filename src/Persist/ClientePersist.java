package Persist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Cliente;
import bancoDados.AcessoBDMysql;

public class ClientePersist {
    public Connection AcessoBD;
    PreparedStatement stmt;
    ResultSet rs;
    public ClientePersist(){
        this.AcessoBD = new AcessoBDMysql().getConnection();
    }
    
    
	public String inserir(Cliente cliente) {
        String cmdSql = "INSERT INTO cliente (cpf,nome,email)"
                + " VALUES (?,?,?,?) ";
        String retorno="";
        try{
            stmt = AcessoBD.prepareStatement(cmdSql,Statement.RETURN_GENERATED_KEYS);
            
            stmt.setString(1, cliente.getNome());
            stmt.setString(3, cliente.getCpf());
            stmt.setString(4, cliente.getEmail());
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
	public List<Cliente> listar() {
		ArrayList<Cliente> clientes = new ArrayList<>();
		String sql ="select * from cliente";
		try {
			stmt = AcessoBD.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Cliente c = new Cliente();
				c.setId(rs.getInt("id"));
				c.setCpf(rs.getString("cpf"));
				c.setEmail(rs.getString("email"));
				c.setNome(rs.getString("nome"));
				clientes.add(c);
				
			}
		} catch (Exception ex) {
			  throw new RuntimeException(ex);
		}
		return clientes;
	}
    public int Atualizar (Cliente cliente){
        String cmdSql = "UPDATE cliente SET "
                + "cpf = ?, email = ?,nome = ?"
                + " WHERE id = ?";
        try{
            stmt = AcessoBD.prepareStatement(cmdSql);
            
            stmt.setString(1, cliente.getCpf());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getNome());
            stmt.executeUpdate();
            return cliente.getId();
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }
    }
    public void Excluir(int idCliente){
        String sql = " DELETE FROM cliente WHERE id = "+idCliente;
        
        try{
            stmt = AcessoBD.prepareStatement(sql);
            stmt.execute();
            stmt.close();
        }catch(SQLException ex){
            
            throw new RuntimeException(ex);
        }
    }


}
