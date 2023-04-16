package model;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class CountryList {

    static String folder = "data";
    static String path = "data/data.txt";

    ArrayList<Country> countries;

    public CountryList() {
        countries = new ArrayList<>();
    }

    public ArrayList<Country> getCountries() {
        return countries ;
    }

    public void setStudents(ArrayList<Country> countries) {
        this.countries = countries;
    }

    public void save() throws IOException {
        File file = new File(path);
        FileOutputStream fos = new FileOutputStream(file);

        Gson gson= new Gson();
        String data= gson.toJson(countries);


        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
        writer.write(data);
        writer.flush();
        fos.close();
    }



    public void load() throws IOException {
        File file = new File(path);
        if (file.exists()) {
            FileInputStream fis = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            String content = "";
            String line = "";




            while ((line = reader.readLine()) != null) {
                content += line + "\n";
            }

            System.out.println(content);

            Gson gson=new Gson();

            Country [] array= gson.fromJson(content, Country[].class);
            countries.addAll(Arrays.asList(array));


            fis.close();
        }else{
            File f = new File(folder);
            if(!f.exists()){
                f.mkdirs();
            }
            file.createNewFile();
        }
    }

    public void show() {
        for (Country s :countries) {
            System.out.println("Country Name: "+s.getName()+", Quantity of gold medals: "+s.getQuantityGoldMedal()+", Quantity of silver medals: "+s.getQuantitySilverMedal()+", quantity of bronze medals: "+s.getQuantityBronzeMedal());
        }
    }

    public void showTotalMedals(){
        for (Country s :countries) {
            System.out.println("Country Name: "+s.getName()+", Quantity of total medals: "+s.totalMedals());
        }

    }



}