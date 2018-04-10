package Demo.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by fx on 2018/2/7.
 */
public class Hannuota {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        int t =scanner.nextInt();

        doTowers(t,'A','B','C');

        LinkedList<String> lList = new LinkedList<String>();
        lList.add("1");
        lList.add("2");
        lList.add("3");
        lList.add("4");
        lList.add("5");
        System.out.println(lList);
        lList.addFirst("0");
        System.out.println(lList);
        lList.addLast("6");
        System.out.println(lList);
        Collections.rotate(lList,-2);
        System.out.println(lList);
    }

    public static void doTowers(int topN,char from,char inter,char to){

        if(topN == 1){

            System.out.println("Disk"+topN+" from "+from+" to "+to);

        }else {

            doTowers(topN-1,from,to,inter);

            System.out.println("Disk"+topN+" from "+from+" to "+to);

            doTowers(topN-1,inter,from,to);
        }


    }
}
