import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;


public class Main{
   private double[] x = {133.5,  142.0,  145.5, 144.5,  134.5, 138.5, 144.0, 141.0, 141.5, 139.5, 140.0, 145.0, 141.5, 141.5, 139.0 ,140.5, 139.0  ,143.5 ,139.5 ,140.5 ,140.0 ,138.5 ,135.0, 139.5, 139.0 ,138.0 ,144.0 ,142.5 ,139.0 ,137.0 ,136.0,137.0 ,138.5 , 139.0 ,139.5 ,140.5 ,139.5 , 140.0 ,140.5 ,137.5 ,141.5 ,141.0 , 142.5 ,143.5 ,141.0 ,147.0 ,147.0 ,136.5 ,142.0, 140.0};
   private double[] xi = inOrder();
   private final int n = 50;

    double[] inOrder(){
        Queue xiS = new PriorityQueue();
        for(int i=0; i<n; i++){
            xiS.add(x[i]);
        }
        double []arrayX = new double[n];
        int i = 0;
        while(xiS.peek() != null){
            arrayX[i] = (Integer)xiS.peek();
            xiS.poll();
            System.out.println("array: "+arrayX[i]);
            i++;
        }
      return arrayX;
    }

    double mid(){
        double res = 0;
        for(int i =0; i<n; i++){
            res = res + xi[i];
        }
        res = 1.0/n * res;
        return res;
    }
    double dispersia(){
        double mid = mid();
        double res = 0.0;
        for(int i = 0; i<n; i++){
           res = (xi[i] - mid) * (xi[i] - mid);
        }
        res = 1.0/(n-1) * res;
        return res;
    }
    double S(){
       return Math.sqrt(dispersia());
    }
    double V(){
        return S()/mid();
    }
    double MidMoment(int p){
        double res = 0;
        for(int i=0; i<n; i++){
              res = res + Math.pow(xi[i]-mid() , p);
        }
        res = 1.0/n + res;
        return res;
    }
    double Sk(){  //коэф асимметрии
        double Sk = MidMoment(3)/Math.pow(MidMoment(2) , 3/2);
        return Sk;
    }
    double Ex(){
        double Ex = MidMoment(4)/ Math.pow(MidMoment(2) , 2) - 3 ;
        return Ex;
    }


    public static void main(String[] args){
      //  Main m = new Main();
       // m.inOrder(m.x);

    }

}
