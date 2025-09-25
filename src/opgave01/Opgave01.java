package opgave01;

public class Opgave01 {
    public static void main(String[] args) {
        int [] values = {5,10};
        System.out.println("Before swap: x = " + values[0] + ", y = " + values[1]);
        swap(values);
        System.out.println("After swap: x = " + values[0] + ", y = " + values[1]);

    }

    public static void swap(int [] array) {
        int temp = array[0];
        array[0] = array[1];
        array[1] = temp;
    }

}
