import java.rmi.*;

public interface Looker extends Remote{
  public String pcInformation() throws RemoteException;
}