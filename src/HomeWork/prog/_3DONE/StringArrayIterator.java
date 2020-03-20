package HomeWork.prog._3DONE;

public class StringArrayIterator implements java.util.Iterator<String>{
    private  String[] data;
    private int cursor;

    public StringArrayIterator(String[] data){
        this.cursor = 0;
        this.data = data;
    }
    public boolean hasNext(){
        if(data.length <= cursor){
            return false;
        }
        return true;
    }
    public String next(){
//        if(!hasNext()){
//            throw new NoSuchElementException();
//        }
//        String el = data[cursor];
//        cursor++;
//        return el;
        try{
            String el = data[cursor];
            cursor++;
            return el;
        }
        catch (ArrayIndexOutOfBoundsException ex){
            throw new java.util.NoSuchElementException();
        }
    }
}