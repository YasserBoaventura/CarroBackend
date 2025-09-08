package carro.carro.CarroRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import carro.carro.CarroEntity.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Long> {

}
