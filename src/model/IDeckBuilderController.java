package model;

/**
 * Created by Andrew Alcala on 8/3/2017.
 */
public interface IDeckBuilderController<Card> {

  /**
   * Starts the deck builder controller for input.
   */
  void startDeckBuilder(IDeckBuilderModel<Card> model);
}
