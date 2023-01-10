package app.exceptions;

public class CategoryNotFoundException extends Exception {
    public CategoryNotFoundException(Long id)
    {
        super("Category with id: " + id + "not found!");
    }
}
