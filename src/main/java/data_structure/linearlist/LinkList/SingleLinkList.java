package data_structure.linearlist.LinkList;

/**
 * Created by fx on 2019/2/28.
 */
public class SingleLinkList<E> {

    E item;
    SingleLinkList<E> next;
    //构造函数


    SingleLinkList(E item) {
        this.item = item;
        this.next=null;
    }

}
