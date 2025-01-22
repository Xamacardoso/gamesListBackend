package com.xamacardoso.gamesList.services;

import com.xamacardoso.gamesList.dto.GameDTO;
import com.xamacardoso.gamesList.dto.GameMinDTO;
import com.xamacardoso.gamesList.entities.Game;
import com.xamacardoso.gamesList.projections.GameMinProjection;
import com.xamacardoso.gamesList.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service // Registers this class as a component in the application
public class GameService {

    @Autowired // Dependency injection
    private GameRepository gameRepository;

    @Transactional(readOnly = true) // Makes this method obey to ACID principles.
    public List<GameMinDTO> findAll(){
        List<Game> result = gameRepository.findAll();
        List<GameMinDTO> dtos = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dtos;
    }

    @Transactional(readOnly = true)
    // TODO: Add exception treatment
    public GameDTO findById(Long id){
        Game result = gameRepository.findById(id).get();
        return new GameDTO(result);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId){
        List<GameMinProjection> result = gameRepository.searchByList(listId);
        List<GameMinDTO> dtos = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dtos;
    }
}
