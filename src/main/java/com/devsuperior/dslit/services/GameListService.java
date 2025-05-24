package com.devsuperior.dslit.services;

import com.devsuperior.dslit.dto.GameDTO;
import com.devsuperior.dslit.dto.GameListDTO;
import com.devsuperior.dslit.dto.GameMinDTO;
import com.devsuperior.dslit.entities.Game;
import com.devsuperior.dslit.entities.GameList;
import com.devsuperior.dslit.projections.GameMinProjection;
import com.devsuperior.dslit.repositores.GameListRepository;
import com.devsuperior.dslit.repositores.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {
    //Injeção de dependencia se utiliza o AutoWired para injeção.
    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private  GameRepository gameRepository;
    public GameListService() {
    }

    @Transactional(
            readOnly = true
    )
    public List<GameListDTO> findAll() {
        List<GameList> result = this.gameListRepository.findAll();
        List<GameListDTO> dto = result.stream().map((x) -> new GameListDTO(x)).toList();
        return dto;
    }
    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex){

        List<GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex,obj);
        int min  = Math.min(sourceIndex, destinationIndex);
        int max  = Math.max(sourceIndex, destinationIndex);
        for (int i = min;i <= max ; i++ ){
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(),i);
        }



    }

}
