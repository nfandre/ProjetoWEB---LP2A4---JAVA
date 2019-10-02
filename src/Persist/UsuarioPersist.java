package Persist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Model.Usuario;
import bancoDados.AcessoBDMysql;;

public class UsuarioPersist{
    public Connection AcessoBD;
    PreparedStatement stmt;
    ResultSet rs;
    public UsuarioPersist(){
        this.AcessoBD = new AcessoBDMysql().getConnection();
    }

	public String inserir(Usuario usuario) {
        String cmdSql = "INSERT INTO usuario (nome,cpf,email,senha)"
                + " VALUES (?,?,?,?) ";
        String retorno="";
        try{
            stmt = AcessoBD.prepareStatement(cmdSql,Statement.RETURN_GENERATED_KEYS);
            
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getCpf());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getSenha());
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

	public List<Usuario> listar() {
		ArrayList<Usuario> usuarios = new ArrayList<>();
		String sql ="select * from usuario";
		try {
			stmt = AcessoBD.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Usuario u = new Usuario();
				u.setId(rs.getInt("id"));
				u.setCpf(rs.getString("cpf"));
				u.setEmail(rs.getString("email"));
				u.setNome(rs.getString("nome"));
				u.setSenha(rs.getString("senha"));
				usuarios.add(u);
				
			}
		} catch (Exception ex) {
			  throw new RuntimeException(ex);
		}
		return usuarios;
	}
    public int Atualizar (Usuario usuario){
        String cmdSql = "UPDATE usuario SET "
                + "nome = ?, cpf = ?, email = ?,senha = ?"
                + " WHERE id = ?";
        try{
            stmt = AcessoBD.prepareStatement(cmdSql);
            
            stmt.setString(1, usuario.getCpf());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getNome());
            stmt.setString(4, usuario.getSenha());
            stmt.executeUpdate();
            return usuario.getId();
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }
    }
    public void Excluir(int idUsuario){
        String sql = " DELETE FROM usuario WHERE id = "+idUsuario;
        
        try{
            stmt = AcessoBD.prepareStatement(sql);
            stmt.execute();
            stmt.close();
        }catch(SQLException ex){
            
            throw new RuntimeException(ex);
        }
    }
    public Usuario VerificarSeUsuarioExiste(Usuario usuario) {
    	Usuario resultado = null;
    	for(Usuario u: listar()) {
    		if(u.equals(usuario)) {
    			resultado = u;
    			break;
    		}
    	}
    	return resultado;
    }
    public boolean verificarSenhaEstaCorreta(Usuario usuario, String senha) {
    	boolean resultado = false;
    	for(Usuario u: listar()) {
    		if(u.equals(usuario)) {
    			if(u.getSenha().trim().equals(senha)==true) {
        			
    				resultado = true;
        			break;
    			}

    		}
    	}
    	return resultado;
    }
    public Usuario verificarEmailExiste(String email) {
    	Usuario u = null;
    	String sql = "SELECT * FROM usuario WHERE email = '"+ email+"'";
    	try {
    		stmt = AcessoBD.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				u = new Usuario();
				u.setId(rs.getInt("id"));
				u.setNome(rs.getString("nome"));
				u.setCpf(rs.getString("cpf"));
				u.setEmail(rs.getString("email"));
				u.setSenha(rs.getString("senha"));
			}
		return u;
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
    }
    
}
