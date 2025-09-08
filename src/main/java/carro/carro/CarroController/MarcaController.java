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

import carro.carro.CarroEntity.Carro;
import carro.carro.CarroEntity.Marca;
import carro.carro.CarroService.MarcaService;

@RestController
@RequestMapping("/API/Marca")
@CrossOrigin("*")
public class MarcaController {
	
	
	@Autowired
	private MarcaService marcaSerive;
	
	@PostMapping("/save")
	 public ResponseEntity<String> save(@RequestBody Marca marca) {
		try {
		String nome= this.marcaSerive.save(marca);
		return new  ResponseEntity<>(nome, HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			
			// TODO: handle exception
		}
	}
	 @PutMapping("/update/{id}")
	public 	ResponseEntity<String> update(@RequestBody Marca marca, @PathVariable long id) {
			try {
			String nome= this.marcaSerive.update(marca , id);
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
			String nome= this.marcaSerive.delete(id);
			return new  ResponseEntity<>(nome, HttpStatus.OK);
			}catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
				
				// TODO: handle exception
			}
		}
	 @GetMapping("/findAll")
	public ResponseEntity<List<Marca>> findAll(){
		 try {
		 List<Marca> lista = this.marcaSerive.findAll();
		 return new ResponseEntity<>(lista, HttpStatus.OK);
		 }catch (Exception e) {
	      e.printStackTrace();
	   return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);// TODO: handle exception
		}
		 
 
	 }
	 @GetMapping("/findById/{id}")
	public ResponseEntity<Marca> findById(@PathVariable long id){
		 try {
		
		Marca marca= this.marcaSerive.findById(id);
		 return new ResponseEntity<>(marca, HttpStatus.OK);
		 }catch (Exception e) {
	    e.printStackTrace()	;
	   return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);// TODO: handle exception
		}
		 
	 }
	 

}
