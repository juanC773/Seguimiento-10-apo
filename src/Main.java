import model.Country;
import model.CountryList;
import model.Controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException {



        CountryList countryList = new CountryList();
        Controller controller=new Controller();
        countryList.load();


        Scanner lector = new Scanner(System.in);


        while (true) {




            System.out.println(
                    """
                                                        
                            Olympic Games Paris 2024
                            1. Enter a country 
                            2. Show medals 
                            3. Show total medals 
                            4. Show countries 
                            5. Save changes.
                            6. Exit
                            """
            );


            int option = Integer.parseInt(lector.nextLine());


            switch (option) {

                case 1:

                    System.out.println("Type the entry in the format Country++Medal type++Number of medals");
                    String input = lector.nextLine();
                    String[] data = input.split("::");






                     if (countryList.getCountries().size()>0) {
                         boolean countryExist = controller.countryExist(data[0],data[1],Integer.parseInt(data[2]));

                         if (countryExist==false) {

                             countryList.getCountries().add(new Country(data[0], data[1], Integer.parseInt(data[2])));

                         }
                     }
                     else {
                            //Solo se usa con el primer pais ya que luego size sera >0

                            countryList.getCountries().add(new Country(data[0], data[1], Integer.parseInt(data[2])));
                        }

                        break;

                        case 2:
                            System.out.println("------------SocreBoard----------\n");
                            Collections.sort(countryList.getCountries());
                            countryList.show();
                            break;

                        case 3:
                            System.out.println("------------ScoreBoard-------------\n");
                            Collections.sort(countryList.getCountries(), (a, b) -> {
                                return b.totalMedals() - a.totalMedals();

                            });
                            countryList.showTotalMedals();
                            break;
                        case 4:
                            System.out.println("The countries are:\n");
                              controller.bubbleSort(countryList.getCountries());
                              countryList.show();

                            break;
                        case 5:
                            countryList.save();
                            break;
                        case 6:
                            System.exit(0);
                            break;


                    }
            }

        }















    }



