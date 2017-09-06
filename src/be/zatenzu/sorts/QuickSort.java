package be.zatenzu.sorts;

import java.util.concurrent.ThreadLocalRandom;

public class QuickSort {

    public static void sort(int[] array){
        quickSort(array, 0, (array.length-1));
    }

    private static void quickSort(int array[], int lowIndex, int highIndex){
        if(lowIndex < highIndex){
            //prend le pivot au pif
            int pivotIndex = getPivotIndexRandom(lowIndex, highIndex);
            //on partition le tableau et on récup le nouveau pivot
            pivotIndex = split(array, lowIndex, highIndex, pivotIndex);
            //on répete l'opération sur les deux sous tableau
            quickSort(array, lowIndex, (pivotIndex - 1));
            quickSort(array, (pivotIndex + 1), highIndex);
        }
    }

    public static int split(int[] array, int lowIndex, int highIndex, int pivotIndex){
        //on place l'element du pivot à la fin du sous tableau
        swapElements(array, pivotIndex, highIndex);

        //pour tout les autres elements du sous tableau (autres =  tous sauf la valeur pivot(highIndex - 1))
        int j = lowIndex;
        for(int i = lowIndex; i < highIndex ; i++){
            if(array[i] <= array[highIndex]){
                swapElements(array, i, j);
                j++;
            }
        }
        //on replace le pivot avant les valeurs plus importantes que lui
        swapElements(array, highIndex, j);

        return j;
    }

    /**
     * Choisir un pivot de manière aléatoire entre l'interval minium et maximum permet de garantir l'efficacité de l'algo.
     * @param low
     * @param high
     * @return
     */
    public static int getPivotIndexRandom(int low, int high){
        return ThreadLocalRandom.current().nextInt(low, high + 1);
    }

    private static int getPivotIndexArbitraire(int low, int high){
        return low;
    }

    private static void swapElements(int[] array, int a, int b){
        int tmp = array[b];
        array[b] = array[a];
        array[a] = tmp;
    }

    private static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {3,7,8,5,2,1,9,5,4};
        QuickSort.printArray(array);
        QuickSort.sort(array);
        QuickSort.printArray(array);
    }
}
