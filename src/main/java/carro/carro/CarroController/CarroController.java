package carro.carro.CarroController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import carro.carro.CarroEntity.Carro;
import carro.carro.CarroService.CarroService;


@RestController
@RequestMapping("/API/Carro")
@CrossOrigin("*")
public class CarroController {
   
	@Autowired
	private  CarroService carroService;
	
	 @PostMapping("/save")
	 public ResponseEntity<String> save(@RequestBody Carro carro) {
		try {
		String nome= this.carroService.save(carro);
		return new  ResponseEntity<>(nome, HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			
			// TODO: handle exception
		}
	}
	 @PutMapping("/update/{id}")
	public 	ResponseEntity<String> update(@RequestBody Carro carro, @PathVariable long id) {
			try {
			String nome= this.carroService.update(carro, id);
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
			String nome= this.carroService.delete(id);
			return new  ResponseEntity<>(nome, HttpStatus.OK);
			}catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
				
				// TODO: handle exception
			}
		}
	 @GetMapping("/findAll")
	public ResponseEntity<List<Carro>> findAll(){
		 try {
		 List<Carro> lista=this.carroService.findAll();
		 return new ResponseEntity<>(lista, HttpStatus.OK);
		 }catch (Exception e) {
	   e.printStackTrace()	;
	   return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);// TODO: handle exception
		}
		 

	 }
	 @GetMapping("/findById/{id}")
	public ResponseEntity<Carro> findById(@PathVariable long id){
		 try {
		
		Carro carro = this.carroService.findById(id);
		 return new ResponseEntity<>(carro, HttpStatus.OK);
		 }catch (Exception e) {
	   e.printStackTrace()	;
	   return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);// TODO: handle exception
		}
		 
	 }
}
