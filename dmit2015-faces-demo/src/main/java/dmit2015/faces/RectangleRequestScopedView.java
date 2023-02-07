package dmit2015.faces;

import dmit2015.model.Rectangle;
import lombok.Getter;
import lombok.Setter;
import org.omnifaces.util.Messages;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.annotation.PostConstruct;

@Named("currentRectangleRequestScopedView")
@RequestScoped  // create this object for one HTTP request and destroy after the HTTP response has been sent
public class RectangleRequestScopedView {

    // Delcare read/write properties (field + getter + setter) for each form field

    // Declare read only properties (field + getter) for data sources

    // Declare private fields for internal usage only objects
    @Getter @Setter
    private Rectangle currentRectangle = new Rectangle();

    @PostConstruct // This method is executed after DI is completed (fields with @Inject now have values)
    public void init() { // Use this method to initialized fields instead of a constructor
        // Code to access fields annotated with @Inject

    }

    public void onClear() {
        // Set all fields to default values
    }

    public String calculateArea() {
        Messages.addGlobalInfo("Area is {0}", currentRectangle.area());
        return null;
    }

    public String calculatePerimeter() {
        Messages.addGlobalInfo("Perimeter is {0}", currentRectangle.perimeter());
        return null;
    }

    public String calculateDiagonal() {
        Messages.addGlobalInfo("Diagonal is {0}", currentRectangle.diagonal());
        return null;
    }

}