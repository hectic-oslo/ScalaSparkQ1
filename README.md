# Ques1SparkAssignment

## Overview
This Scala application reads an export data CSV file and prints the commodity that India exported the most in a given year. The application takes the year and country as input parameters and processes the data using Apache Spark to provide the result.

## Features
- Reads and processes CSV data using Apache Spark.
- Filters the data based on user-provided year and country inputs.
- Aggregates the export values and identifies the most exported commodity for the given inputs.
- Handles exceptions and validates user input for robustness.

## Requirements
- Apache Spark
- Scala
- Java Development Kit (JDK)
- sbt (Scala Build Tool)
- CSV data file (`2018-2010_export.csv`)

## Installation and Setup
1. **Clone the repository**:
   ```bash
   git clone https://github.com/hectic-oslo/ScalaSparkQ1.git
   cd ScalaSparkQ1
