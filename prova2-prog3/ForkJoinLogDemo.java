import java.util.concurrent.*;

class LogTransform extends RecursiveAction {
    final int threshold = 1000;
    double [] data ;
    int start , end ;

    LogTransform ( double [] vals , int s , int e ) {
        data = vals ;
        start = s ;
        end = e ;
    }

    @Override
    protected void compute () {
        if (( end - start ) < threshold ) {
            // # TODO 1: Aplicar Math . log em cada elemento de data [ i ]
            for ( int i = start; i < end; i++) {
                data[i] = Math.log(data[i]) ;
            }
        } else {
            int mid = ( start + end ) / 2;
            // # TODO 2: Dividir a tarefa com invokeAll

            // usando duas novas instancias
            LogTransform left = new LogTransform (data,start,mid );
            LogTransform right = new LogTransform (data,mid,end );
            left.fork();
            right.fork();
            
        }
    }
}

public class ForkJoinLogDemo {
    public static void main ( String [] args ) {
        ForkJoinPool pool = new ForkJoinPool ();
        double [] valores = new double [100000];

        for ( int i = 0; i < valores . length ; i ++) {
            valores [ i ] = i + 1;
        }

        System.out.println ( " Valores originais : " );
        
        for ( int i = 0; i < 10; i ++) {
            System . out . print ( valores [ i ] + " " );
        }
        System.out.println ();

        // # TODO 3: Criar a tarefa inicial e invocar com o pool
        LogTransform tarefa = new LogTransform (valores,0,valores.length);
        pool.invoke(tarefa);
    
        System . out . println ( " Valores transformados: " );
        for ( int i = 0; i < 10; i ++) {
            // # TODO 4: Imprimir valores formatados com 4 casas decimais
            System.out.printf ( "%.4f ", valores [ i ] );
        }
    }
}