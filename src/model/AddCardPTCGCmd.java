package model;

/**
 * Created by Andrew Alcala on 8/3/2017.
 */
public class AddCardPTCGCmd implements IDeckBuilderCommand<APTCGCard> {

  private APTCGCard card;
  private int num;

  public AddCardPTCGCmd(APTCGCard card, int num) {
    this.card = card;
    this.num = num;
  }

  @Override
  public void perform(IDeckBuilderModel<APTCGCard> model) {
    model.addCard(card, num);
  }
}
