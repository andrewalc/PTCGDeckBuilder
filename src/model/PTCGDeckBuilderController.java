package model;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Andrew Alcala on 8/3/2017.
 */
public class PTCGDeckBuilderController implements IDeckBuilderController<APTCGCard> {
  private Readable rd;
  private Appendable ap;

  public PTCGDeckBuilderController(Readable rd, Appendable ap) throws IllegalStateException {
    if (rd == null || ap == null) {
      throw new IllegalStateException("Readable and Appendable object cannot be null");
    }
    this.rd = rd;
    this.ap = ap;
  }

  @Override
  public void startDeckBuilder(IDeckBuilderModel<APTCGCard> model) {
    try {
      if (model == null) {
        throw new NullPointerException("Model is null");
      }
      Scanner scan = new Scanner(this.rd);
      IDeckBuilderCommand<APTCGCard> cmd = null;
      this.ap.append("*** Welcome to the deck builder! ****\nPlease enter a name for your deck.\n");
      String deckname = scan.nextLine();
      model.createNewDeck(deckname);
      model.printDeckList();
      this.ap.append(deckname + " is ready for editing! \nType help for a list of commands." +
              "\nEnter a command.\n");
      while (scan.hasNext()) {

        boolean validInput = false;
        String newCardName = "";
        String newCardExpansion = "";
        int newCardAmt = 0;
        String newCardNum = "";

        String strCmd = scan.next().toLowerCase();
        scan.nextLine();

        switch (strCmd) {

          case "help":
            this.ap.append("*** List of valid commands ***\n");
            this.ap.append("  add -> add cards to the deck\n");
            this.ap.append("  modify -> modifies the amount of a cards in a deck\n");
            this.ap.append("  remove -> removes a card from the deck\n");
            this.ap.append("  help -> shows a list of valid commands\n");
            this.ap.append("******************************\n");

            break;

          case "add":
            this.ap.append("Please enter the name of the card to add.\n");
            newCardName = scan.nextLine();
            this.ap.append("Please enter the name of the card expansion.\n");
            newCardExpansion = scan.nextLine();
            this.ap.append("Please enter how many cards to add.\n");
            try{
              newCardAmt = Integer.parseInt(scan.next());
              model.addCard(new PokemonCard(newCardName, newCardExpansion, 0), newCardAmt);
            }
            catch (NumberFormatException e){
              this.ap.append("Error! Please enter a positive number of cards.\n");
            }
            break;

          case "remove":
            this.ap.append("Please enter the name of the card to remove.\n");
            newCardName = scan.nextLine();
            this.ap.append("Please enter the name of the card expansion.\n");
            newCardExpansion = scan.nextLine();
            model.removeCard(new PokemonCard(newCardName, newCardExpansion, 0));
            break;

          case "modify":
            this.ap.append("Please enter the name of the card you wish to modify the number of.\n");
            newCardName = scan.nextLine();
            this.ap.append("Please enter the name of the card expansion.\n");
            newCardExpansion = scan.nextLine();
            this.ap.append("Please enter how many of this card there are.\n");
            newCardAmt = Integer.parseInt(scan.next());
            model.modifyNumOfCard(new PokemonCard(newCardName, newCardExpansion, 0), newCardAmt);
            break;

          default:
            this.ap.append("Invalid command. Type help for a list of commands.\n\n");
            break;

        }
        model.printDeckList();
      }


    } catch (IOException e) {
      e.getMessage();
    }

  }
}
