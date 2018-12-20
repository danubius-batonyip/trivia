package com.adaptionsoft.games.trivia.runner;

import com.adaptionsoft.games.uglytrivia.Output;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class FileOutput implements Output {

    FileOutputStream fos;
    PrintWriter writer;

    public FileOutput(File file) throws Exception {
        if (!file.exists()) {
            file.createNewFile();
        }

        this.fos = new FileOutputStream(file);
        this.writer = new PrintWriter(this.fos);
    }

    @Override
    public void println(Object s) {
        this.writer.println(s);
    }

    public void close() throws Exception {
        writer.flush();
        writer.close();
        fos.flush();
        fos.close();
    }
}
