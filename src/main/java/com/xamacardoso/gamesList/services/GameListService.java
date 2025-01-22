package com.xamacardoso.gamesList.services;

import com.xamacardoso.gamesList.dto.GameListDTO;
import com.xamacardoso.gamesList.entities.GameList;
import com.xamacardoso.gamesList.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameListService {
    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> gameLists = gameListRepository.findAll();
        List<GameListDTO> gameListDTOs = gameLists.stream().map(x -> new GameListDTO(x)).toList();
        return gameListDTOs;
    }
}
