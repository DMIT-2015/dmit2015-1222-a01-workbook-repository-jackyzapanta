package dmit2015.model;

import lombok.Data;

import javax.swing.plaf.synth.Region;
import java.math.BigDecimal;
import java.time.Year;
import java.util.Optional;

@Data
public class CanadianPersonalIncomeTaxRate {
    private String regionAbbreviation;
    private String regionName;
    private int taxYear;
    private int bracketNo;

    //    private BigDecimal startingIncome;
    private double startingIncome;

    //    private BigDecimal startingIncome;
    private Double endingIncome;
    private double taxRate;
    private double baseTax;
//    private double roundedBase;
//    private double taxAmount;

    public static Optional<CanadianPersonalIncomeTaxRate> parseCSV(String line) {
        Optional<CanadianPersonalIncomeTaxRate> optionalCanadianPersonalIncomeTaxRate = Optional.empty();
        final String DELIMETER = ",";
        /*
            The order of columns
            0) Region Abbreviation
            1) Region Name
            2) Tax Year
            3) BracketNo
            4) Starting Income
            5) Ending Income
            6) Tax Rate
            7) Base Tax Amount
            8) Rounded Base
            9) Tax Amount
         */
        String[] tokens = line.split(line);
        if (tokens.length != 9) {
            throw new RuntimeException("Line does not contain exactly 9 values");
        }
        String regionAbbreviation = tokens[0];
        String regionName = tokens[1];
        int taxYear = Integer.parseInt(tokens[2]);
        int bracketNo = Integer.parseInt(tokens[3]);
        double startingIncome = Double.parseDouble(tokens[4]);
//      Double endingIncome = tokens[5].isBlank() ? null : Double.valueOf(tokens[5]);
        Double endingIncome = tokens[5].isBlank() ? Integer.MAX_VALUE : Double.valueOf(tokens[5]);
        double taxRate = Double.parseDouble(tokens[6]);
        double baseTax = Double.parseDouble(tokens[7]);

        //instantiate and set using the setter set*
        CanadianPersonalIncomeTaxRate currentIncomeTaxRate = new CanadianPersonalIncomeTaxRate();
        currentIncomeTaxRate.setRegionAbbreviation(regionAbbreviation);
        currentIncomeTaxRate.setRegionName(regionName);
        currentIncomeTaxRate.setStartingIncome(startingIncome);
        currentIncomeTaxRate.setEndingIncome(endingIncome);
        currentIncomeTaxRate.setTaxRate(taxRate);
        currentIncomeTaxRate.setTaxYear(taxYear);
        currentIncomeTaxRate.setBracketNo(bracketNo);
        currentIncomeTaxRate.setBaseTax(baseTax);

        optionalCanadianPersonalIncomeTaxRate = Optional.of(currentIncomeTaxRate);

        return optionalCanadianPersonalIncomeTaxRate;
    }
}
