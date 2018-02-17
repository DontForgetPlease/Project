/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package literaturananquim.conexao;

import literaturananquim.Usuario;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;


public class DAOUsuario {
    private ConexaoBD conexao;
	
	public DAOUsuario() {
		this.conexao = new ConexaoBD();
	}
	
	public void criarUsuario(Usuario user) {
		conexao.conectar();

		try {
			PreparedStatement pst = conexao.getConexao().prepareStatement("insert into Usuario(email, senha, nome, media, nVotos) values(?,?,?,?,?)");
			pst.setString(1, user.getEmail());
			pst.setString(2, user.getSenha());
                        pst.setString(3, user.getNome());
                        pst.setFloat(4, user.getMedia());
                        pst.setInt(5, user.getNVotos());
			pst.execute();
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			conexao.desconectar();
		}
		
	}
	public Usuario buscarUsuario(String email) {
		conexao.conectar();
		ResultSet resultado;
        resultado = conexao.executarSQL("select * from Usuario where email = \'" + email + "\'");
		Usuario user = new Usuario();
		
		try {
			resultado.next();
			String emailUser = resultado.getString("email");
			String nomeUser = resultado.getString("nome");
			String senha = resultado.getString("senha");
                        float media = resultado.getFloat("media");
                        int nVotos = resultado.getInt("nVotos");
			user.setEmail(emailUser);
                        user.setNome(nomeUser);
                        user.setSenha(senha);
                        user.setMediaDAO(media);
                        user.setNVotos(nVotos);
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			conexao.desconectar();
		}
		return user;
	}
	
	public void excluirPessoa(int email) {
		conexao.conectar();
		
		try {
			PreparedStatement stm = conexao.getConexao().prepareStatement("delete from Usuario where email = \'" + email + "\'");
			stm.execute();
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			conexao.desconectar();
		}
	}

	public void editarNota(String email, float media, int nVotos) {
		conexao.conectar();
		
		try {
			PreparedStatement stm = conexao.getConexao().prepareStatement("update Usuario set media = ?, nVotos = ? "
					+ "where email = \'" + email + "\'");
			stm.setFloat(1, media);
			stm.setInt(2, nVotos);
			stm.execute();
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			conexao.desconectar();
		}
	}
        
        public boolean isExiste(String email){
            conexao.conectar();
            ResultSet resultado = conexao.executarSQL("select COUNT(email) from Usuario where email = \'" + email + "\'");
            boolean isExist = false;
            try{
                resultado.next();
                int cont = resultado.getInt("count");
                if(cont != 0){
                    isExist = true;
                }
            } catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			conexao.desconectar();
		}
            return isExist;
        }
	
	/*public ArrayList<Usuario> verTodos() {
		ArrayList<Usuario> pessoas = new ArrayList<>();
		
		// abrindo a conexão com o BD
		conexao.conectar();
		ResultSet resultado = conexao.executarSQL("select * from Usuario");
		
		try {
			// para iterar sobre os resultados de uma consulta, deve-se utilizar o método next()
			while (resultado.next()) {
				String email = resultado.getString("email");
				String nomePessoa = resultado.getString("nome");
				int idadePessoa = resultado.getInt("idade");
				pessoas.add(new Pessoa(idPessoa, nomePessoa, idadePessoa));
			}
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			// o banco deve ser desconectado, mesmo quando a exceção é lançada
			conexao.desconectar();
		}
		return pessoas;
	}*/
}
