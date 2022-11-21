import br.com.atos.dao.LoginDAO;
import br.com.atos.factory.ConnectionFactory;
import br.com.atos.model.UserLogin;

public class Teste {

	public static void main(String[] args) throws Exception {
		LoginDAO d = new LoginDAO();
		UserLogin login = new UserLogin();
		login.setUserName("Danilo");
		login.setPassword("123");
		d.login(login);
	}

}
