package com.devsuperior.dslit.repositores;

import com.devsuperior.dslit.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

//Repository faz consulta no banco apenas

public interface GameRepository extends JpaRepository<Game,Long> {

}
