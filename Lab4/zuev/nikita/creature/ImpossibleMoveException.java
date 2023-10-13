package zuev.nikita.creature;

public class ImpossibleMoveException extends RuntimeException {
    public ImpossibleMoveException(String message){
        super(message);
    }
}
