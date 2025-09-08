package carro.carro.CarroRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import carro.carro.CarroEntity.Carro;

public interface CarroRepository  extends JpaRepository<Carro, Long> {

}
