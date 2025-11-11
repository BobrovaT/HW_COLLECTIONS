package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Player player1 = new Player(1, "RedHead", 50);
    Player player2 = new Player(2, "Overlord", 72);
    Player player3 = new Player(3, "Landia", 103);
    Player player4 = new Player(3, "Chel", 72);

    @Test
    public void test1(){
        Game game = new Game();
        game.register(player1);
        game.register(player2);

        int actual = game.round("RedHead", "Overlord");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test2(){
        Game game = new Game();
        game.register(player3);
        game.register(player2);

        int actual = game.round("Landia", "Overlord");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void test3(){
        Game game = new Game();
        game.register(player4);
        game.register(player2);

        int actual = game.round("Chel", "Overlord");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test4(){
        Game game = new Game();
        game.register(player1);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("RedHead", "Overlord"));
    }


    @Test
    public void test5(){
        Game game = new Game();
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("RedHead", "Overlord"));

    }
}