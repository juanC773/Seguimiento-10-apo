package model;

import java.util.ArrayList;

public class Country  implements Comparable<Country>{

    private String name;

   private TypeMedal typeMedal;

   private int quantityGoldMedal;

    private int quantitySilverMedal;

    private int quantityBronzeMedal;



    public Country(String name, String typeMedal,int quantityToAdd) {
        this.name = name;

        if(typeMedal.equalsIgnoreCase("gold")){

            this.typeMedal=TypeMedal.gold;
            this.quantityGoldMedal=quantityToAdd;

        } else if (typeMedal.equalsIgnoreCase("silver")) {

            this.typeMedal=TypeMedal.silver;
            this.quantitySilverMedal=quantityToAdd;
        } else if (typeMedal.equalsIgnoreCase("bronze")) {

            this.typeMedal=TypeMedal.bronze;
            this.quantityBronzeMedal=quantityToAdd;

        }
    }

    public void quantityToAddIfTheCountryAlreadyExist(String typeOfMedal,int quantity){
        System.out.println("Modifica medallas");

        if(typeOfMedal.equalsIgnoreCase("gold")){
            System.out.println("modica 1");
            setQuantityGoldMedal(getQuantityGoldMedal()+quantity);

        } else if (typeOfMedal.equalsIgnoreCase("silver")){
            System.out.println("modica 2");

            setQuantitySilverMedal(getQuantitySilverMedal()+quantity);

        } else if (typeOfMedal.equalsIgnoreCase("bronze")) {
            System.out.println("modica 3");
            setQuantityBronzeMedal(getQuantityBronzeMedal()+quantity);


        }

    }

    public int totalMedals(){

        return  quantityGoldMedal+quantityBronzeMedal+quantitySilverMedal;

    }

    public TypeMedal getTypeMedal() {
        return typeMedal;
    }

    public void setTypeMedal(TypeMedal typeMedal) {
        this.typeMedal = typeMedal;
    }

    public int getQuantityGoldMedal() {
        return quantityGoldMedal;
    }

    public void setQuantityGoldMedal(int quantityGoldMedal) {
        this.quantityGoldMedal = quantityGoldMedal;
    }

    public int getQuantitySilverMedal() {
        return quantitySilverMedal;
    }

    public void setQuantitySilverMedal(int quantitySilverMedal) {
        this.quantitySilverMedal = quantitySilverMedal;
    }

    public int getQuantityBronzeMedal() {
        return quantityBronzeMedal;
    }

    public void setQuantityBronzeMedal(int quantityBronzeMedal) {
        this.quantityBronzeMedal = quantityBronzeMedal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




    public int compareTo(Country o) {
        int criteria1 = o.quantityGoldMedal - this.quantityGoldMedal; // Ordenar por cantidad de medallas de oro en orden descendente

        if (criteria1 != 0) {
            return criteria1;

        }else {
            int criterial2= o.quantitySilverMedal-this.quantitySilverMedal;

            if(criterial2!=0){
                return criterial2;
            }else {
                int criterial3=o.quantityBronzeMedal-this.quantityBronzeMedal;
                if(criterial3!=0){
                    return criterial3;
                }else {

                    return this.name.compareTo(o.name);
                }

            }


        }




    }




}
