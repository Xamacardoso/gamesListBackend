package com.xamacardoso.gamesList.controllers;

import com.xamacardoso.gamesList.dto.GameListDTO;
import com.xamacardoso.gamesList.dto.GameMinDTO;
import com.xamacardoso.gamesList.dto.ReplacementDTO;
import com.xamacardoso.gamesList.services.GameListService;
import com.xamacardoso.gamesList.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll() {
        return gameListService.findAll();
    }
    
    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId){
        List<GameMinDTO> result = gameService.findByList(listId);
        return result;
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move (@PathVariable Long listId, @RequestBody ReplacementDTO body){
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }
}
