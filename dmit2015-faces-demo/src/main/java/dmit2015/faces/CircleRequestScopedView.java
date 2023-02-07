package dmit2015.faces;

import dmit2015.model.Circle;
import lombok.Getter;
import lombok.Setter;
import org.omnifaces.util.Messages;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.annotation.PostConstruct;

@Named("currentCircleRequestScopedView")
@RequestScoped  // create this object for one HTTP request and destroy after the HTTP response has been sent
public class CircleRequestScopedView {

    // Delcare read/write properties (field + getter + setter) for each form field

    // Declare read only properties (field + getter) for data sources

    // Declare private fields for internal usage only objects
    @Getter @Setter
    private double radius;


    @PostConstruct // This method is executed after DI is completed (fields with @Inject now have values)
    public void init() { // Use this method to initialized fields instead of a constructor
        // Code to access fields annotated with @Inject

    }

    public void onClear() {
        // Set all fields to default values
    }

    public String calculateArea() {
        var currentCircle = new Circle(radius);
        Messages.addGlobalInfo("Area = {0}", currentCircle.area());
        return null;
    }

    public String calculateDiameter() {
        var currentCircle = new Circle(radius);
        Messages.addGlobalInfo("Diameter = {0}", currentCircle.diameter());
        return null;
    }

    public String calculateCircumference() {
        var currentCircle = new Circle(radius);
        Messages.addGlobalInfo("Circumference = {0}", currentCircle.circumference());
        return null;
    }

}