package model;

/**
 * TODO: Implement command pattern within
 */
public interface IDeckBuilderCommand<Card> {

  /**
   * Performs the associate command that is associated with this class implementation from the
   * given IDeckBuilder model.
   *
   * @param model The IDeckBuilderModel.
   */
  void perform(IDeckBuilderModel<Card> model);
}
