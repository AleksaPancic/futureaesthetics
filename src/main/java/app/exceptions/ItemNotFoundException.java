package app.exceptions;

public class ItemNotFoundException extends Exception{

    public ItemNotFoundException(Long id){
        super("Item with id: " + id + " not found");
    }
}
