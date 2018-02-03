package ThirdTask;

import java.util.*;

public class MyVector extends MyCollection {

    private int[] array = new int[0];

    public MyVector() {}

    MyVector(int[] a) {
        this.array = a;
    }


    @Override
    public void add(int element) { // OK
        int tmp[]=new int[array.length+1];
        for(int i=0;i<array.length;i++){
            tmp[i]=array[i];
        }
        tmp[array.length]=element;
        array = new int[tmp.length];
        array = tmp;
    }

    @Override
    public void add(int index, int element) {
        int[] tmp = new int[array.length + 1];

        for (int i = 0; i < index; i++) {
            tmp[i] = array[i];
        }
        tmp[index] = element;
        for (int i = index + 1; i < tmp.length; i++) {
            tmp[i] = array[i - 1];
        }
        array = tmp;
    }

    @Override
    public void clear() {
        array=new int[0];
    }

    @Override
    public boolean contains(int o) {
        return indexOf(o) != -1;
    }

    @Override
    public int get(int index) {
        return array[index];
    }

    @Override
    public int indexOf(int o) {return 1;}

    @Override
    public void insertElementAt(int element, int index) {
        add(index,element);
    }

    @Override
    public boolean isEmpty() {
        return array.length == 0;
    }

    @Override
    public void removeAt(int index) {
        int tmp[]=new int[array.length-1];
        int i;

        for(i=0;i<index;++i){
            tmp[i]=array[i];
        }

        for(;i<array.length-1;++i){
            tmp[i]=array[i+1];
        }
        array=new int[tmp.length];
        array=tmp;
    }

    @Override
    public void remove(int element) {
        boolean trigger=false;
        int i=0;
        while (!trigger){
            if(array[i]==element){
                array[i]=0;
                trigger=true;
            }
            i++;
        }
    }

    @Override
    public void removeAll(int element) {
        for(int i=0;i<array.length;i++){
            if(array[i]==element){
                array[i]=0;
            }
        }
    }

    @Override
    public void reverse() {
        for (int i = 0; i < array.length / 2; i++) {
            int a = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = a;
        }
    }

    @Override
    public void set(int index, int element) {
        array[index] = element;
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public void sort() {
        for(int i=0;i<array.length;i++){
            for(int j=i;j<array.length;j++){
                if(array[i]>array[j]){
                    int c=array[i];
                    array[i]=array[j];
                    array[j]=c;
                }
            }
        }
    }



    @Override
    public int[] toArray() {
        return array;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }


    public void mergeSort(){
        MergeSortHelper(array, 0, array.length-1);
    }

    void Merger(int arr[], int lo, int  mi, int hi){
        int[] temp = new int[hi-lo+1];
        int i = lo, j = mi + 1;
        int k = 0;
        while(i <= mi && j <=hi){
            if(arr[i] <= arr[j])
                temp[k++] = arr[i++];
            else
                temp[k++] = arr[j++];
        }

        while(i <= mi)
            temp[k++] = arr[i++];

        while(j <= hi)
            temp[k++] = arr[j++];

        for(k = 0, i = lo; i <= hi; ++i, ++k)
            arr[i] = temp[k];
    }

    void MergeSortHelper(int arr[], int lo, int hi){
        int mid;
        if(lo < hi){
            mid = (lo + hi) >> 1;
            MergeSortHelper(arr, lo, mid);
            MergeSortHelper(arr, mid+1, hi);
            Merger(arr, lo, mid, hi);
        }
    }

}
