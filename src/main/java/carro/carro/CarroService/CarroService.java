package carro.carro.CarroService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carro.carro.CarroEntity.Carro;
import carro.carro.CarroRepository.CarroRepository;

@Service
public class CarroService {

	
	@Autowired
	private CarroRepository carroRepository;
	
	
	public String save(Carro carro) {
		this.verificarNome(carro.getNome());
		
		this.carroRepository.save(carro);
		return "Carro salvo com sucesso";
		
	}
	public boolean  verificarNome(String nome ) {
		if(nome.equals("Mercedes")) {
			return true;
		}else {
			return false;
		}
		
	}
	public String update(Carro carro, long id) {
		carro.setId(id);
		
		this.carroRepository.save(carro);
		return "Carro atualizado com sucesso";
		
	}
	
	public List<Carro> findAll(){
		return this.carroRepository.findAll()	;
	    	
	}
	public Carro findById(long id) {
		Carro carro=new Carro();
     return carro=this.carroRepository.findById(id).get();
	}
	 
	public String delete(long id) {
		
		this.carroRepository.deleteById(id);
		return "Deletados com sucesso";
		
	}

	
}
