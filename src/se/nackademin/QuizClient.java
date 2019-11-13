package se.nackademin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class QuizClient extends Thread {
    Socket socket;
    int port = 54321;
    BufferedReader input;
    PrintWriter output;

    public QuizClient (String serverAddress) throws IOException {
        socket = new Socket(serverAddress, port);
        input = new BufferedReader( new InputStreamReader(socket.getInputStream()));
        output = new PrintWriter(socket.getOutputStream(), true);
    }

    public void play () {
        String response;
        BufferedReader sysIn = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                while (true) {
                    response = input.readLine();
                    if (response != null)
                        System.out.println(response);
                    if (response.startsWith("3"))
                        break;
                }
                System.out.println("Enter guess");
                String qAnswer = sysIn.readLine();
                if (qAnswer != null)
                    output.println(qAnswer);

                while (true) {
                    response = input.readLine();
                    if (response != null) {
                        System.out.println(response);
                        break;
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        }

        public void receive (String response) throws IOException {
            while (true) {
                response = input.readLine();
                if (response != null)
                    System.out.println(response);
                if (response.startsWith("3"))
                    break;
            }
        }
        public void run () {
            play();
        }
    }


