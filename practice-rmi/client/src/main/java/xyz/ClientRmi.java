package xyz;

import compute.Controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientRmi {

    public ClientRmi() { }

    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Registry registry = LocateRegistry.getRegistry("localhost");
            Controller remoteController = (Controller) registry.lookup(Controller.class.getSimpleName());
            String command = null;
            System.out.println("Connected to remote server");
            do {
                System.out.println("Please enter command (add, read)");
                command = reader.readLine();
                switch (command) {
                    case "add" : {
                        System.out.println("Please enter text to save");
                        String text = reader.readLine();
                        remoteController.add(text);
                        System.out.println("added: " + text);
                        break;
                    }
                    case "read": {
                        String read = remoteController.read();
                        System.out.println(read);
                        break;
                    }
                    default: {
                        System.out.println("Possible commands add, read, exit");
                    }
                }

            } while (!"exit".equals(command));
            System.out.println("Session closed");
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }

    }

}
