
void main() {
    //rectangularStarPattern(5);
    rightAngledTrianglePattern(5);
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

