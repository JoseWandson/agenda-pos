/**
 * 
 */
package br.com.service;

import org.springframework.stereotype.Service;

/**
 * @author carlosbarbosagomesfilho
 *
 */
@Service
public class LoginService {

	public boolean verificaLogin(String email, String senha) {
		boolean logou = false;

		if (email.equals("cbgomes@gmail.com") && senha.equals("123")) {
			logou = true;
		}
		return logou;
	}

}
