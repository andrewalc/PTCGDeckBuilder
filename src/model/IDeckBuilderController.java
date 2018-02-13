package model;

/**
 * Interface for the deck builder controller.
 */
public interface IDeckBuilderController<Card> {

  /**
   * Starts the deck builder controller for input of a IDeckBuilderModel.
   */
  void startDeckBuilder(IDeckBuilderModel<Card> model);
}
