package data_structure.linearlist;


/**
 * Created by fx on 2019/2/28.
 * 数组数据结构
 */
public class ArrayStructure {


    //数组
    private int[] intArray;

    //有效长度
    private int elems;

    //数组长度
    private int length;

    public int[] getIntArray() {
        return intArray;
    }

    private ArrayStructure(int length){
        elems = 0;
        this.length = length;
        intArray = new int[length];
    }

    public boolean add(int a){
        if(elems==length){
            int[] newArray = new int[length*2];
            for (int i = 0; i < intArray.length; i++) {
                newArray[i] = intArray[i];
            }
            intArray = newArray;
            length = 2*length;
        }
        intArray[elems] = a;
        elems++;
        return true;
    }

    // 指定位置增加元素oldArray 表示当前存储元素的数组
        //size 表示当前元素个数
    public void add(int index, int e) {
        int[] newArray = new int[length*2];




        for (int i = 0; i < length; i++) {
            newArray[i] = intArray[i];
        }
        if (index > length || index < 0) {
            System.out.println("位置不合法...");
        }

        //如果数组已经满了 就扩容
        if (intArray.length >= intArray.length) {
            // 扩容
            for (int i = 0; i < intArray.length; i++) {
                newArray[i] = intArray[i];
            }
            intArray = newArray;
        }

        //将数组elementData从位置index的所有元素往后移一位
        for (int i = elems - 1; i >= index; i--) {
            intArray[i + 1] = intArray[i];
        }

        //将数组elementData从位置index的所有元素往后移一位
        // System.arraycopy(oldArray, index, oldArray, index + 1,size - index);

        intArray[index] = e;
        elems++;
    }

    //遍历元素
    public void display(){
        for(int i = 0 ; i < elems ; i++){
          System.out.print(intArray[i]+" ");
        }
        System.out.println();

    }

    //获取元素根据下标
    public int get(int index){
        if(index<0||index>elems){
            System.out.println("越界访问");
        }
        return intArray[index];
    }
    //查找元素
    public int  find(int searchValue){
        int k=-1;
        for(int i=0;i<elems;i++){
            if(intArray[i]==searchValue){
                k=i;
                break;
            }

        }
        return k;
    }

    public boolean deleteElement(int value){
        int k = find(value);
        if(k==-1){
            return false;
        }else {
            if(k!=elems-1) {
                for (int i = k; i < elems - 1; i++) {
                    intArray[i] = intArray[i + 1];

                }
            }
            elems--;
            return true;
        }

    }


    public boolean update(int oldValue,int newValue){

        int i = find(oldValue);
        if(i==-1){
            System.out.println("无此修改数据");
            return false;
        }else{
            intArray[i] = newValue;
            return true;
        }

    }


    public static void main(String[] args) {
        ArrayStructure array = new ArrayStructure(4);
        //添加4个元素分别是1,2,3,4
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        //显示数组元素
        array.display();
        //根据下标为0的元素
        int i = array.get(0);
        System.out.println(i);
        //删除4的元素
        array.deleteElement(4);
        //将元素3修改为33
        array.update(3, 33);
        array.display();
        array.add(5);
        array.add(6);
        array.display();
    }
}
