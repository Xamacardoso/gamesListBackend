package com.xamacardoso.gamesList.services;

import com.xamacardoso.gamesList.dto.GameMinDTO;
import com.xamacardoso.gamesList.entities.Game;
import com.xamacardoso.gamesList.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service // Registers this class as a component in the application
public class GameService {

    @Autowired // Dependency injection
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll(){
        List<Game> result = gameRepository.findAll();
        List<GameMinDTO> dtos = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dtos;
    }
}
