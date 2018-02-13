package model;

public class PokemonCard extends APTCGCard {
  /**
   * Constructor for a Pokemon card of type Pokemon (Basic, Stage 1, Stage 2 etc...).
   * @param name The name of the Pokemon Card.
   * @param expansion The expansion the Pokemon Card is from.
   * @param cardNum The quantity of this card in posession.
   */
  public PokemonCard(String name, String expansion, int cardNum) {
    super(name, expansion, cardNum);
  }
}
