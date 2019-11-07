package com.aereas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aereas.domain.Passageiro;

@Repository
public interface PassageiroRepository extends JpaRepository<Passageiro, Integer> {

	// Inserir Query para aceitar Login com Cpf ou email e senha
	@Query("SELECT DISTINCT obj FROM Passageiro obj WHERE (obj.email = :username OR obj.cpf = :username)")
	Passageiro findByLoginUser(@Param("username") String username);

}
