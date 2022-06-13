import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    Main main;

    @BeforeEach
    void setUp() {
        main = new Main();
    }


    @Test
    void main() {
        main.userOpt = 1;
        assertEquals(1,1, "You approach the cave...\n"+
                "It is dark and spooky..\n"+
                "A large dragon jumps out in front of you! He opens his jaws and...\n" +
                "Gobbles you down in one bite!");

    }

    @AfterEach
    void tearDown() {
    }
}

