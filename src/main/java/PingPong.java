import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class PingPong {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/detector", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/detector.vtl");
    
      String number = request.queryParams("number");
      Integer integerNumber = Integer.parseInt(number);

      // PingPong myPingPong = new PingPong();
      ArrayList<Object> results = isPingPong(integerNumber);

      model.put("finalNumber", results);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }



  public static ArrayList<Object> isPingPong(Integer number) {
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
