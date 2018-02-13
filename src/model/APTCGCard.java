package model;

/**
 * Abstract class for a Pokemon Trading Card Game card.
 */
public abstract class APTCGCard {

  private final String name;
  private final String expansion;
  private final int cardNum;


  /**
   * Constructor for a general PTCG card.
   * @param name The name of the card.
   * @param expansion The expansion the card is from.
   * @param cardNum The quantity of the card in possession.
   */
  public APTCGCard(String name, String expansion, int cardNum) {
    this.name = name;
    this.expansion = expansion;
    this.cardNum = cardNum;
  }

  public String getName() {
    return name;
  }

  public String getExpansion() {
    return expansion;
  }

  public int getCardNum() {
    return cardNum;
  }

  public String getCardInfo() {
    return name + " [" + expansion + " (" + cardNum + ")]";
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof APTCGCard)) {
      return false;
    }

    APTCGCard other = (APTCGCard) o;
    return this.name.equals(other.getName()) && this.expansion.equals(other.getExpansion()) &&
            this.cardNum == other.getCardNum();
  }

  @Override
  public int hashCode() {
    int result = getName() != null ? getName().hashCode() : 0;
    result = 31 * result + (getExpansion() != null ? getExpansion().hashCode() : 0);
    result = 31 * result + getCardNum();
    return result;
  }
}
