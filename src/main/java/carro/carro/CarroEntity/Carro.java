package carro.carro.CarroEntity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	 
	
	@ManyToOne()
    @JoinColumn(name = "marca_id")
	private Marca marca; 
	
	@ManyToMany
	@JoinTable(
	    name = "carro_acessorio",
	    joinColumns = @JoinColumn(name = "carro_id"),
	    inverseJoinColumns = @JoinColumn(name = "acessorio_id")
	)
	private List<Acessorio> acessorios;

}
