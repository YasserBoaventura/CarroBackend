package carro.carro.CarroService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carro.carro.CarroEntity.Acessorio;
import carro.carro.CarroEntity.Carro;
import carro.carro.CarroRepository.AcessorioRepository;
import carro.carro.CarroRepository.CarroRepository;

@Service
public class AcessorioService {
	
   @Autowired
   private  AcessorioRepository  AcessorioRepository;
	
	public String save(Acessorio acessorio) {
		
		this.AcessorioRepository.save(acessorio);
		return "Acessorio salvo com sucesso";
		
	}
	public String update(Acessorio acessorio, long id) {
		acessorio.setId(id);
		
		this.AcessorioRepository.save(acessorio);;
		return "Carro Atualizado com sucesso";
		
	}
	
	public List<Acessorio> findAll(){ 
		return this.AcessorioRepository.findAll()	;
	    	
	}
	public Acessorio findById(long id) {
		Acessorio acessorio=new Acessorio();
     return acessorio=this.AcessorioRepository.findById(id).get();
	}
	 
	public String delete(long id) {
		
		this.AcessorioRepository.deleteById(id);
		return "Deletados com sucesso";
		
	}

	
}

	


