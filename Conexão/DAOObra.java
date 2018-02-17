/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package literaturananquim.conexao;

import literaturananquim.Obra;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;

public class DAOObra {
    private ConexaoBD conexao;
	
	public DAOObra() {
		// cria o objeto para conexão com banco, porém não o inicializa
		// a conexão deve ser aberta e, consequentemente, fechada durante o envio de comandos
		// ao banco
		this.conexao = new ConexaoBD();
	}
	
	public void criarObra(Obra o) {
		// abrindo a conexão com o BD
		conexao.conectar();

		try {
			// usando um PreparedStatement com valores externos como parâmetros (representados pelo '?')
			PreparedStatement pst = conexao.getConexao().prepareStatement("insert into Obras(nome,genero,autor,cod_Obra) values(?,?,?,?)");
			// os métodos set devem ser escolhidos de acordo com os tipos dos atributos da entidade que está
			// sendo acessada. A sequência é determinada por índices, iniciando do valor 1.
                        
			pst.setString(1, o.getNome());
			pst.setString(2, o.getGenero());
                        pst.setString(3, o.getAutor());
                        pst.setInt(4, o.getId());
			// solicitação da execução da query, após seu preparo
			pst.execute();
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			// o banco deve ser desconectado, mesmo quando a exceção é lançada
			conexao.desconectar();
		}
		
	}
	
	public Obra buscarObra(int id) {
		// abrindo a conexão com o BD
		conexao.conectar();
		// busca utilizando o método de consulta do objeto ConexaoBD
		ResultSet resultado = conexao.executarSQL("select * from Obras where cod_Obra = \'" + id + "\'");
		Obra obra = new Obra();
		
		try {
			resultado.next();
			// os métodos get devem ser escolhidos de acordo com os tipos dos atributos da entidade que está
			// sendo acessada
			int idObra = resultado.getInt("cod_Obra");
			String nomeObra = resultado.getString("nome");
			String generoObra = resultado.getString("genero");
                        String autorObra = resultado.getString("autor");
			obra.setId(idObra);
			obra.setNome(nomeObra);
			obra.setGenero(generoObra);
                        obra.setAutor(autorObra);
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			// o banco deve ser desconectado, mesmo quando a exceção é lançada
			conexao.desconectar();
		}
		return obra;
	}
	
	public void excluirObra(int id) {
		// abrindo a conexão com o BD
		conexao.conectar();
		
		try {
			PreparedStatement stm = conexao.getConexao().prepareStatement("delete from Obras where cod_Obra = \'" + id + "\'");
			stm.execute();
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			// o banco deve ser desconectado, mesmo quando a exceção é lançada
			conexao.desconectar();
		}
	}

	public void editarPessoa(int id, String nome, String genero, String autor) {
		// abrindo a conexão com o BD
		conexao.conectar();
		
		try {
			PreparedStatement stm = conexao.getConexao().prepareStatement("update Obras set nome = ?, genero = ? , autor = ? "
					+ "where cod_Obra = \'" + id + "\'");
			stm.setString(1, nome);
			stm.setString(2, genero);
                        stm.setString(2, autor);
			stm.execute();
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			// o banco deve ser desconectado, mesmo quando a exceção é lançada
			conexao.desconectar();
		}
	}
	
	public ArrayList<Obra> verTodos() {
		ArrayList<Obra> Obras = new ArrayList<>();
		
		// abrindo a conexão com o BD
		conexao.conectar();
		ResultSet resultado = conexao.executarSQL("select * from Obras");
		
		try {
			// para iterar sobre os resultados de uma consulta, deve-se utilizar o método next()
			while (resultado.next()) {
				int idObra = resultado.getInt("cod_Obra");
				String nomeObra = resultado.getString("nome");
                                String generoObra = resultado.getString("genero");
				String autorObra = resultado.getString("autor");
				Obras.add(new Obra(idObra,nomeObra, generoObra, autorObra));
			}
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			// o banco deve ser desconectado, mesmo quando a exceção é lançada
			conexao.desconectar();
		}
		return Obras;
	}

}
