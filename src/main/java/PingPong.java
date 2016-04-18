import java.util.ArrayList;

public class PingPong {
  public static void main(String[] args) {
    
  }

  public ArrayList<Object> isPingPong(Integer number) {
    ArrayList<Object> myList = new ArrayList<Object>();
    for (Integer index = 1; index <= number; index ++){
      if (index % 15 == 0){
        myList.add("pingpong");
      }else if (index % 3 == 0){
        myList.add("ping");
      }else if (index % 5 == 0){
        myList.add("pong");
      } else myList.add(index);

    }
    return myList;
  }
}
