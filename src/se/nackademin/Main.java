package se.nackademin;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        QuizClient client = new QuizClient("127.0.0.1");
        client.start();

    }
}
