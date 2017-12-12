package resource;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Produces;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dao.LojaDao;
import model.Loja;



@RestController
public class LojaResource {
		
	
	@RequestMapping(value = "/lojas", method = RequestMethod.GET)//, produces = MediaType.APPLICATION_JSON_VALUE)
	public List buscaLojas() throws ClassNotFoundException, SQLException{
		LojaDao dao = new LojaDao();
		dao.conexaoBDSqlServer();
		List<Loja> Lojas = dao.buscaLoja();
		dao.close();
		
		return Lojas;
	}
}
