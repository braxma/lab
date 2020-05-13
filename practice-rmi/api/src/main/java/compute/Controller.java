package compute;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Controller extends Remote {

    /** Read data from remote */
    String read() throws RemoteException;
    /** Add data to remote */
    void add(String input) throws RemoteException;

}
