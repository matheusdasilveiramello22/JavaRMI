import java.io.PrintStream;
import java.rmi.Naming;

public class Server
{
  public Server() {}
  
  public static void main(String[] paramArrayOfString)
  {
    try
    {
      LookerRemote localLookerRemote = new LookerRemote();
      Naming.rebind("rmi://localhost:5000/sonoo", localLookerRemote);
    } catch (Exception localException) {
      System.out.println(localException);
    }
  }
}
