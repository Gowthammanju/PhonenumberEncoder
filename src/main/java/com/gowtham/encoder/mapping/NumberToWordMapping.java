package com.gowtham.encoder.mapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class NumberToWordMapping implements WordMapping{

    private final Map<String, Collection<String>> numberToWordMap = new HashMap<>();

    @Override
    public Map<String, Collection<String>> mapWords(final Collection<String> words) {
        for (final String word : words) {
            final String wordAsASCIILetters = word.replaceAll("[^a-zA-Z]+", "");
//            System.out.println("@@@@@@@@@@@@@@@@ wordAsASCIILetters" + wordAsASCIILetters);
            final StringBuilder numberBuilder = new StringBuilder();
            for (int i = 0; i < wordAsASCIILetters.length(); i++) {
                final String ss = String.valueOf(wordAsASCIILetters.charAt(i)).toUpperCase();
                // System.out.println("@@@@@@@@@@@@@@@@ ss" +ss);
                DIGIT_TO_LETTER_MAP.forEach((k, v) -> {
                    if (v.contains(String.valueOf(ss))) {
//                        System.out.println("======================= key " + k);
                        numberBuilder.append(k);
                    }
                });

            }
            final String number = numberBuilder.toString();
            // System.out.println("@@@@@@@@@@@@@@@@ number" + number + " word " + word);
            if (numberToWordMap.get(number) == null) {
                numberToWordMap.put(number, new ArrayList<String>(Arrays.asList(word)));
            } else {
                numberToWordMap.get(number).add(word);
            }
        }
        
        System.out.println("current iterating number  "+numberToWordMap);

        return numberToWordMap;
    }

    public Map<String, Collection<String>> getNumberToWordMap() {
        return numberToWordMap;
    }

    @Override
    public Collection<String> getWords(String number) {
        Collection<String> words = this.numberToWordMap.get(number);
//        System.out.println("@@@@@@@@@@@@@@@@ getwords number " + number + " words " + words);
        return (words != null) ? words : new ArrayList<>();
    }
}
