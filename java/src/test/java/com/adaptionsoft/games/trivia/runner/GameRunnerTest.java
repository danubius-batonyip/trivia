package com.adaptionsoft.games.trivia.runner;

import com.adaptionsoft.games.uglytrivia.Output;
import com.adaptionsoft.games.uglytrivia.TestOutput;
import com.adaptionsoft.games.uglytrivia.TimeProvider;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.util.Random;

import static org.junit.Assert.*;

public class GameRunnerTest {

    @Test
    public void runTest() throws Exception {
        for ( int i = 0; i < 300; i++) {
            Random random = new Random(i);

            File out = new File(System.getProperty("java.io.tmpdir") + File.separator + "trivia" + File.separator + "output2-" + i + ".log");
            FileOutput output = new FileOutput(out);

            TimeProvider timeProvider = new TestTimeProvider();
            GameRunner.run(random, output, timeProvider);

            output.close();
        }
    }

    @Test
    public void runGoldenMasterTest() throws Exception {
        for ( int i = 0; i < 300; i++ ) {
            Random random = new Random(i);
            Output output = new TestOutput();

            TimeProvider timeProvider = new TestTimeProvider();
            GameRunner.run(random, output, timeProvider);

            String result = output.toString();

            File out = new File(System.getProperty("java.io.tmpdir") + File.separator + "trivia" + File.separator + "output2-" + i + ".log");
            byte[] contents = Files.readAllBytes(out.toPath());

            assertEquals(new String(contents),result);

        }
    }
}
