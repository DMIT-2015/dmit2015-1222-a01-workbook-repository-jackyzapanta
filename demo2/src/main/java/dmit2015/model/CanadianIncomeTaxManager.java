package dmit2015.model;

import lombok.Getter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
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
            try (var reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("data/CanadianPersonalIncomeTaxRates.csv")))) {
               //skip the first line
                reader.readLine();
                String line;
                incomeTaxRates = new ArrayList<>();
                while ((line = reader.readLine()) != null) {
                    System.out.println();
                    var optionalCanadianIncomeTaxRate = CanadianPersonalIncomeTaxRate.parseCSV(line);
                    if (optionalCanadianIncomeTaxRate.isPresent()) {
                        CanadianPersonalIncomeTaxRate currentCanadianPersonalIncomeTaxRate = optionalCanadianIncomeTaxRate.orElseThrow();
                        incomeTaxRates.add(currentCanadianPersonalIncomeTaxRate);
                    }
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
//        return incomeTaxRates;
    }

}
