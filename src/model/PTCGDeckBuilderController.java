package model;

import java.io.IOException;
import java.util.Scanner;

/**
 * A PTCG deck builder controller. Allows for user input to interact with the deck builder.
 */
public class PTCGDeckBuilderController implements IDeckBuilderController<APTCGCard> {
  private Readable rd;
  private Appendable ap;

  /**
   * Constructor for the PTCGDeckBuilderController.
   * @param rd Readable (System.in)
   * @param ap Appendable (System.out)
   * @throws IllegalStateException If the readable or appendable is null.
   */
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


      // Welcome Message
      this.ap.append("*** Welcome to the deck builder! ****\nPlease enter a name for your deck.\n");
      // Read for the given deck name and create a new deck
      String deckname = scan.nextLine();
      model.createNewDeck(deckname);
      model.printDeckList();


      // The deck builder is ready to receive commands
      this.ap.append(deckname + " is ready for editing! \nType help for a list of commands." +
              "\nEnter a command.\n");

      // Begin instruction loop
      while (scan.hasNext()) {

        // Starting vars
        boolean validInput = false;
        String newCardName = "";
        String newCardExpansion = "";
        int newCardAmt = 0;
        String newCardNum = "";


        // Read a command. Should be one of: add, modify, remove, help
        String strCmd = scan.next().toLowerCase();
        scan.nextLine();

        // Take appropriate action given the command
        switch (strCmd) {

          // Prints help infomation
          case "help":
            this.ap.append("*** List of valid commands ***\n");
            this.ap.append("  add -> add cards to the deck\n");
            this.ap.append("  modify -> modifies the amount of a cards in a deck\n");
            this.ap.append("  remove -> removes a card from the deck\n");
            this.ap.append("  help -> shows a list of valid commands\n");
            this.ap.append("******************************\n");

            break;

          // Adds a card to the deck builder
          case "add":
            // Get the card name
            this.ap.append("Please enter the name of the card to add.\n");
            newCardName = scan.nextLine();
            // Get the card expansion
            this.ap.append("Please enter the name of the card expansion.\n");
            newCardExpansion = scan.nextLine();
            // Enter the quantity of cards to add
            this.ap.append("Please enter how many cards to add.\n");
            // Add to the deck builder
            try{
              newCardAmt = Integer.parseInt(scan.next());
              model.addCard(new PokemonCard(newCardName, newCardExpansion, 0), newCardAmt);
            }
            catch (NumberFormatException e){
              this.ap.append("Error! Please enter a positive number of cards.\n");
            }
            break;

          // Removes a card from the deck builder
          case "remove":
            // Get the name of the card to remove
            this.ap.append("Please enter the name of the card to remove.\n");
            newCardName = scan.nextLine();
            // Get the name of the card to remove's expansion
            this.ap.append("Please enter the name of the card expansion.\n");
            newCardExpansion = scan.nextLine();
            // Remove the card from the deck
            model.removeCard(new PokemonCard(newCardName, newCardExpansion, 0));
            break;

          // Modify the quantity of a card already in the deck
          case "modify":
            // Get the name of the card to modify
            this.ap.append("Please enter the name of the card you wish to modify the number of.\n");
            newCardName = scan.nextLine();
            // Get the name of the expansion the card is from
            this.ap.append("Please enter the name of the card expansion.\n");
            newCardExpansion = scan.nextLine();
            // Enter the new quantity
            this.ap.append("Please enter how many of this card there are.\n");
            newCardAmt = Integer.parseInt(scan.next());
            // Modify the card quantity in the deck builder
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
