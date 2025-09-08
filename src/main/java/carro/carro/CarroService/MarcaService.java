package carro.carro.CarroService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carro.carro.CarroEntity.Marca;
import carro.carro.CarroRepository.MarcaRepository;

@Service
public class MarcaService {
	
  @Autowired
  private MarcaRepository marcaRepository;
	
	public String save(Marca marca) {
		
		this.marcaRepository.save(marca);
		return "Marca salva com sucesso";
		
	}
	public String update(Marca marca, long id) {
		marca.setId(id);
		
		this.marcaRepository.save(marca);
		return "Marca Atualizada com sucesso";
		
	}
	
	public List<Marca> findAll(){
		return this.marcaRepository.findAll()	;
	    	
	}
	public Marca findById(long id) {
		Marca marca=new Marca();
     return marca=this.marcaRepository.findById(id).get();
	}
	 
	public String delete(long id) {
		
		this.marcaRepository.deleteById(id);
		return "Deletado com sucesso";
		
	}

	
}



