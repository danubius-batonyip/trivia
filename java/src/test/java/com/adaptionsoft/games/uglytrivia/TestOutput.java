package com.adaptionsoft.games.uglytrivia;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestOutput implements Output {
    private ByteArrayOutputStream os;
    private PrintStream ps;

    public TestOutput() {
        this.os = new ByteArrayOutputStream();
        this.ps = new PrintStream(os);
    }

    @Override
    public void println(Object s) {
        ps.println(s);
    }

    @Override
    public String toString() {
        return this.os.toString();
    }
}
