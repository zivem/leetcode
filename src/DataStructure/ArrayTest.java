package DataStructure;

public class ArrayTest {

    private int[] data;

    private int n; //数组大小

    private int count;//当前使用大小

    public ArrayTest(int capacity){
        this.data = new int[capacity];
        this.n = capacity;
        this.count = 0;
    }

    //根据索引查询并返回
    public int find(int index){
        if(index < 0 || index > count) return -1;
        return data[index];
    }

    //插入操作
    public boolean insert(int index, int value) {
        if(count == n) return false;
        if(index < 0 || index > count) return false;
        for(int i = count; i > index ; i --){
            data[i] = data[i-1];
        }
        data[index] = value;
        ++count;
        return true;
    }

    public boolean delete(int index){
        if(count == 0){
            return false;
        }
        if(index < 0 || index > count) return false;
        for(int i = index; i < count; i++){
            data[i] = data[i+1];
        }
        --count;
        return true;
    }

    public void printArr(){
        for(int i = 0 ; i < count; i++){
            System.out.println(data[i]+",");
        }
    }

    public static void main(String[] args){
        ArrayTest data = new ArrayTest(10);
        data.insert(0,1);
        data.insert(1,2);
        data.insert(2,3);
        data.insert(3,4);

        int x = data.find(3);
        System.out.println(x);

        data.printArr();
        data.delete(2);
        data.printArr();
    }
}
