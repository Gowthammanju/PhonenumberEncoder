package com.gowtham.encoder.dictionaries;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * German dictionary implementation.
 */
public class GermanDictionary implements LanguageDictionary{

    // Number of words in the dictionary: 75000 maximum
    public static final int MAX_LIST_SIZE = 75000;

    // Length of the individual words in the dictionary: 50 characters maximum.
    public static final int MAX_WORD_LENGTH = 50;

    protected final List<String> dictionaryList = new ArrayList<>();

    @Override
    public void load(String dictonaryFilePath) {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(dictonaryFilePath))) {

            String word;
            while ((word = br.readLine()) != null) {
                if (dictionaryList.size() > MAX_LIST_SIZE) {
                    System.out.println("The word characters exceeds the maximum allowed word ");
                    System.exit(1);
                }

                if (word.length() > MAX_WORD_LENGTH) {
                    System.out.println("The word line exceeds the maximum allowed dictionaries size");
                    System.exit(1);

                }
                dictionaryList.add(word);

            }
            dictionaryList.sort((s1, s2) -> s1.replaceAll("\"", "").compareTo(s2.replaceAll("\"", "")));
        } catch (IOException e) {
            System.out.println("Exception while parsing Dictionary file :" + e);
        }
    }

    @Override
    public List<String> getDictionaryStore() {
//        System.out.println(dictionaryList);
        return dictionaryList;
    }

}
