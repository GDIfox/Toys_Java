import com.sun.source.tree.BreakTree;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Toy_Shop {
    private ArrayList<Toy> toys;

    public Toy_Shop(){
        toys = new ArrayList<>();
    }

    public void add(Toy toy){          // добавление игрушек //
        boolean foundToy = false;
        for (Toy t : toys){
            if(t.getId() == toy.getId()){
                t.setQuantity(t.getQuantity() + toy.getQuantity());
                foundToy = true;
                break;
            }
        }
        if (!foundToy){
            toys.add(toy);
        }
    }


    public  void setWeight(int toyId, double weight){    // изменение веса игрушки //
        for (Toy t : toys){
            if (t.getId() == toyId){
                t.setWeight(weight);
                break;
            }
        }
    }

    public ArrayList<String> getToyList(){     // полечение списка игрушек с id... //
        ArrayList<String> toyList = new ArrayList<>();
        for (Toy t : toys){
            toyList.add("ID: " + t.getId() + "Название: " + t.getName_toy() +
                    "Количество: " + t.getQuantity() + "Вес: " + t.getWeight());
        }
        return toyList;
    }

    public ArrayList<Toy> Game_play(int count){            // розыгрыш //
        ArrayList<Toy> winners = new ArrayList<>();
        double weightSum = 0;
        for (Toy t : toys){
            weightSum += t.getWeight();
        }

        Random random = new Random();
        for (int i = 0; i < count; i++){
            double randomNumber = random.nextDouble() * weightSum;
            double currentSum = 0;

            for (Toy t : toys){
                currentSum += t.getWeight();
                if (currentSum >= randomNumber){
                    if (t.getQuantity() > 0){
                        winners.add(t);
                        t.setQuantity(t.getQuantity() - 1);
                        weightSum -= t.getWeight();
                    }
                    break;
                }
            }
        }
        return winners;
    }

    public void saveToFile(String fileName) throws IOException{            // сохраняем данные по игрушкам в файл //
        try (FileWriter writer = new FileWriter(new File(fileName))){
            for (Toy t : toys){
                writer.write(t.getId() + "," + t.getName_toy() + "," +
                        t.getQuantity() + "," + t.getWeight() + "n");
            }
        }
    }

    public void loadFromFile(String fileName) throws IOException{            // загрузка данных по игрушкам //
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)))){
            String line;
            while ((line = reader.readLine()) != null){
                String[] toyData = line.split(",");
                Toy toy = new Toy(Integer.parseInt(toyData[0]), toyData[1],
                        Integer.parseInt(toyData[2]), Double.parseDouble(toyData[3]));
                toys.add(toy);
            }
        }
    }
}
