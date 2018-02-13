package model;

import java.util.HashMap;

/**
 * Model implementation for a PTCG deck builder. The builder allows the user to add, remove, and
 * modify their deck and look at the deck as a whole at a glance.
 */
public class PTCGDeckBuilderModel implements IDeckBuilderModel<APTCGCard> {
  private String activeDeckName = "";
  private HashMap<APTCGCard, Integer> activeDeck = null;

  public PTCGDeckBuilderModel() {
  }

  @Override
  public void createNewDeck(String name) {
    this.activeDeckName = name;
    activeDeck = new HashMap<>();
  }

  @Override
  public void loadDeck(String name) {

  }

  @Override
  public void saveDeck() {

  }

  @Override
  public void addCard(APTCGCard card, int num) {
    if (activeDeck == null) {
      throw new NullPointerException("The Active Deck is null, please create a new deck");
    }
    if (num < 1) {
      throw new IllegalArgumentException("You cannot add less than one of this card. You entered " +
              num);
    }
    if (activeDeck.containsKey(card)) {
      activeDeck.put(card, activeDeck.get(card) + num);
    } else {
      activeDeck.put(card, num);
    }
  }

  @Override
  public void removeCard(APTCGCard card) {
    if (activeDeck == null) {
      throw new NullPointerException("The Active Deck is null, please create a new deck");
    }
    if (!(activeDeck.containsKey(card))) {
      throw new IllegalArgumentException("The given card is not in the active deck!");
    }
    activeDeck.remove(card);
  }

  @Override
  public void modifyNumOfCard(APTCGCard card, int newNum) {
    if (activeDeck == null) {
      throw new NullPointerException("The Active Deck is null, please create a new deck");
    }
    if (!(activeDeck.containsKey(card))) {
      throw new IllegalArgumentException("The given card is not in the active deck!");
    }
    if (newNum < 1) {
      throw new IllegalArgumentException("You cannot set this card to have less than one of" +
              " this card. You entered " + newNum);
    }
    activeDeck.put(card, newNum);
  }

  @Override
  public void simulateHand() {

  }

  private String getCardDeckInfo(APTCGCard card) {
    if (!activeDeck.containsKey(card)) {
      throw new IllegalArgumentException("The given card is not in the active deck!");
    }
    return activeDeck.get(card) + "x " + card.getCardInfo();
  }

  @Override
  public void printCardDeckInfo(APTCGCard card) {
    if (!activeDeck.containsKey(card)) {
      throw new IllegalArgumentException("The given card is not in the active deck!");
    }
    System.out.println(getCardDeckInfo(card));
  }

  private int getTotalNumCards() {
    int result = 0;
    for (Integer n : this.activeDeck.values()) {
      result += n;
    }
    return result;
  }

  private String getDeckList() {
    String result = "*** " + this.activeDeckName + " " + getTotalNumCards() + " ***\n\n";
    for (APTCGCard card : this.activeDeck.keySet()) {
      result += STR_TAB + "* " + getCardDeckInfo(card) + "\n";
    }
    return result;
  }


  @Override
  public void printDeckList() {
    System.out.println(getDeckList());
  }

  private final String STR_TAB = "   ";
}
