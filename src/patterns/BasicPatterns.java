
void main() {
    //rectangularStarPattern(5);
    //rightAngledTrianglePattern(5);
    //dualLoop(0, 5, 0, 5, '*');
   // rightAngledNumberPyramidPatternII(5);
    //invertedNumberRightPyramidPattern(5);
   // startPattern(5);
    //invertedStarPattern(5);
    //binaryNumberTriangle(5);
   // numberCrownPattern(4);
    //increasingLetterTrianglePattern(5);
    //increasingLetterTrianglePatternApproach2(5);
    //alphaTrianglePattern(5);
    //symmetricButterflyPattern(5);
    hollowRectanglePattern(5);
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
public static void  rightAngledNumberPyramidPatternII(int n){


    for(int i =1;i<=n ;i ++){
        for(int j =1;j<=i;j++){
            System.out.print(i);
        }
        System.out.println();
    }
}
public static  void invertedNumberRightPyramidPattern(int n){

    for(int i =n; i>=1;i--){
        for(int j=1;j<=i;j++){
            System.out.print(j);
        }
        System.out.println();
    }
}
public static void startPattern(int n){


    for(int i = 1;i<=n;i++){

        for(int j =1; j<= n-i;j++){
            System.out.print("   ");
        }
        for (int k = 1; k <=i ; k++) {
            System.out.print(" * ");
        }

        for(int l =2;l<=i;l++){
            System.out.print(" * ");
        }

        System.out.println();

    }
}

public static void invertedStarPattern(int n){
    for(int i =1;i<=n;i++){
        // spaces
        for(int j =1; j<i;j++){
            System.out.print("   ");
        }
        // star
        for(int k =1;k<=n-i+1;k++){
            System.out.print(" * ");
        }
        for(int l =1;l<=n-i;l++){
            System.out.print(" * ");
        }
        System.out.println();
    }
}

public static void binaryNumberTriangle(int n ){

    for(int i =1;i<=n;i++){
        for (int j =1;j<=i;j++){
            System.out.print((i+j)%2==0 ? "1" : "0");
        }
        System.out.println();
    }
}

public static void  numberCrownPattern(int n){

    for (int i =1;i<=n;i++){
        for(int j =1;j<=i;j++){
            System.out.print(j);
        }
        for(int k =1;k<=n-i;k++){
            System.out.print(" ");
        }
        for(int l =n-i;l>=1;l--){
            System.out.print(" ");
        }
        for(int m =i;m>=1;m--){
            System.out.print("*");
        }
        System.out.println();
    }
}

public static void increasingLetterTrianglePattern(int n){

    for (int i = 0; i < n; i++) {
        for (int j = 0; j <= i; j++) {
            char printing = (char)('A' + j);
            System.out.print(printing);
        }
        System.out.println();
    }

}
public static void increasingLetterTrianglePatternApproach2(int n){

    for (int i = 0; i < n; i++) {

        for(char ch ='A'; ch<='A' +i;ch++){
            System.out.print(ch + " ");
        }
        System.out.println();
    }

}


public static void alphaTrianglePattern(int n){

    for (int i =0;i<n ;i++){

        for (char ch =(char) ('E' -i); ch<='E' ;ch ++){
            System.out.print( ch + " ");
        }
        System.out.println();

    }
}

public static void symmetricButterflyPattern(int n){

    for(int i =1;i<=n;i++){
        for(int j =1;j<=i;j++){
            System.out.print("*");
        }
        for(int k=1;k<=n-i;k++){
            System.out.print(" ");
        }
        for(int k=1;k<=n-i;k++){
            System.out.print(" ");
        }
        for(int l =1;l<=i;l++){
            System.out.print("*");
        }
        System.out.println();
    }
    for(int i =1;i<n;i++){
        for(int j =1;j<=n-i;j++){
            System.out.print("*");
        }
        for(int m =1;m<=i;m++){
            System.out.print("  ");
        }
        for(int k =1;k<=n-i;k++){
            System.out.print("*");
        }
        System.out.println();
    }

}

public static void hollowRectanglePattern(int n){

    for (int i =0; i <n ;i++){
        for(int j =0;j<n;j++){
            if(i==0 || i==n-1 || j==0 || j==n-1){
                System.out.print("*");
            }else{
                System.out.print(" ");
            }

        }
        System.out.println();
    }
}