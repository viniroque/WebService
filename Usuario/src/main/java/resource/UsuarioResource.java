package resource;

import java.sql.SQLException;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dao.ConexaoDB;
import model.Usuario;

@RestController
public class UsuarioResource {
		
	
	@RequestMapping(value = "/cadastro", method = RequestMethod.POST)
	public void cadastrar(@RequestBody Usuario usuario)
			throws SQLException{
		try {
			
			//Gson gson = new Gson();
			//Usuario usuario = gson.fromJson(json, Usuario.class);
			//@FormParam("nome") String nome, @FormParam("celular") String celular, @FormParam("email") String email, @FormParam("senha") String senha
			//usuario = new Usuario(usuario.getNome(), usuario.getEmail(), usuario.getCelular(), usuario.getSenha());
			
		ConexaoDB conexao =  new ConexaoDB();
		conexao.getConnection();
		conexao.cadastrarUsuario(usuario.getNome(), usuario.getCelular(), usuario.getEmail(), usuario.getSenha());
		conexao.close();
	}catch(Exception e) {
		e.printStackTrace();
		}
	}
}