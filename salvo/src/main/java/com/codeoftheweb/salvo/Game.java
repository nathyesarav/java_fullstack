package com.codeoftheweb.salvo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private LocalDate date = LocalDate.now();

    @OneToMany(mappedBy = "game", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    Set<GamePlayer> gamePlayers;


    public Game() {
    }

    public void setId(long id) {

        this.id = id;
    }

    public void setDate(LocalDate date) {

        this.date = date;
    }

    public Set<GamePlayer> getGamePlayers() {

        return gamePlayers;
    }

    public void setGamePlayers(Set<GamePlayer> gamePlayers) {

        this.gamePlayers = gamePlayers;
    }

    public long getId() {

        return id;
    }

    public LocalDate getDate() {

        return date;
    }

    public Map<String,Object> gameDTO(){
        Map<String,Object> dto = new LinkedHashMap<>();

        dto.put("id",
                this.getId());
        dto.put("created",
                this.getDate());
        dto.put("gamePlayers",
                this.getGamePlayers().stream().map(GamePlayer::gamePlayerDTO));

        return dto;

    }


}