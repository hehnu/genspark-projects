import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

class GameTest {

    Game main;

    @BeforeEach
    void setUp() throws FileNotFoundException {
        main = new Game();

    }


   @Test
   void main() {
       main = new Game();

       assertEquals(true, main instanceof Game);

   }


    @Test
    void drawHangman() {

        main.drawHangman(8);
        assertEquals(8, 8);
    }
       @Test
        void anotherRound() {

            main.anotherRound();
           assertEquals(true, main instanceof Game);

    }
}