package com.gowtham.encoder.number;

import com.gowtham.encoder.dao.EncodedNumber;
import com.gowtham.encoder.mapping.WordMapping;

import java.util.*;

public final class PhoneNumberEncoder implements NumberEncoder{

    private WordMapping numberToWordMap;

    public PhoneNumberEncoder(WordMapping numberToWordMap) {
       
        this.numberToWordMap = numberToWordMap;
    }

    @Override
    public Collection<EncodedNumber> encode(String number) {
        final String onlyDigits = number.replaceAll("[^0-9]+", "");
        Collection<EncodedNumber> encodedNumbersList = new ArrayList<>();
        System.out.println("checking number  " + onlyDigits);
        final List<String> encodedNumberStrings = Collections.unmodifiableList((List<String>) encodeNumber(onlyDigits, 0, false));
        System.out.println("encodedNumberStrings  " + encodedNumberStrings);
        for (Iterator<String> i = encodedNumberStrings.iterator(); i.hasNext();) {
            final String encodedNumberString = i.next();
            final EncodedNumber encodedNumber = new EncodedNumber(number, encodedNumberString);
            encodedNumbersList.add(encodedNumber);
            System.out.println(encodedNumber.toString());
        }
        return encodedNumbersList;
    }

    private Collection<String> encodeNumber(final String number, final int startIndex, final boolean isLeftDigit) {
        Collection<String> encodedNumbers = new ArrayList<>();
        for (int currentIndex = startIndex; currentIndex < number.length(); currentIndex++) {
            // System.out.println("startIndex " + startIndex + " currentindex " + currentIndex + 1);
            final String currentNumber = number.substring(startIndex, currentIndex + 1);
            System.out.println("current iterating number  " + currentNumber);
            final List<String> words = Collections.unmodifiableList((List<String>) numberToWordMap.getWords(currentNumber));
            // System.out.println("currentIndex " + currentIndex + "current no " + currentNumber + " " +
            // words.toString());

            System.out.println("retrieve words   " + words);
            final boolean isCurrentDigit = (currentNumber.length() == 1);
            final boolean isCurrentLastDigit = (currentIndex == number.length() - 1);
            final Collection<String> partlyEncodedNumbers;
            if (!isCurrentLastDigit) {
                System.out.println("&&&&&&&&&&&&&&& not last digit   "+ words );
                if (!words.isEmpty()) {
                    String nextNumber = number.substring(currentIndex + 1);
                    partlyEncodedNumbers = encodeNumber(nextNumber, 0, false);
                     System.out.println("nextNumber " + nextNumber);
                    for (String word : words) {
                        if (partlyEncodedNumbers.isEmpty() && isCurrentDigit) {
                            encodedNumbers.add(word);
                        } else if (!partlyEncodedNumbers.isEmpty()) {
                            encodedNumbers.addAll(buildEncodedNumberStrings(word, partlyEncodedNumbers));
                        }
                    }
                } 
//                else if (!isLeftDigit && isCurrentDigit && !findWord(number)) {
//                    System.out.println("%%%%%%%%%%%%%%%%%%%%% last digit   " );
//                    partlyEncodedNumbers = encodeNumber(number.substring(currentIndex + 1), 0, true);
//                    // System.out.println("@@@@@@@@@@@@@@@@ partlyEncodedNumbers " + partlyEncodedNumbers);
//                    if (!partlyEncodedNumbers.isEmpty()) {
//                        encodedNumbers.addAll(buildEncodedNumberStrings(currentNumber, partlyEncodedNumbers));
//                    }
//                }

            } else if (words.isEmpty() && !isLeftDigit && isCurrentDigit) {
                encodedNumbers.add(currentNumber);
            } else if (!words.isEmpty()) {
                for (String word : words) {
                    encodedNumbers.add(word);
                }
            }
        }
        // System.out.println("encodedNumbers " + encodedNumbers);
        validateAndRemove(encodedNumbers, number);
        return encodedNumbers;
    }

    static Collection<String> buildEncodedNumberStrings(final String root, final Collection<String> partlyEncoded) {
        final Collection<String> encodedNumberStrings = new ArrayList<>();
        System.out.println("@@@@@@@@@@@@@@@@ partlyEncoded " + partlyEncoded);
        partlyEncoded.forEach(encode -> {
            StringBuilder encodedNumberBuilder = new StringBuilder();
            encodedNumberBuilder.append(root).append(" ").append(encode);
            encodedNumberStrings.add(encodedNumberBuilder.toString());
        });
       
        return encodedNumberStrings;
    }

    boolean findWord(final String number) {
        final int numberLength = number.length();
        for (int currentIndex = 0; currentIndex < numberLength; currentIndex++) {
            final int endIndex = numberLength - currentIndex;
            if (numberToWordMap.getWords(number.substring(0, endIndex)).size() > 0) {
                if (endIndex == numberLength || !encodeNumber(number.substring(endIndex), 0, false).isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    void validateAndRemove(Collection<String> encodedNumbers, String number) {
        if (encodedNumbers != null) {
            for (Iterator<String> it = encodedNumbers.iterator(); it.hasNext();) {
                final String encodedNumber = it.next();
                final String onlyLettersAndDigits = encodedNumber.replaceAll("[^a-zA-Z0-9]+", "");
                if (onlyLettersAndDigits.length() != number.length()) {
                    it.remove();
                }
            }
        }
    }

}
