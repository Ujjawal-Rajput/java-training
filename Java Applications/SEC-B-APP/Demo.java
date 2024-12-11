class Animal {
    void walk() {
        System.out.println("Animal is walking");
    }
}

class Dog extends Animal {
    void walk() {
        System.out.println("Dog is walking");
    }
}

class Demo {
    public static void main(String[] args) {
        Animal a = new Animal();
        Animal b = new Dog();
    }
}
