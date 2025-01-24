package com.xamacardoso.gamesList.services;

import com.xamacardoso.gamesList.dto.GameListDTO;
import com.xamacardoso.gamesList.entities.GameList;
import com.xamacardoso.gamesList.projections.GameMinProjection;
import com.xamacardoso.gamesList.repositories.GameListRepository;
import com.xamacardoso.gamesList.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameListService {
    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> gameLists = gameListRepository.findAll();
        List<GameListDTO> gameListDTOs = gameLists.stream().map(x -> new GameListDTO(x)).toList();
        return gameListDTOs;
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {
        List<GameMinProjection> games = gameRepository.searchByList(listId);
        GameMinProjection obj = games.remove(sourceIndex);
        games.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex > destinationIndex ? sourceIndex : destinationIndex;

        for (int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listId, games.get(i).getId(), i);
        }

    }
}
