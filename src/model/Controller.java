package model;


import java.io.IOException;
import java.util.ArrayList;

public class Controller {



    public boolean countryExist(String nameCoutry, String typeMedal, int quantityToAdd) throws IOException {


        CountryList countryList=new CountryList();
        countryList.load();


        if(countryList.getCountries().size()>0) {

            for (int i = 0; i < countryList.getCountries().size(); i++) {

                if (countryList.getCountries().get(i).getName().equalsIgnoreCase(nameCoutry)) {

                    countryList.getCountries().get(i).quantityToAddIfTheCountryAlreadyExist(typeMedal.toLowerCase(), quantityToAdd);
                    return true;

                }
            }
        }


            return false;


    }



    public ArrayList<Country> bubbleSort (ArrayList<Country> arr){


        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.size()-1; j++) {
                if (arr.get(j).getName().compareTo(arr.get(j+1).getName())>0 ) {
                    // intercambiar arr[j] y arr[j+1]
                    Country temp = arr.get(j);
                    arr.set(j,arr.get(j+1));
                    arr.set(j+1,temp);
                }
            }
        }


            return arr;

    }

}
