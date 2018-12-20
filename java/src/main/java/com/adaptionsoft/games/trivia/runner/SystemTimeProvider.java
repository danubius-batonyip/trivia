package com.adaptionsoft.games.trivia.runner;

import com.adaptionsoft.games.uglytrivia.TimeProvider;

public class SystemTimeProvider implements TimeProvider {
    @Override
    public long getTimeMilis() {
        return System.currentTimeMillis();
    }
}
