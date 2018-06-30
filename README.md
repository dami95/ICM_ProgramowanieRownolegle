# PCJ

## Tested using:
- MacOS 10.13.5 (17F77)
- MacBook Pro 13' 2017 - 2,3 GHz Intel Core i5 (2 cores, 4 threads) - 16 GB 2133 MHz LPDDR3
- java 9.0.4
- IntelliJ IDEA 2017.3.4
- PCJ-5.0.6 (http://pcj.icm.edu.pl/)
- Source code: src/MonteCarloPCJ.java

## Results:
- Saved in results/results_pcj.csv
- Tested with different sets of iterations (nAll variable)
- Tested with different numbers of threads (no of lines in nodes.txt)

# Spark

## Tested using:
- MacOS 10.13.5 (17F77)
- MacBook Pro 13' 2017 - 2,3 GHz Intel Core i5 (2 cores, 4 threads) - 16 GB 2133 MHz LPDDR3
- Java 1.8.0_171
- Scala 2.12.6 (http://sourabhbajaj.com/mac-setup/Scala/README.html)
- Spark 2.3.1 (https://spark.apache.org/downloads.html)
- Source code: src/spark.sc

## Results:
- Saved in results_spark.csv
- Tested with different sets of iterations (NUM_SAMPLES variable)
- Not tested with different numbers of threads (because of problem with settings)

# PCJ vs Spark
- Code in Scala (Spark) is more readable than in Java (PCJ)
- Code in Scala (Spark) is easier and faster to write than in Java (PCJ)
- Parameters about cores in Spark does not work (https://spoddutur.github.io/spark-notes/distribution_of_executors_cores_and_memory_for_spark_application.html)
- Spark (with Scala) is at least 2 times slower than PCJ version (up to 5-6 times with 2 billions iterations)
- Running code in Spark with different parameters in parallelize() method should optimize execution time
- Spark is typical "black-box" technology, developer does not care about writing too much code and how it works inside
- Chart results/results.png show us that, Spark version of this program is slower in every case than 1 thread program in pure Java (using PCJ)   