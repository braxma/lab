package xyz;

import compute.Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServerRmi implements Controller {

    public Path path = Paths.get("remote_file");

    public ServerRmi() {
        super();
    }

    public static void main(String[] args) {
        try {
            ServerRmi obj = new ServerRmi();
            Controller stub = (Controller) UnicastRemoteObject.exportObject(obj, 0);

            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind(Controller.class.getSimpleName(), stub);

            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }

    @Override
    public String read() throws RemoteException {
        if(Files.isReadable(path)) {
            try {
                return Files.readAllLines(path.toAbsolutePath()).stream().reduce((v1, v2) -> v1 + v2).orElse("");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    @Override
    public void add(String input) throws RemoteException {
        if(!Files.isWritable(path)) {
            try {
                Files.write(path, "".getBytes(), new StandardOpenOption[]{StandardOpenOption.CREATE_NEW});
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            Files.write(path, input.getBytes(), new StandardOpenOption[]{StandardOpenOption.APPEND});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
