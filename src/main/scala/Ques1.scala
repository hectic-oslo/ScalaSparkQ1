import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{col, sum, desc}
import org.apache.log4j.{Level, Logger}



object Ques1 extends App {
  val spark = SparkSession.builder()
    .master("local[*]")
    .appName("Ques1SparkAssignment")
    .config("spark.driver.bindAddress", "127.0.0.1")
    .config("spark.hadoop.hadoop.security.authentication", "simple")
    .getOrCreate()
  Logger.getLogger("org").setLevel(Level.ERROR)
  // Read input for year and country
  val inputYear = args(0)
  val inputCountry = args(1)

  // Validate inputYear
  if (!inputYear.forall(_.isDigit)) {
    println("Invalid year input. Please provide a valid integer year.")
    sys.exit(1)
  }

  try {
    val exportDF = spark.read
      .options(Map("inferSchema" -> "true", "header" -> "true"))
      .csv("src/main/resources/data/2018-2010_export.csv")

    //exportDF.show()
    println(inputCountry, inputYear,inputYear.getClass.getSimpleName,inputCountry.getClass.getSimpleName)

    // Filtering the DataFrame based on input
    //val filteredDF = exportDF.filter(col("country") === inputCountry && col("year").cast("int") === inputYear.toInt)
    val filteredDF = exportDF.filter(col("country").equalTo(inputCountry.toUpperCase) && col("year").cast("int") === inputYear.toInt)

    //filteredDF.show()

    // Grouping and summing without using agg
    filteredDF.groupBy("Commodity")
      .sum("value") // Directly sum the "value" column
      .withColumnRenamed("sum(value)", "Total_Value") // Rename the summed column
      .orderBy(desc("Total_Value")) // Order by Total_Value in descending order
      .limit(1) // Limit to the top result
      .show() // Show the result
  } catch {
    case e: Exception =>
      println(s"Error reading the CSV file: ${e.getMessage}")
      sys.exit(1)
  } finally {
    spark.stop()
  }
}
