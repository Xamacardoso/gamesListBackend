package com.xamacardoso.gamesList.repositories;

import com.xamacardoso.gamesList.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
