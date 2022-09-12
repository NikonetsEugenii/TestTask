package UI.objects;

import org.openqa.selenium.StaleElementReferenceException;

public class ExceptionTask {
    public ExceptionTask() {}

    public ExceptionTask catchException() {
        try {
            throw new StaleElementReferenceException("Exception");
        }catch (StaleElementReferenceException e)
        {
            System.err.println(e.getMessage());
        }
        return null;
    }
}
