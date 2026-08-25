
void main() {
    //rectangularStarPattern(5);
    //rightAngledTrianglePattern(5);
    //dualLoop(0, 5, 0, 5, '*');
    rightAngledNumberPyramidPattern(5);
}


public static void rectangularStarPattern(int n){

    for(int i =0;i<n;i++){
        for(int j =0; j<n;j++){
            System.out.print("* ");
        }
        System.out.println();
    }
}
public static void rightAngledTrianglePattern(int n ){

    for(int i =0;i<n ;i ++){
        for(int j =0;j<=i;j++){
            System.out.print("*");
        }
        System.out.println();
    }
}

public static void dualLoop(int startI, int endI, int startJ, int endJ, char c){
    for(int i=startI;i<endI;i++){
        for(int j = startJ; j<endJ; j++){
            System.out.print(c);
        }
        System.out.println();
    }
}
public static void  rightAngledNumberPyramidPattern(int n){


    for(int i =1;i<=n ;i ++){
        for(int j =1;j<=i;j++){
            System.out.print(j);
        }
        System.out.println();
    }
}