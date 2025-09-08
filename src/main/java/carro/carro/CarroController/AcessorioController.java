package carro.carro.CarroController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import carro.carro.CarroEntity.Acessorio;
import carro.carro.CarroEntity.Carro;
import carro.carro.CarroService.AcessorioService;

@RestController
@RequestMapping("/API/Acessorio")
@CrossOrigin("*")
public class AcessorioController {
	
	@Autowired
	private AcessorioService AcessorioService;
   
	 @PostMapping("/save")
	 public ResponseEntity<String> save(@RequestBody Acessorio acessorio) {
		try {
		String nome = this.AcessorioService.save(acessorio);
		return new  ResponseEntity<>(nome, HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			
			// TODO: handle exception
		}
	}
	 @PutMapping("/update/{id}")
	public 	ResponseEntity<String> update(@RequestBody Acessorio acessorio, @PathVariable long id) {
			try {
			String nome= this.AcessorioService.update(acessorio, id);
			return new  ResponseEntity<>(nome, HttpStatus.OK);
			}catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
				
				// TODO: handle exception
			}
		}
	 
	 @DeleteMapping("/delete/{id}")
	public	ResponseEntity<String> delete(@PathVariable long id) {
			try {
			String nome= this.AcessorioService.delete(id);
			return new  ResponseEntity<>(nome, HttpStatus.OK);
			}catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
				
				// TODO: handle exception
			}
		}
	 @GetMapping("/findAll")
	public ResponseEntity<List<Acessorio>> findAll(){
		 try { 
		 List<Acessorio> lista=this.AcessorioService.findAll();
		 return new ResponseEntity<>(lista, HttpStatus.OK);
		 }catch (Exception e) {
	   e.printStackTrace()	;
	   return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);// TODO: handle exception
		}
		 

	 }     
	 @GetMapping("/findById/{id}")
	public ResponseEntity<Acessorio> findById(@PathVariable long id){
		 try {
		
		Acessorio acessorio = this.AcessorioService.findById(id);
		 return new ResponseEntity<>(acessorio, HttpStatus.OK);
		 }catch (Exception e) {
	   e.printStackTrace()	;
	   return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);// TODO: handle exception
		}
		 
	 }
	 
	
	

}
