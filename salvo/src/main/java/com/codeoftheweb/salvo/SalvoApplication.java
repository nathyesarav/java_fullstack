package com.codeoftheweb.salvo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class SalvoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalvoApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(PlayerRepository playerRepository, GameRepository gameRepository, GamePlayerRepository gamePlayerRepository){
		return (args) -> {
			Player player1 = playerRepository.save(new Player("nsarav", "Nathye", "Sarav"));
			Player player2 = playerRepository.save(new Player("nsarav", "Nathye", "Sarav"));
			Player player3 = playerRepository.save(new Player("pepin", "Pepito", "Perez"));
			Player player4 = playerRepository.save(new Player("firulay", "Firu", "Lay"));
			Player player5 = playerRepository.save(new Player("pirulo", "Piru", "Lo"));

            Game game1 = gameRepository.save(new Game());
			Game game2 = gameRepository.save(new Game());
			Game game3 = gameRepository.save(new Game());

			GamePlayer gamePlayer1 = gamePlayerRepository.save(new GamePlayer(player1,game1));
			GamePlayer gamePlayer2 = gamePlayerRepository.save(new GamePlayer(player2,game1));

			Ship ship1 = new Ship("submarine", Arrays.asList("A1","A2","A3"));

			gamePlayer1.addShip(ship1);

			gamePlayerRepository.save(gamePlayer1);

		};
	}

}
