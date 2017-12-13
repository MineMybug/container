package container.hashMap;

/**
 * @author 阮航
 * @date 创建时间：2017年12月6日 下午6:13:57
 * @version 1.0
 */
public class Country {

	private String name;
	private long population;

	public Country(String name, long population) {
		super();
		this.name = name;
		this.population = population;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPopulation() {
		return population;
	}

	public void setPopulation(long population) {
		this.population = population;
	}

	// If length of name in country object is even then return 31(any random
	// number) and if odd then return 95(any random number).
	// This is not a good practice to generate hashcode as below method but I am
	// doing so to give better and easy understanding of hashmap.
	@Override
	public int hashCode() {
		if (this.name.length() % 2 == 0)
			return 31;
		else
			return 95;
	}

	@Override
	public boolean equals(Object obj) {

		Country other = (Country) obj;
		if (name.equalsIgnoreCase((other.name)))
			return true;
		return false;
	}
}
