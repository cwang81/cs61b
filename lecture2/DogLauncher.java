package lecture2;

public class DogLauncher {
    public static void main(String[] args) {
        Dog Chihuahua = new Dog(5);
        Dog[] dogs = new Dog[4];
        Dog smallDog = new Dog(5);
        Dog mediumDog = new Dog(15);
        Dog largeDog = new Dog(50);
        dogs[0] = Chihuahua;
        dogs[1] = smallDog;
        dogs[2] = largeDog;

        int len = dogs.length, i = 0;
        while (i < len) {
            if (dogs[i].weightInPounds > mediumDog.weightInPounds)
                dogs[i].makeNoise();
            else
                mediumDog.makeNoise();
            i++;
        }
    }
}
