package com.xamacardoso.gamesList.repositories;

import com.xamacardoso.gamesList.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {
}
