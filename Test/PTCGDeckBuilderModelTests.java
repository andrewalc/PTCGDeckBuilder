import org.junit.Test;

import model.APTCGCard;
import model.PTCGDeckBuilderModel;
import model.IDeckBuilderModel;
import model.PokemonCard;

import static org.junit.Assert.assertEquals;

/**
 * Created by Andrew Alcala on 8/3/2017.
 */
public class PTCGDeckBuilderModelTests {
  PTCGDeckBuilderModel model = new PTCGDeckBuilderModel();

  @Test
  public void testDeckBuilder() {
    PokemonCard tapuleleGx = new PokemonCard("Tapu Lele GX", "Guardians Rising", 123);
    PokemonCard espeonGx = new PokemonCard("Espeon GX", "Sun and Moon Base Set", 124);
    PokemonCard wishiwashiGx = new PokemonCard("Wishiwashi GX", "Guardians Rising", 129);
    PokemonCard waterEnergy = new PokemonCard("Water Energy", "Sun and Moon Base Set", 1);
    model.createNewDeck("Top Tier Deck");
    model.addCard(tapuleleGx, 4);
    model.addCard(espeonGx, 2);
    model.addCard(wishiwashiGx, 1);
    model.addCard(waterEnergy, 12);
    assertEquals(true, true);
    model.modifyNumOfCard(wishiwashiGx, 10);
    model.removeCard(espeonGx);
    model.addCard(tapuleleGx, 9);
    model.modifyNumOfCard(tapuleleGx, 999);
    model.addCard(tapuleleGx, 1);
    model.printDeckList();

  }
}
