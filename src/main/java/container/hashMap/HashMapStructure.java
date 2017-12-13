package container.hashMap;

import java.util.HashMap;
import java.util.Iterator;

/** 
 * @author  阮航  
 * @date 创建时间：2017年12月6日 下午6:15:35 
 * @version 1.0 
*/
public class HashMapStructure {

	public static void main(String[] args) {
		Country india=new Country("India",1000);
        Country japan=new Country("Japan",10000);
           
        Country france=new Country("France",2000);
        Country russia=new Country("Russia",20000);
           
        HashMap<Country,String> countryCapitalMap=new HashMap<Country,String>();
        countryCapitalMap.put(india,"Delhi");
        countryCapitalMap.put(japan,"Tokyo");
        countryCapitalMap.put(france,"Paris");
//        countryCapitalMap.put(russia,"Moscow");
        countryCapitalMap.put(russia,"Mosco");
           
        Iterator<Country> countryCapitalIter=countryCapitalMap.keySet().iterator();//put debug point at this line
        while(countryCapitalIter.hasNext())
        {
            Country countryObj=countryCapitalIter.next();
            String capital=countryCapitalMap.get(countryObj);
            System.out.println(countryObj.getName()+"----"+capital);
            }
        }
	}

