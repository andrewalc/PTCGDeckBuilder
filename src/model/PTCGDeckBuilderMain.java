package model;

import java.io.InputStreamReader;

/**
 * Main method for the deck builder.
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
