package com.company.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberUtils {

    private static Logger log = LogManager.getLogger(NumberUtils.class);

    private static final String NUMBER_EXTRACTOR_REGEX = "[^0-9-,\\.]*([0-9-,\\.]*).*";
    private static final Pattern PATTERN = Pattern.compile(NUMBER_EXTRACTOR_REGEX);

    public static double getNumber(Object o) {
        if(o==null){
            log.warn("Tried to extract a number from a null object. Returned 0");
            return 0;
        }
        if(o instanceof Number) { //includes Double, Long, BigDecimal etc.
            Number n = (Number) o ;
            return n.doubleValue();
        }
        if(o instanceof String){
            String passedNumberString = (String) o;
            Matcher matcher = PATTERN.matcher(passedNumberString);

            boolean matches = matcher.matches();
            if(matches) {
                log.warn("String " + passedNumberString + " didnt match the regex. Check the code");
                return 0;
            }
            String s = matcher.group(1);
            String numberToProceedWith = s.replaceAll(",","");

            if(StringUtils.isNullEmptyOrWhiteSpace(numberToProceedWith)){
                log.warn("Value " + passedNumberString + " does not contain a number. Return 0");
                return 0;
            }

            try{
                double d = Double.parseDouble(numberToProceedWith);
                return d;
            }catch (NumberFormatException nfe){
                log.warn("Could not parse number " + numberToProceedWith +
                        " to extract numeric value Return 0");
                return 0;
            }
        }
        log.warn("Unknown object type " + o.getClass().getName() +
                " while trying to extracting a number. Return 0");
        return 0;
    }

    /**
     * Remove non digits and drop last 2 numerics
     * Ex: "USD 100.00" -> 100
     * @param money
     * @return
     */
    public static int convertMoney(String money){
        String stringNewMoney = "";
        for (char c : money.toCharArray())
            if(Character.isDigit(c))
                stringNewMoney+=c;
        return Integer.parseInt(stringNewMoney.substring(0,stringNewMoney.length()-2));
    }

}
