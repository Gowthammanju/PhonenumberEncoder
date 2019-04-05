package com.gowtham.encoder;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class EncodeTest{

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Rule
    public ContiPerfRule rule = new ContiPerfRule();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void testSmallInputFile() {

        Path dictionaryPath = Paths.get("src", "test", "resources", "dictionary.txt");
        Path inputPath = Paths.get("src", "test", "resources", "small_input.txt");

        Encode.doEncode(dictionaryPath.toString(), inputPath.toString());

//        assertThat(outContent.toString(), containsString("number '5624-82' encoded to 'Mix Tor'"));
//        assertThat(outContent.toString(), containsString("number '5624-82' encoded to 'mir Tor'"));
//        assertThat(outContent.toString(), containsString("number '4824' encoded to 'Tor 4'"));
//        assertThat(outContent.toString(), containsString("number '4824' encoded to 'Torf'"));
//        assertThat(outContent.toString(), containsString("number '4824' encoded to 'fort'"));
//        assertThat(outContent.toString(), containsString("number '10/783--5' encoded to 'je Bo\" da'"));
//        assertThat(outContent.toString(), containsString("number '10/783--5' encoded to 'je Boy 5'"));
//        assertThat(outContent.toString(), containsString("number '10/783--5' encoded to 'je bo\"s 5'"));
//        assertThat(outContent.toString(), containsString("number '381482' encoded to 'so 1 Tor'"));
//        assertThat(outContent.toString(), containsString("number '381482' encoded to 'Don Tor'"));
//        assertThat(outContent.toString(), containsString("number '04824' encoded to '0 Tor 4'"));
//        assertThat(outContent.toString(), containsString("number '04824' encoded to '0 Torf'"));
//        assertThat(outContent.toString(), containsString("number '04824' encoded to '0 fort'"));
    }

    @Test
    public void testBigInputFile() {

        Path dictionaryPath = Paths.get("src", "test", "resources", "dictionary.txt");

        Path inputPath = Paths.get("src", "test", "resources", "input.txt");

        Encode.doEncode(dictionaryPath.toString(), inputPath.toString());
        assertThat(outContent.toString(), containsString("number '-885/63538' encoded to 'O\"l Midas 8'"));
        assertThat(outContent.toString(), containsString("number '8-3-079--20358' encoded to 'o\"d 0 Uhr 0 da 8'"));
        assertThat(outContent.toString(),
                containsString("number '-810873502888/74-556227/1' encoded to '8 je lud 5 er O\"l ok 4 Mai 2 Run'"));
    }

    @Test
    @PerfTest(invocations = 10, threads = 100)
    public void testBigInputFilePerformanceTest() {

        Path dictionaryPath = Paths.get("src", "test", "resources", "dictionary.txt");

        Path inputPath = Paths.get("src", "test", "resources", "input.txt");

        Encode.doEncode(dictionaryPath.toString(), inputPath.toString());

        assertThat(outContent.toString(), containsString("number '-885/63538' encoded to 'O\"l Midas 8'"));
        assertThat(outContent.toString(), containsString("number '8-3-079--20358' encoded to 'o\"d 0 Uhr 0 da 8'"));
        assertThat(outContent.toString(),
                containsString("number '-810873502888/74-556227/1' encoded to '8 je lud 5 er O\"l ok 4 Mai 2 Run'"));
    }

    @Test
    public void testInvalidFile() {

        Path dictionaryPath = Paths.get("src", "test", "resources", "nofile.txt");
        Path inputPath = Paths.get("src", "test", "resources", "small_input.txt");

        Encode.doEncode(dictionaryPath.toString(), inputPath.toString());

        assertThat(outContent.toString(), containsString(
                "Exception while parsing Dictionary file :java.nio.file.NoSuchFileException: src/test/resources/nofile.txt\n"));
    }

}
