package com.devsuperior.dslit.controller;

import com.devsuperior.dslit.dto.GameDTO;
import com.devsuperior.dslit.dto.GameListDTO;
import com.devsuperior.dslit.dto.GameMinDTO;
import com.devsuperior.dslit.dto.ReplacementDTO;
import com.devsuperior.dslit.services.GameListService;
import com.devsuperior.dslit.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Esse controller é a porta de entrada para o backend
@RestController
@RequestMapping(value = "/lists")
public class GameListController {
    @Autowired
    private GameListService gameListService;
    @Autowired
    private GameService gameService;

    public GameListController() {
    }

    @GetMapping
    public List<GameListDTO> findAll() {
        List<GameListDTO> result = this.gameListService.findAll();
        return result;
    }

    @GetMapping({"/{listId}/games"})
    public List<GameMinDTO> findByList(@PathVariable Long listId) {
        List<GameMinDTO> result = this.gameService.findByList(listId);
        return result;
    }
    @PostMapping({"/{listId}/replacement"})
    public void move (@PathVariable Long listId, @RequestBody ReplacementDTO body) {
        gameListService.move(listId, body.getSourceIndex(),body.getDestinationIndex());
    }



}
