/**
 * Home work seven
 *
 * @author Andrew Shevelev
 * @version Feb, 11 2018
 *
 * @link https://github.com/ShevelevAndrew
 */

/**
 * 1. Расширить задачу про котов и тарелки с едой
 * 2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды
 * (например, в миске 10 еды, а кот пытается покушать 15-20)
 * 3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны).
 * Если коту удалось покушать (хватило еды), сытость = true
 * 4. Считаем, что если коту мало еды в тарелке, то он ее просто не трогает, то есть не может
 * быть наполовину сыт (это сделано для упрощения логики программы)
 * 5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки
 * и потом вывести информацию о сытости котов в консоль
 */

public class HomeWorkSeven {
    public static void main(String[] args) {
        Cat[] cat =new Cat[5];
        cat[0]  = new Cat("Barsik", 10);
        cat[1]  = new Cat("Pushistik", 7);
        cat[2]  = new Cat("Sharik", 12);
        cat[3]  = new Cat("Rijik", 5);
        cat[4]  = new Cat("GavGav", 8);

        Plate plate = new Plate(30);
        System.out.println("Food balance:"+plate);
        for (Cat cats: cat) {

            System.out.println("\nName:" + cats +
                    "\nAppetite:" + cats.appetites() +
                    "\nEating:" + cats.eat(plate) +
                    "\nFood balance:" + plate);
        }

        /**
         *6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку
         */

        System.out.println("\n***Task six***");
        Plate plates =new Plate(30);
        System.out.println("Food balance:"+plates);

        for (Cat cats: cat) {

            if (plates.foods() < cats.appetites() ) {
                System.out.println("\nAdd eat:" + (cats.appetites() - plates.foods()));
                plates.setAddEatPlate(cats.appetites() - plates.foods());
                System.out.println("\nFood balance:"+plates);
            }
            System.out.println("\nName:" + cats +
                    "\nAppetite:" + cats.appetites() +
                    "\nEating:" + cats.eat(plates) +
                    "\nFood balance:" + plates);
        }

    }


}
class Cat {
    private String name;
    private int appetite;

    Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public boolean eat(Plate plate) {
        return plate.dicreaseFood(appetite);
    }


    @Override
    public String toString() {
        return this.name;
    }
    public int appetites() {
        return this.appetite;
    }
}

class Plate {
    private int food;

    Plate(int food) {
        this.food = food;
    }

    public boolean dicreaseFood(int food) {
        if (food <= this.food) {
            this.food -= food;
            return true;
        }
        return false;
    }
    void setAddEatPlate(int food) { //setor add eat
        this.food += food;
    }


    @Override
    public String toString() {
        return ""+food;
    }
    public int foods() {
        return this.food;
    }
}