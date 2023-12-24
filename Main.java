import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    private static final String fileName = "toy.txt";

    public static void main(String[] args){
        try {
            Toy_Shop shop = new Toy_Shop();
            File toyFile = new File(fileName);

            if (!toyFile.exists()){
                toyFile.createNewFile();
                shop.add(new Toy(1, "Motic Yamaha", 5, 20));
                shop.add(new Toy(2, "Robots Transfomers", 3, 15));
                shop.add(new Toy(3, "Cars Mustang", 10, 10));
                shop.saveToFile(fileName);
            } else {
                shop.loadFromFile(fileName);
            }
            shop.setWeight(1,30); // меняем вес Motic-a на 30% //
            ArrayList<String> toyList = shop.getToyList();    // получаем список игрушек  //
            for (String toy : toyList){
                System.out.println(toy);
            }

            ArrayList<Toy> winners = shop.Game_play(3);     // разыгрыш трех игрушек //
            System.out.println("Выигрыш игрушек: ");
            for (Toy t : winners){
                System.out.println(t.getName_toy());
            }

            shop.saveToFile(fileName);     // сохранение данных игрушек //

        } catch (IOException e){
            System.out.println("Ошибка при работе с файлом: " + e.getMessage());
        }
    }

}
