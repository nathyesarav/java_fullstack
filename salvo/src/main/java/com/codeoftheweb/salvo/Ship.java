package com.codeoftheweb.salvo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
public class Ship {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;


    @ManyToOne(fetch =FetchType.EAGER)
    @JoinColumn(name = "gamePlayer_id")
    private GamePlayer gamePlayer;

    @ElementCollection
    private List<String> shipLocations = new ArrayList<>();

    private String type;



    public Ship() {
    }

    public Ship(String type, List<String> shipLocations) {
        this.type = type;
        this.shipLocations = shipLocations;

    }

    public void setId(long id) {
        this.id = id;
    }



    public GamePlayer getGamePlayer() {
        return gamePlayer;
    }

    public void setGamePlayer(GamePlayer gamePlayer) {
        this.gamePlayer = gamePlayer;
    }

    public List<String> getShipLocations() {
        return shipLocations;
    }

    public void setShipLocations(List<String> shipLocations) {
        this.shipLocations = shipLocations;
    }

    public long getId() {

        return id;
    }



    public Map<String,Object> shipDTO(){
        Map<String,Object> dto = new LinkedHashMap<>();



        return dto;

    }


}


