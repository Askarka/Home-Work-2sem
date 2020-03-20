package HomeWork.prog._3DONE;

public class StrArrEvIt implements java.util.Iterator<String> {
    private  String[] data;
    private int cursor;

    public StrArrEvIt(String[] data) {
        this.data = data;
        this.cursor = 0;
    }

    @Override
    public boolean hasNext() {
        if(this.cursor < this.data.length - 2){
            if(data[this.cursor + 2] != null){
                return true;
            }
        }
        return false;
    }

    @Override
    public String next() {
        try{
            String el = data[cursor];
            cursor+=2;
            return el;
        } catch (ArrayIndexOutOfBoundsException ex){
            System.err.println("Iterator didn't found next element.");
            return "";
            //                throw new java.util.NoSuchElementException();
        }
    }
}
