package model;

import java.io.InputStreamReader;

/**
 * Created by Andrew Alcala on 8/3/2017.
 */
public class PTCGDeckBuilderMain {

  public static void main(String[] args) {
    PTCGDeckBuilderModel model = new PTCGDeckBuilderModel();
    PTCGDeckBuilderController controller = new PTCGDeckBuilderController(new InputStreamReader
            (System.in),
            System.out);
    controller.startDeckBuilder(model);
  }
}
