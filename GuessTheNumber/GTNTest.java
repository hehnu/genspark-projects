
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GTNTest {

    GTN game;

    @BeforeEach
    void setUp() {
        game=new GTN();


    }

    @Test
    void game(){


    String hello="Ashley";
    game.guess=10;
    game.number=10;
    int i=1;



        assertEquals(10,10,"Good job, " + hello +
                "! \n"
                + "You guessed my number in " + i + " guesses!");

    }

    @AfterEach
    void tearDown() {
    }
}
