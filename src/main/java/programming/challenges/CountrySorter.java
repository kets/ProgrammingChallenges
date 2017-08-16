package programming.challenges;

import java.io.*;
import java.util.*;
//import org.junit.*;
//import org.junit.runner.*;
//import static org.junit.Assert.assertTrue;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

public class CountrySorter implements ICountrySorter{
    /**
   * Takes a list of available countries and returns a list of its elements re-ordered.  
   * 
   * The new order of the elements is as follows:
   * 
   * First the special countries in their original order from the special countries list.
   * Then the list of available countries, sorted alphabetically by name.
   * 
   * Not all of the special countries may appear in the list of available countries.
   * 
   * Available: United States, Mexico, Canada, Costa Rica, Bermuda, Belgium
   * Special: Canada, Mexico, France, Belgium
   * Result: Canada, Mexico, Belgium, Bermuda, Costa Rica, United States
   */

    public List<Country> sortCountries(List<Country> availableCountries, List<Country> specialCountries) {
       List<Country> resultCountries = new ArrayList<Country>();
      
      if (availableCountries == null) {
        return resultCountries;
      }
      
      //check for null
      if (specialCountries == null) {
        return availableCountries;
        
      }
      //iterate through list of available and check if the special countries are contained in that list
      
       
        for (Country specialCountry: specialCountries) {
            if (availableCountries.contains(specialCountry)) {
              //this country is present in the list of availableCountries, add to resultList
              resultCountries.add(specialCountry);
              
              //remove the special country from the available country list, since we've seen it already
              //and don't want it to appear again
              if (availableCountries.remove(specialCountry)){
                
                //remove successfully
              }
              
              
            }
          
        }
                
                //at this stage, we need to sort the remaining lsit of available countries
                //and add to the resultCountries
              
        Collections.sort(availableCountries);
        resultCountries.addAll(availableCountries);
              
      return resultCountries;
    }
  }

//  /*** TESTS ***/
//  private List<Country> availableCountries;
//  private List<Country> specialCountries;
//
//  private final Country specialA = new Country("Special A");
//  private final Country specialB = new Country("Special B");
//  private final Country specialC = new Country("Special C");
//  private final Country specialD = new Country("Special D");
//  private final Country specialE = new Country("Special E");
//
//  private final Country countryA = new Country("Country A");
//  private final Country countryB = new Country("Country B");
//  private final Country countryC = new Country("Country C");
//  private final Country countryD = new Country("Country D");
//  private final Country countryE = new Country("Country E");
//
//  private final List<Country> nonSpecialCountriesSorted = Arrays.asList(countryA, countryB, countryC, countryD, countryE);
//
//  @Before
//  public void setUp() throws Exception {
//    availableCountries = new ArrayList<Country>();
//
//    availableCountries.add(countryE);
//    availableCountries.add(specialD);
//    availableCountries.add(countryA);
//    availableCountries.add(countryC);
//    availableCountries.add(specialB);
//    availableCountries.add(countryB);
//    availableCountries.add(specialA);
//    availableCountries.add(countryD);
//
//    specialCountries = new ArrayList<Country>();
//    specialCountries.add(specialA);
//    specialCountries.add(specialC);
//    specialCountries.add(specialD);
//    specialCountries.add(specialB);
//    specialCountries.add(specialE);
//  }
//
//  @Test
//  public void testSort() {
//    ICountrySorter countrySorter = sorter();
//
//    List<Country> countries = countrySorter.sortCountries(availableCountries, specialCountries);
//    assertTrue(countries.get(0).getName().equals(specialA.getName()));
//    assertTrue(countries.get(1).getName().equals(specialD.getName())); 
//    assertTrue(countries.get(2).getName().equals(specialB.getName()));
//
//    checkNonSpecialCountries(countries.subList(3, countries.size()));
//  }
//
//  @Test
//  public void testNoSpecialCountries() {
//    ICountrySorter countrySorter = sorter();
//    List<Country> availableCountries = nonSpecialCountriesListReversed();
//
//    List<Country> countries = countrySorter.sortCountries(availableCountries, new ArrayList<Country>());
//    checkNonSpecialCountries(countries);
//
//    countries = countrySorter.sortCountries(availableCountries, null);
//    checkNonSpecialCountries(countries);
//  }
//
//  @Test  
//  public void testNoAvailableCountries() {
//    ICountrySorter countrySorter = sorter();
//    List<Country> countries = countrySorter.sortCountries(new ArrayList<>(), specialCountries);
//    assertTrue(countries == null || countries.size() == 0);
//
//    countries = countrySorter.sortCountries(null, specialCountries);
//    assertTrue(countries == null || countries.size() == 0);
//  }
//
//  private List<Country> nonSpecialCountriesListReversed() {
//    List<Country> reversed = new ArrayList<>(nonSpecialCountriesSorted);
//    Collections.reverse(reversed);
//    return reversed;
//  }
//
//  private void checkNonSpecialCountries(List<Country> nonSpecialCountriesToCheck) {
//    for (int i=0; i < nonSpecialCountriesSorted.size(); i++) {
//      assertTrue(nonSpecialCountriesToCheck.get(i).getName().equals(nonSpecialCountriesSorted.get(i).getName()));
//    }
//  }
//
//  private ICountrySorter sorter() {
//    return new Sorter();
//  }
//  
//  public static void main(String[] args) {
//    JUnitCore.main("Solution");
//  }
//}

