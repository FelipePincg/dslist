package com.devsuperior.dslit.services;

import com.devsuperior.dslit.dto.GameMinDTO;
import com.devsuperior.dslit.entities.Game;
import com.devsuperior.dslit.repositores.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    //Injeção de dependencia.
    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll() {
        List<Game>  result =  gameRepository.findAll();
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return  dto;
    }

}
