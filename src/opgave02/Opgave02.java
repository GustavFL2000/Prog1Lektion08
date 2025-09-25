package opgave02;

public class Opgave02 {
    public static void main(String[] args) {
        int[] intArray = { 23, 8, 202, -13, 42, 6, 53, 17, 22 };

        // Opgave 2.1
        System.out.println("Before swap: First = " + intArray[0] + ", Last = " + intArray[intArray.length - 1]);
        swapFirstLast(intArray);
        System.out.println("After swap: First = " + intArray[0] + ", Last = " + intArray[intArray.length - 1]);

        System.out.println();

        // Opgave 2.2
        System.out.println("Replacing odd numbers with 0: ");
        replaceOddWithZero(intArray);
        printArray(intArray);

        System.out.println();

        // Opgave 2.3
        // Laver lige et nyt array, da det andet nu kun indeholder lige tal og 0
        intArray = new int[] { 23, 8, 202, -13, 42, 6, 53, 17, 22 };
        System.out.println("Minimum value in the array: " + findMin(intArray));

        System.out.println();
        // Opgave 2.4
        System.out.println("Index of the minimum value in the array: " + findMinIndex(intArray));

        System.out.println();
        // Opgave 2.5
        System.out.println("Array before shifting right: ");
        printArray(intArray);
        shiftRight(intArray);
        System.out.println("Array after shifting right: ");
        printArray(intArray);

        System.out.println();
        // Opgave 2.6
        System.out.println("Second largest value in the array: " + findSecondLargest(intArray));

        System.out.println();
        // Opgave 2.7
        System.out.println("Is the array sorted in ascending order? " + isSorted(intArray));

        int[] sortedArray = { -13, 6, 8, 17, 22, 23, 42, 53, 202 };
        System.out.println("Is the sorted array sorted in ascending order with new array? " + isSorted(sortedArray));

        System.out.println();

        // Opgave 2.8
        System.out.println("Does the array have duplicates? " + hasDuplicates(intArray));
        int [] arrayWithDuplicates = { 23, 8, 202, -13, 42, 6, 53, 17, 22, 8, 202 };
        System.out.println("Does the array have duplicates? " + hasDuplicates(arrayWithDuplicates));
    }

    // Hjælpe metode til at printe array
    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    // 1 Byt første og sidste element i et array
    public static void swapFirstLast(int[] array) {
        int temp = array[0]; // Gem det første element midlertidigt
        array[0] = array[array.length - 1]; // Sæt det sidste element til det første
        array[array.length - 1] = temp; // Sæt det midlertidigt gemte første element til det sidste
    }

    // 2 Erstat alle ulige elemeneter med 0
    public static void replaceOddWithZero(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) { // Tjek om elementet er ulige
                array[i] = 0; // Erstat ulige element med 0
            }
        }
    }

    // 3 Returner det mindste element i et array
    public static int findMin(int[] array) {
        int min = array[0]; // Vi starter på det første element)
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    // 4 Metode der finder pladsen det mindste element ligger på
    public static int findMinIndex(int[] array) {
        int min = array[0]; // Vi starter på det første element
        int minIndex = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < min) {
                min = array[i];
                minIndex = i;
            }
        }
        return minIndex;

    }

    // 5 Ryk alle elementer i et array en plads til højre
    // (det sidste element rykkes til plads 0)
    public static void shiftRight(int[] array) {
        int lastElement = array[array.length - 1]; // Gem det sidste element
        for (int i = array.length - 1; i > 0; i--) {
            array[i] = array[i - 1]; // Ryk hvert element en plads til højre
        }
        array[0] = lastElement; // Sæt det sidste element til plads 0
    }

    // 6 Metode der finder det næst største element i et array
    public static int findSecondLargest(int[] array) {
        int largest = Integer.MIN_VALUE; // Start med den lavest mulige værdi
        int secondLargest = Integer.MIN_VALUE; // Start med den lavest mulige værdi

        for (int value : array) {
            if (value > largest) { // Hvis elementet er større end det største fundet
                secondLargest = largest; // Opdater næst største til det største
                largest = value; // Opdater største til det nye element
            } else if (value > secondLargest && value != largest) { // Hvis elementet er større end næst største og ikke
                                                                    // lig med største
                secondLargest = value; // Opdater næst største
            }
        }
        return secondLargest;
    }

    // 7 Returnere true hvis elemenetet er sorteret i stigende orden
    public static boolean isSorted(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false; // Hvis et element er større end det næste, er arrayet ikke sorteret
            }
        }
        return true; // Hvis vi ikke fandt nogen elementer der var større end det næste, er arraye
    }

    // 8 Lav en metode der returnerer true hvis der er dubletter i et array
    public static boolean hasDuplicates(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    return true; // Hvis vi finder to elementer der er ens, returner true
                }
            }
        }
        return false; // Hvis vi ikke fandt nogen dubletter, returner false
    }

}
