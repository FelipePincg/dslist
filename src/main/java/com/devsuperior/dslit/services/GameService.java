package com.devsuperior.dslit.services;

import com.devsuperior.dslit.dto.GameDTO;
import com.devsuperior.dslit.dto.GameMinDTO;
import com.devsuperior.dslit.entities.Game;
import com.devsuperior.dslit.projections.GameMinProjection;
import com.devsuperior.dslit.repositores.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {
    //Injeção de dependencia.
    @Autowired
    private GameRepository gameRepository;

    public GameService() {
    }

    @Transactional(
            readOnly = true
    )
    public GameDTO findById(Long id) {
        Game result = (Game)this.gameRepository.findById(id).get();
        GameDTO dto = new GameDTO(result);
        return dto;
    }

    @Transactional(
            readOnly = true
    )
    public List<GameMinDTO> findAll() {
        List<Game> result = this.gameRepository.findAll();
        List<GameMinDTO> dto = result.stream().map((x) -> new GameMinDTO(x)).toList();
        return dto;
    }

    @Transactional(
            readOnly = true
    )
    public List<GameMinDTO> findByList(Long listId) {
        List<GameMinProjection> result = this.gameRepository.searchByList(listId);
        List<GameMinDTO> dto = result.stream().map((x) -> new GameMinDTO(x)).toList();
        return dto;
    }

}
