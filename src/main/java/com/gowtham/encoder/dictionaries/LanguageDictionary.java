package com.gowtham.encoder.dictionaries;

import java.util.List;

/**
 * Interface for different country dictionaries .
 */
public interface LanguageDictionary{

    void load(String dictonaryReader);

    List<String> getDictionaryStore();

}
