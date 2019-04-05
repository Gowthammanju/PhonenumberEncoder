package com.gowtham.encoder.mapping;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Interface for different implementations of the WordMapping.
 */
public interface WordMapping{

    Map<Integer, Set<String>> DIGIT_TO_LETTER_MAP = Collections.unmodifiableMap(new HashMap<Integer, Set<String>>() {

        private static final long serialVersionUID = 8332794045317975673L;

        {
            // 0
            put(0, Collections.unmodifiableSet(new HashSet<String>(Arrays.asList("E"))));
            // 1
            put(1, Collections.unmodifiableSet(new HashSet<String>(Arrays.asList("J", "N", "Q"))));
            // 2
            put(2, Collections.unmodifiableSet(new HashSet<String>(Arrays.asList("R", "W", "X"))));
            // 3
            put(3, Collections.unmodifiableSet(new HashSet<String>(Arrays.asList("D", "S", "Y"))));
            // 4
            put(4, Collections.unmodifiableSet(new HashSet<String>(Arrays.asList("F", "T"))));
            // 5
            put(5, Collections.unmodifiableSet(new HashSet<String>(Arrays.asList("A", "M"))));
            // 6
            put(6, Collections.unmodifiableSet(new HashSet<String>(Arrays.asList("C", "I", "V"))));
            // 7
            put(7, Collections.unmodifiableSet(new HashSet<String>(Arrays.asList("B", "K", "U"))));
            // 8
            put(8, Collections.unmodifiableSet(new HashSet<String>(Arrays.asList("L", "O", "P"))));
            // 9
            put(9, Collections.unmodifiableSet(new HashSet<String>(Arrays.asList("G", "H", "Z"))));
        }
    });

    Map<String, Collection<String>> mapWords(Collection<String> words);

    Collection<String> getWords(String number);

}
