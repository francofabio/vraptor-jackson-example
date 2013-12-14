package binartecnologia.labs.vratorjacksontest.controller;

import static br.com.caelum.vraptor.view.Results.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
@Path("/contatos/")
public class ContatoController {

	private final static List<Map<String, Object>> contatos;
	
	private final Result result;
	
	static {
		contatos = new ArrayList<>();
		for (int i=1; i <= 10; i++) {
			Map<String, Object> contato = new HashMap<String, Object>();
			contato.put("id", new Integer(i));
			contato.put("nome", "Contato " + i);
			contato.put("email", "email" + i + "@email.com");
			contatos.add(contato);
		}
	}
	
	public ContatoController(Result result) {
		this.result = result;
	}
	
	private List<Map<String, Object>> getContatos() {
		return contatos;
	}
	
	private Map<String, Object> getContato(Integer id) {
		for (Map<String, Object> contato : contatos) {
			if (id.equals(contato.get("id"))) {
				return contato;
			}
		}
		return null;
	}
	
	@Get("/")
	public void contatos() {
		this.result.use(json()).withoutRoot().from(getContatos()).serialize();
	}
	
	@Get("/{id}")
	public void contatoPorId(Integer id) {
		Map<String, Object> contato = getContato(id);
		if (contato == null) {
			result.use(http()).setStatusCode(HttpServletResponse.SC_NOT_FOUND);
		} else {
			this.result.use(json()).withoutRoot().from(contato).serialize();
		}
	}
	
}
