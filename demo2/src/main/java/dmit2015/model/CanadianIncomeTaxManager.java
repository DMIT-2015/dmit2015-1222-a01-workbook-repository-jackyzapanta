package dmit2015.model;

import lombok.Getter;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CanadianIncomeTaxManager {

    //define private constructor to implement Singleton
    private CanadianIncomeTaxManager() {

    }
    //define a single instance of this class
    private static CanadianIncomeTaxManager INSTANCE;

    //define a static class-level to access the singleton
    public static CanadianIncomeTaxManager getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new CanadianIncomeTaxManager();
        }
        return INSTANCE;
    }

    @Getter
    private List<CanadianPersonalIncomeTaxRate> incomeTaxRates;

    public void loadDataFromFile() {
        try {
            Path csvPath = Path.of(getClass().getClassLoader().getResource("data/CanadianPersonalIncomeTaxRates.csv").toURI());
//            incomeTaxRates = Files.readAllLines(csvPath);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
//        return incomeTaxRates;
    }

}
