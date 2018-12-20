package com.adaptionsoft.games.trivia.runner;

import com.adaptionsoft.games.uglytrivia.TimeProvider;

public class TestTimeProvider implements TimeProvider {

    private Long lastTime = null;

    @Override
    public long getTimeMilis() {
        if (lastTime == null) {
            lastTime = System.currentTimeMillis();
        } else {
            lastTime += 3*60*60*1000;
        }

        return lastTime;
    }
}
