package com.merzmostafaei.train;


public class ArrayTry {
    private int lenght;
    private int[] items;
    private int index = 0 ;

    public ArrayTry(int lenght) {
        this.lenght = lenght;
        this.items = new int[lenght];
    }
    public void insert(int item){
        if(index == items.length) {
            //create new array
            int[] newItems = new int[index * 2];

            //Copy all existing items

            for (int i = 0; i < index; i++)
                newItems[i]= items[i];

            //set "items" to this new array
            items = newItems;
        }
        items[index++] = item;

    }
    public void removeAt(int removeIndex){
        if (removeIndex < 0 || removeIndex >= index)
            throw new IllegalArgumentException("Invalid index");
        for (int i = removeIndex; i < index-1 ; i++)
            items[i] = items[i+1];
        index--;
        items[index] = 0;

    }
    public int indexOf(int item){
        for(int i =0 ; i < index; i++){
            if(items[i]== item)
                return i;
        }
        return -1;

    }

    public int max() {
        if (index == 0)
            throw new IllegalStateException("Array empety");
        int max = items[0];
        for (int i = 0; i < index; i++) {
            if (items[i] > max)
                max = items[i];


        }
        return max;
    }

    public ArrayTry intersect(ArrayTry other){
        ArrayTry result = new ArrayTry(this.index);

        for (int i = 0; i < this.index ; i++){
            int item = this.items[i];
            if(other.indexOf(item) >= 0 && result.indexOf(item) == -1){
                result.insert(item);
            }
        }
        return result;
    }

    public ArrayTry reverse(){
        ArrayTry reverseElemet = new ArrayTry(this.index);

        for(int i = this.index-1 ; i >= 0 ; i--) {

            reverseElemet.insert(items[i]);

        }
        return reverseElemet;
    }

    public void print(){
        for (int i =0; i < index ; i++){
            System.out.printf("%d %n", items[i]);
        }
    }

    public void insertAt(int item,int indexInsert){

        if (indexInsert < 0 || indexInsert > this.index)
            throw new IllegalStateException("index for currect");

        // resize the array

        if (indexInsert == this.index){
            int[] newItems = new int[items.length * 2];
            for (int i = 0; i< index ; i++)
                newItems[i] = items[i];
            items = newItems;
        }
        //shift element to the right

        for (int i = index - 1; i >= indexInsert; i--)
            items[i + 1] = items[i];

        items[indexInsert]= item;
        index++;


    }





}
