package carro.carro.auth;

//import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.AuthenticationException;

@RestController
@RequestMapping("/api/login")
@CrossOrigin("http://localhost:58680/")    
public class LoginController {

	@Autowired
	private LoginService loginService; 

	@PostMapping
	public ResponseEntity<String> logar(@RequestBody Login login) {
     try {
		String token = loginService.logar(login);
		return new ResponseEntity<>(token, HttpStatus.OK);
		  
	}catch (AuthenticationException e) {
		System.out.println("Caiu aqui 1"+e.getMessage());
		 return  new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
	}
     catch(Exception e){
    	
    	 System.out.println("ErroOO "+ e.getMessage());
    	 e.printStackTrace();
    	 return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
     }
    	 
     }
		// TODO: handle exception
	

}
