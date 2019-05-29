import java.io.PrintStream;
import java.rmi.Naming;

public class Client
{
  public Client() {}
  
  public static void main(String[] paramArrayOfString)
  {
    try
    {
      System.out.println("Fazendo a requisição para rmi://localhost:5000/sonoo");
      Looker localLooker = (Looker)Naming.lookup("rmi://localhost:5000/sonoo");
      System.out.println(localLooker.pcInformation());
      System.out.println("Requisição fechada.");
    } catch (Exception localException) {
      System.out.println(localException.getMessage());
    }
  }
}
