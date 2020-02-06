public class Stack {
    private int[] ar=new int[100];
    private  int top=0;

    public void push(int a){
        if(top<100){
            ar[top]=a;
            top++;
        } else System.out.println("stack is full!!!");
    }//end of push


    public int pop(){
        if(top>0){
            top--;
            return ar[top];
        }
        else{
            System.out.println("stack is empty!!!");
            return -1;
        }
    }//end of pop



}
