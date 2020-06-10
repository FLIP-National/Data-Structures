import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class HeapsSolution4 {
    
    static class Orders{
        long startT;
        long foodT;
        long endT;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        
        PriorityQueue<Orders> arrivalQueue = new PriorityQueue<>(a,new Comparator<Orders>(){
            public int compare(Orders orderOne, Orders orderTwo){
                if(orderOne.startT<orderTwo.startT)
                    return -1;
                else if(orderOne.startT>orderTwo.startT)
                    return 1;
                else 
                    return 0;
            }
        });
        
        
        for(int i=0;i<a;i++){
            Orders order = new Orders();
            order.startT = in.nextLong();
            order.foodT = in.nextLong();
            arrivalQueue.add(order);
        }
        
        PriorityQueue<Orders> cookingQueue = new PriorityQueue<>(a,new Comparator<Orders>(){
            public int compare(Orders orderOne, Orders orderTwo){
                if(orderOne.foodT<orderTwo.foodT)
                    return -1;
                else if(orderOne.foodT>orderTwo.foodT)
                    return 1;
                else 
                    return 0;
            }
        });
        
        //queue
        Orders temp;
        long time = 0;
        long waitT = 0;
        
        while((!arrivalQueue.isEmpty()) || (!cookingQueue.isEmpty())) {
            
            if(!arrivalQueue.isEmpty()){
                while(arrivalQueue.peek()!= null && time>=arrivalQueue.peek().startT){
                    temp = arrivalQueue.remove();
                    cookingQueue.add(temp);
                    
                }
            }
            
            if(!cookingQueue.isEmpty()){
                
                if(time>=cookingQueue.peek().startT){
                    temp = cookingQueue.remove();
                    time += temp.foodT;
                    temp.endT = time;
                    //System.out.println("CookingQ "+temp.startT +" "+ temp.foodT+" "+temp.endT);
                    waitT += (temp.endT - temp.startT);
                    continue;
                    
                }
        }
        time++;           
    }
        System.out.println(waitT/a);               
    }
}