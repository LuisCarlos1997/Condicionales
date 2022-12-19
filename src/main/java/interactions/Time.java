package interactions;

public class Time {

  public static void Sleep(int milisegundo){
      try {
          Thread.sleep(milisegundo);
      } catch (Exception e) {
          e.printStackTrace();
      }
    }
}
