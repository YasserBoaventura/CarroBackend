package carro.carro.Controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import carro.carro.CarroController.CarroController;
import carro.carro.CarroEntity.Acessorio;
import carro.carro.CarroEntity.Carro;
import carro.carro.CarroEntity.Marca;
import carro.carro.CarroRepository.CarroRepository;
import carro.carro.CarroService.CarroService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.*;

@SpringBootTest
public class ControllerTest {

	//Comecarei por alguns testes e 
	
    @Mock
    CarroService carroServico;
	@Autowired
	CarroController carroController;
	
	
	  @MockitoBean
     CarroRepository carroRepository; 
	  
	  @BeforeEach
		void setup() {
		    List<Carro> lista = new ArrayList<>();

		    Marca marca = new Marca(1L, "Toyota");
		    long id=1L;
		    long id2=2L;
		    List<Acessorio> acessorio = List.of(
		        new Acessorio(id, "João"),
		        new Acessorio(id2, "Maria")
		    );

		    Carro carro = new Carro(1L, "Corolla", marca,acessorio);
 
		    lista.add(carro);

		       when(carroRepository.findAll()).thenReturn(lista);

		        Carro carro02 = new Carro(1L, "Corolla", marca, acessorio);

		        when(carroRepository.findById(1L)).thenReturn(Optional.of(carro02));

		        //
		       
		       
		       }
	@Test
	void cenario01() {
		
	    ResponseEntity<List<Carro>> response = this.carroController.findAll();
	    
			assertEquals(HttpStatus.OK, response.getStatusCode());
			assertNotNull(response);
			
	}
	
	@Test
	void cenario02() {
		
		ResponseEntity<Carro> response = this.carroController.findById(1L);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		
	}
	
	@Test
	void ceanrio03() {

	   
	        // Arrange
	        long id = 1L;
	        Marca marca = new Marca(1L, "Toyota");
	        List<Acessorio> acessorio = List.of(new Acessorio(id, "João"));
	        Carro carro = new Carro(id, "Corolla", marca, acessorio);

	        String mensagemEsperada = "Carro atualizado com sucesso";

	        when(carroServico.update(carro, id)).thenReturn(mensagemEsperada);

	        // Act
	        ResponseEntity<String> response = carroController.update(carro, id);

	        // Assert
	        assertEquals(HttpStatus.OK, response.getStatusCode());
	        assertEquals(mensagemEsperada, response.getBody());
	        assertNotNull(response);
	    }
	}

