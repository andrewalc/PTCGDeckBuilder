package model;

/**
 * Created by Andrew Alcala on 8/3/2017.
 */
public interface IDeckBuilderModel<Card> {

  /**
   * Creates a new deck with the given name. The active deck is now this deck.
   */
  void createNewDeck(String name);

  /**
   * Loads a deck of the given name. The active deck is now this deck.
   */
  void loadDeck(String name);

  /**
   * Saves and exports the active deck.
   */
  void saveDeck();

  /**
   * Adds num amount of the given card to the active deck.
   *
   * @param card Card class used with this deck builder model.
   */
  void addCard(Card card, int num);

  /**
   * Removes all instances of this card from the active deck.
   *
   * @param card Card to remove from the deck.
   */
  void removeCard(Card card);

  /**
   * Sets the number of given cards to the new number of given cards in the active deck.
   *
   * @param card   Card to change number of.
   * @param newNum New number of given card in deck.
   */
  void modifyNumOfCard(Card card, int newNum);

  /**
   * Simulates drawing a hand of 7 cards.
   */
  void simulateHand();

  /**
   * Prints a given cards info to the console. The format for this is number of cards, name, and
   * expansion. Ex. 4x Tapu Lele GX [Burning Shadows]
   */
  void printCardDeckInfo(Card card);

  /**
   * Prints the active deck list to the console.
   */
  void printDeckList();


}
