package zuev.nikita.creature;

public interface EyesMoves {
    void closeEyesByHands()throws ImpossibleMoveException;
    boolean isClosedEyes();
    void openEyes() throws ImpossibleMoveException;
}
