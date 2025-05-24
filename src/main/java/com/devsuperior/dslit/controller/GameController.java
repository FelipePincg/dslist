package com.devsuperior.dslit.controller;

import com.devsuperior.dslit.dto.GameDTO;
import com.devsuperior.dslit.dto.GameMinDTO;
import com.devsuperior.dslit.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//Esse controller é a porta de entrada para o backend
@RestController
@RequestMapping(value = "/games")
public class GameController {
    @Autowired
    private GameService gameService;

    public GameController() {
    }

    @GetMapping({"/{id}"})
    public GameDTO findById(@PathVariable Long id) {
        GameDTO result = this.gameService.findById(id);
        return result;
    }

    @GetMapping
    public List<GameMinDTO> findAll() {
        List<GameMinDTO> result = this.gameService.findAll();
        return result;
    }

}
