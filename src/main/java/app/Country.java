package app;

/**
 * Class represeting a Country from the Studio Project database
 *
 * @author Halil Ali, 2024. email: halil.ali@rmit.edu.au
 */

public class Country {
   // country Code
   private String m49Code;

   // country Name
   private String name;

   private double AVGloss_percentage;
   private String year;
   private double similarityPercentage;

   /**
    * Create a Country and set the fields
    */
   public Country(String m49Code, String name) {
      this.m49Code = m49Code;
      this.name = name;
   }

   public Country(String countryName, double AVGloss_percentage, String year, double similarityPercentage) {
      name = countryName;
      this.AVGloss_percentage = AVGloss_percentage;
      this.year = year;
      this.similarityPercentage = similarityPercentage;
   }

   public String getM49Code() {
      return m49Code;
   }

   public String getName() {
      return name;
   }

   public double getLossPercentage() {
      return AVGloss_percentage;
   }

   public String getYear() {
      return year;
   }

   public double getSimilarityPercentage() {
      return similarityPercentage;
   }
}
