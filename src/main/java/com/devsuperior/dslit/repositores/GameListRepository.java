package com.devsuperior.dslit.repositores;

import com.devsuperior.dslit.entities.Game;
import com.devsuperior.dslit.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

//Repository faz consulta no banco apenas

public interface GameListRepository extends JpaRepository<GameList,Long> {

}
