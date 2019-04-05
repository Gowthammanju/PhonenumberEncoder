package com.gowtham.encoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.gowtham.encoder.dictionaries.GermanDictionary;
import com.gowtham.encoder.dictionaries.LanguageDictionary;
import com.gowtham.encoder.mapping.NumberToWordMapping;
import com.gowtham.encoder.number.NumberEncoder;
import com.gowtham.encoder.number.PhoneNumberEncoder;

public class Encode{

    // Length of the phone numbers: 50 characters maximum.
    private static Pattern phoneNumberPattern = Pattern.compile("^[0-9-/]{1,50}");

    public static void doEncode(String dictionaryFile, String inputFile) {
        LanguageDictionary germanDictionary = new GermanDictionary();
        germanDictionary.load(dictionaryFile);
        NumberToWordMapping phoneNumberToWordMapping = new NumberToWordMapping();
        phoneNumberToWordMapping.mapWords(germanDictionary.getDictionaryStore());
        
//        System.out.println(phoneNumberToWordMapping.getNumberToWordMap().toString());

        NumberEncoder phoneNumberEncoder = new PhoneNumberEncoder(phoneNumberToWordMapping);

        try (BufferedReader br = Files.newBufferedReader(Paths.get(inputFile))) {

            String number;
            while ((number = br.readLine()) != null) {
                Matcher phoneNumberMatcher = phoneNumberPattern.matcher(number);
                if (phoneNumberMatcher.matches()) {
                    phoneNumberEncoder.encode(number);
                }
            }
        } catch (IOException e) {
            System.out.println("Exception while parsing Input file :" + e);
        }

    }

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the Dictonary Path: ");
            String dictonaryFile = "/home/gowtham/Documents/numberencoding/dictionary.txt";
            System.out.println("Enter the input file: ");
            String inputFile = "/home/gowtham/Documents/numberencoding/input.txt";

            doEncode(dictonaryFile, inputFile);
        }

    }
}
