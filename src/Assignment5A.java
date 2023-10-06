/*
Name: Briana O'Neal
Class: CS 3305/W01
Term: Fall 2022
Instructor: Sharon Perry
Assignment: 5-Part-1-Queues
*/
import java.util.LinkedList;
//outline of a chore, includes name and priority number
class Chore{
    String name;
    int priority;

    Chore(String name, int priority){
        this.name = name;
        this.priority = priority;
    }
}
//outline of a priority queue; adds chores to list, dequeues priorities and displays size of queue
class PriorityQueue{
    LinkedList<Chore> linkedList = new LinkedList<>();
    //sorts by priority before added to queue
    public void enqueue(Chore c){
        boolean wasInserted = false;
        //if queue is empty, simply add chore
        if(getSize() == 0){
            System.out.println("\"" + c.name + "\"" + " added to queue");
            linkedList.add(c);
        }
        //if queue is not empty, find correct spot, then add chore
        else{
            for(int i = 0; i < getSize(); i++){
                if(c.priority < linkedList.get(i).priority){
                    System.out.println("\"" + c.name + "\"" + " added to queue");
                    linkedList.add(i, c);
                    wasInserted = true;
                    break;
                }
            }
            if(!wasInserted){
                System.out.println("\"" + c.name + "\"" + " added to queue");
                linkedList.add(c);
            }
        }
    }
    //removes head of queue
    public void dequeue(){
        if(getSize() > 0){
           System.out.println(linkedList.poll().name);
        }
        else{
            System.out.println("Queue is empty");
        }
    }
    //returns size of queue
    public int getSize(){
        return linkedList.size();
    }
}
public class Assignment5A {
    public static void main(String[] args) {
        //instantiating chores
        Chore trash = new Chore("Take out the Trash", 1);
        Chore dishes = new Chore("Wash Dishes", 2);
        Chore mail = new Chore("Sort Mail", 3);
        Chore desk = new Chore("Organize Desk", 4);
        Chore laundry = new Chore("Do Laundry", 5);

        //instantiate priority queue
        PriorityQueue priorityQueue = new PriorityQueue();

        //enqueue chores
        priorityQueue.enqueue(desk);
        priorityQueue.enqueue(mail);
        priorityQueue.enqueue(trash);
        priorityQueue.enqueue(dishes);
        priorityQueue.enqueue(laundry);

        //call dequeue
        priorityQueue.dequeue();
        priorityQueue.dequeue();
        priorityQueue.dequeue();

        //call get size
        System.out.println(priorityQueue.getSize());

    }
}
