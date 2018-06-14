/**
 * * Home work six
 *
 * @author Andrew Shevelev
 * @version Feb, 15 2018
 *
 * @link https://github.com/ShevelevAndrew
 */

/**
 * 1 Создать классы Собака и Кот с наследованием от класса Животное.
 * 2 Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие. В качестве
 * параметра каждому методу передается величина, означающая или длину препятствия (для
 * бега и плавания), или высоту (для прыжков).
 * 3 У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; прыжок: кот
 * 2 м., собака 0.5 м.; плавание: кот не умеет плавать, собака 10 м.).
 * 4 При попытке животного выполнить одно из этих действий, оно должно сообщить результат в
 * консоль. (Например, dog1.run(150); -> результат: run: true)
 * 5. Записать объекты в массив и перебрать в цикле, проилюстрировав полиморфизм
 */


public class HomeWorkSix {
    public static void main(String[] args) {

        IAnimal[] animals = {new Cat(199, 30, 2),
                new Dog(15, 11, (float) 0.5)};

        for (IAnimal animal : animals)
            System.out.println(animal +"->"+animal.action());
    }

}


class Cat extends Animal {
    Cat(int run, int swim, int jump) {
        super(run, swim, jump);
    }

    @Override
    public String action() {
        return "{run:"+(this.run <= 200)+", swim:"+(this.swim < 0)+
                ", jump:"+(this.jump <= 2)+"}";
    }
}

class Dog extends Animal {
    Dog(int run, int swim, float jump) {
        super(run, swim, jump);
    }
    @Override
    public String action() {

        return "{run:"+(this.run <= 500)+", swim:"+(this.swim <= 10)+
                ", jump:"+(this.jump <= 0.5)+"}";
    }
}


interface IAnimal {
    String action();
}

abstract class Animal implements IAnimal {
    protected int run;
    protected int swim;
    protected float jump;

    Animal(int run, int swim, float jump) {
        this.run = run;
        this.swim = swim;
        this.jump = jump;
    }

    @Override
    public String toString() {
        return this.getClass().getName() +
                " {run=" +  run + ", swim=" + swim + ", jamp=" + jump + "}";
    }
}
