package com.devsuperior.dslit.dto;

import com.devsuperior.dslit.entities.GameList;

public class GameListDTO {

    private Long id;
    private String title;

    public GameListDTO(){

    }

    public GameListDTO(GameList entity) {
        id = entity.getId();
        title = entity.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
