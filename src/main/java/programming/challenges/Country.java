package programming.challenges;

public class Country implements Comparable<Country> {
    private String name;

    public Country(String name) {
      this.name = name;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    @Override
    public String toString() {
      return name;
    }
    
    @Override
    public int compareTo(Country country) {
      return this.getName().compareTo(country.getName());
      
    }
  }
