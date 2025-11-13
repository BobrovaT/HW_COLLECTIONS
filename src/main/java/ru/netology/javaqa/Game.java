package ru.netology.javaqa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    HashMap<String, Player> players = new HashMap<>();

    public Player register(Player player) {
        players.put(player.getName(), player);
        return player;
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = players.get(playerName1);
        Player player2 = players.get(playerName2);
        if (!findName(playerName1)) {
            throw new NotRegisteredException(playerName1);
        }
        if (!findName(playerName2)) {
            throw new NotRegisteredException(playerName2);
        }
        if (player1.getStrength() < player2.getStrength()) {
            return 2;
        } else if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else {
            return 0;
        }
    }

    private boolean findName(String playerName) {
        return players.containsKey(playerName);
    }


}
