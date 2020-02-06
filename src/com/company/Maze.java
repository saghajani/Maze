
import java.io.*;
//import java.io.File.*;
//import java.io.FileWriter;
import java.util.Scanner;


public class Maze{
    static int[] rowar = new int[100];
    static int[] columnar = new int[100];
    static int n=0;
    static char array1[][] = new char [10][10];
    static Scanner input = new Scanner (System.in);
    static int z=0;
    static Boolean [][] visit = new Boolean[10][10];

    public void findPath(int a,int b,char[][] visited,Stack row,Stack column,int w,int l){

        row.push(a);
        column.push(b);

        visited[a][b]='t';
        if(row.pop()==w && column.pop()==l) return;

        else{//1
            if(visited[a][b+1]=='f'){
                b=b+1;
                column.push(b);
                row.push(a);

                visited[a][b]='t';

                rowar[n]=row.pop();
                columnar[n]=column.pop();
                n++;
                findPath(a,b,visited,row,column,w,l);
            }


            else{//2
                if(visited[a+1][b]=='f'){
                    a=a+1;
                    row.push(a);
                    column.push(b);

                    visited[a][b]='t';
                    rowar[n]=row.pop();
                    columnar[n]=column.pop();
                    n++;
                    findPath(a,b,visited,row,column,w,l);
                }


                else{//3
                    if(visited[a-1][b]=='f'){
                        a=a-1;
                        row.push(a);
                        column.push(b);

                        visited[a][b]='t';

                        rowar[n]=row.pop();
                        columnar[n]=column.pop();
                        n++;
                        findPath(a,b,visited,row,column,w,l);
                    }


                    else{//4
                        if(visited[a][b-1]=='f'){
                            b=b-1;
                            column.push(b);
                            row.push(a);

                            visited[a][b]='t';

                            rowar[n]=row.pop();
                            columnar[n]=column.pop();
                            n++;
                            findPath(a,b,visited,row,column,w,l);
                        }

                        else{//5


                            a=rowar[n-2];
                            b=columnar[n-2];
                            n--;
                            columnar[n]=columnar[n-1];
                            rowar[n]=rowar[n-1];
                            findPath(a,b,visited,row,column,w,l);
                        }//5
                    }//4
                }//3
            }//2
        }//1

    }//end of find path
    public static void main(String[] args) throws IOException  {
        // FileWriter openfile = new FileWriter("maze input.txt");
        Stack rowStack = new Stack();
        Stack colStack = new Stack();
        int  j = 0,i = 0, row, column;
        char a = '0',b = '1';
        System.out.println("enter number of rows:");
        row = input.nextInt();
        System.out.println("enter number of columns:");
        column = input.nextInt();
        char [][] array = new char[row][column];
        FileReader fileread = new FileReader("position.txt");
        int nextChar = fileread.read();
        while(nextChar!= -1){
            if((char)nextChar==a||(char)nextChar==b){
                //System.out.println((char)nextChar);
                if(j==column){j=0;i++;}
                array [i][j] =(char)nextChar;
                nextChar = fileread.read();

                j++;
            }
            else nextChar = fileread.read();
        }


        char[][] visited=new char[row+2][column+2];
        for(int k=1;k<row+1;k++){
            for(int s=1;s<column+1;s++){
                if(array[k-1][s-1]=='0')  visited[k][s]='f';
                else  visited[k][s]='t';
            }
        }
        for(int k=0;k<row+2;k++){
            for(int s=0;s<column+2;s++){
                if(k==0||k==row+1||s==0||s==column+1){
                    visited[k][s]='t';
                }
            }
        }

        Maze maze = new Maze();
        a=b=1;

        maze.findPath(a, b, visited, rowStack , colStack, row, column);
        System.out.println("0,0");
        for(int p=0;p<n;p++){
            System.out.println((rowar[p]-1)+","+(columnar[p]-1));
            rowar[p]--;
            columnar[p]--;
        }

//       try{
//
//        PrintWriter output=new PrintWriter("path.txt");
//        BufferedWriter writer=new BufferedWriter(output);
//        writer.write("0,0\n");
//        for(int l=0 ; l<n; l++){
//            writer.write((rowar[l]-1)+","+(columnar[l]-1)+"/n");
//        }
//        writer.flush();
//        writer.close();
//         }
//        catch(IOException e2){
//           System.out.println("file not found");
//        }

    }
}