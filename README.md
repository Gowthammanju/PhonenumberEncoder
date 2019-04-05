# PhonenumberEncoder
Phonenumber Encoder


1)Building the application

``` 
[gowtham@TUX0028 encoder]$ mvn clean install
[INFO] Scanning for projects...
[WARNING] 
[WARNING] Some problems were encountered while building the effective model for com.gowtham:encoder:jar:1.0-SNAPSHOT
[WARNING] 'build.plugins.plugin.version' for org.apache.maven.plugins:maven-compiler-plugin is missing. @ line 41, column 12
[WARNING] 'build.plugins.plugin.version' for org.apache.maven.plugins:maven-jar-plugin is missing. @ line 48, column 12
[WARNING] 
[WARNING] It is highly recommended to fix these problems because they threaten the stability of your build.
[WARNING] 
[WARNING] For this reason, future Maven versions might no longer support building such malformed projects.
[WARNING] 
[INFO] 
[INFO] ------------------------< com.gowtham:encoder >-------------------------
[INFO] Building encoder 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ encoder ---
[INFO] Deleting /home/gowtham/codebase/number-encoder/encoder/target
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ encoder ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /home/gowtham/codebase/number-encoder/encoder/src/main/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ encoder ---
[INFO] Changes detected - recompiling the module!
[WARNING] File encoding has not been set, using platform encoding UTF-8, i.e. build is platform dependent!
[INFO] Compiling 8 source files to /home/gowtham/codebase/number-encoder/encoder/target/classes
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ encoder ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] Copying 3 resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ encoder ---
[INFO] Changes detected - recompiling the module!
[WARNING] File encoding has not been set, using platform encoding UTF-8, i.e. build is platform dependent!
[INFO] Compiling 1 source file to /home/gowtham/codebase/number-encoder/encoder/target/test-classes
[INFO] 
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ encoder ---
[INFO] Surefire report directory: /home/gowtham/codebase/number-encoder/encoder/target/surefire-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running com.gowtham.encoder.EncodeTest
Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 2.371 sec

Results :

Tests run: 3, Failures: 0, Errors: 0, Skipped: 0

[INFO] 
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ encoder ---
[INFO] Building jar: /home/gowtham/codebase/number-encoder/encoder/target/encoder-1.0-SNAPSHOT.jar
[INFO] 
[INFO] --- maven-install-plugin:2.4:install (default-install) @ encoder ---
[INFO] Installing /home/gowtham/codebase/number-encoder/encoder/target/encoder-1.0-SNAPSHOT.jar to /home/gowtham/.m2/repository/com/gowtham/encoder/1.0-SNAPSHOT/encoder-1.0-SNAPSHOT.jar
[INFO] Installing /home/gowtham/codebase/number-encoder/encoder/pom.xml to /home/gowtham/.m2/repository/com/gowtham/encoder/1.0-SNAPSHOT/encoder-1.0-SNAPSHOT.pom
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 4.439 s
[INFO] Finished at: 2019-03-08T11:15:04+01:00
[INFO] ------------------------------------------------------------------------
[gowtham@TUX0028 encoder]$ 
```

2)Running the application

```
[gowtham@TUX0028 encoder]$ java -jar target/encoder-1.0-SNAPSHOT.jar
Enter the Dictonary Path: 
/home/gowtham/Documents/numberencoding/dictionary.txt
Enter the input file: 
/home/gowtham/Documents/numberencoding/input.txt
number '5624-82' encoded to 'Mix Tor'
number '5624-82' encoded to 'mir Tor'
number '4824' encoded to 'Tor 4'
number '4824' encoded to 'Torf'
number '4824' encoded to 'fort'
number '10/783--5' encoded to 'je Bo" da'
number '10/783--5' encoded to 'je Boy 5'
number '10/783--5' encoded to 'je bo"s 5'
number '10/783--5' encoded to 'neu o"d 5'
number '381482' encoded to 'so 1 Tor'
number '381482' encoded to 'Don Tor'
number '04824' encoded to '0 Tor 4'
number '04824' encoded to '0 Torf'
number '04824' encoded to '0 fort'
[gowtham@TUX0028 encoder]$ 

```


# Written three testcases :

1) With the minimum input file (given in task description)
2) With the large input file (exaple file given in task description)
3) With the large input file with performance testcases
4) Dictionary file not present



Note : you can check the performance report in "target/contiperf" directory


