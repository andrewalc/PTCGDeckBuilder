package model;

/**
 * Created by Andrew Alcala on 8/3/2017.
 */
public interface IDeckBuilderCommand<Card> {

  /**
   * Performs the associate command that is associated with this class implementation from the
   * given IConnectN model.
   *
   * @param model The ConnectNModel of the game of ConnectN.
   */
  void perform(IDeckBuilderModel<Card> model);
}
