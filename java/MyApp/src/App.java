// public class App {
//     public static int FindNumberAlgorhim1(int arr1[], int Number) {
//         // int n = 10;
//         int pos = -1;
//         for (int i = 0; i < arr1.length; i++) {
//             if (arr1[i] == Number) {
//                 pos = i;
//             }
//         }
//         return pos;
//     }
//     public static int FindNumberAlgorhim2(int arr1[], int Number)
//     {
//         // int n = 10;
//         for (int i = 0; i < arr1.length; i++) {
//             if (arr1[i] == Number) {
//                 return i;
//             }
//         }
//         return -1;
//     }
//     public static void main(String[] args) throws Exception {
//         int arr1[] = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
//         System.out.println("Hello Word");
//         // int num=FindNumberAlgorhim1(arr1, 30);
//         // int num2=FindNumberAlgorhim2(arr1, 30);

//         System.out.println(FindNumberAlgorhim1(arr1, 30));
//         System.out.println(FindNumberAlgorhim2(arr1, 30));
//     }
// }

// public class App {
//     public static void AddArrays() {
//         int[][] Matrix1 = { { 1, 2, 3, 4, 5 },
//                 { 1, 2, 3, 4, 5 },
//                 { 1, 2, 3, 4, 5 },
//                 { 1, 2, 3, 4, 5 },
//                 { 1, 2, 3, 4, 5 } };
//         int[][] Matrix2 = { { 1, 2, 3, 4, 5 },
//                 { 1, 2, 3, 4, 5 },
//                 { 1, 2, 3, 4, 5 },
//                 { 1, 2, 3, 4, 5 },
//                 { 1, 2, 3, 4, 5 } };
//         for (int i = 0; i < Matrix1.length; i++) {
//             for (int j = 0; j < Matrix1.length; j++) {
//                   System.out.print(Matrix1[i][j] + Matrix2[i][j]+ "  ");
//             }
//                 System.out.print("\n");
//         }
//     }
//     public static void main(String[] args) throws Exception {
//         AddArrays();
//     }
// }
/* 
import java.util.Scanner;

public class App {
   static Scanner scanner=new Scanner(System.in);
   // Order Array
    public static void OrderArray( int arr[]){ //7 5 4 8   8 5 4 7  8 7 4 5
        int temp=arr[0];
        for(int i=0 ;i <arr.length-1 ;i++){           //arr[0]=7   arr[1]=5   arr[2]=4
         for(int j=i+1 ;j <arr.length ;j++){      //arr[3]=8   arr[3]= 7  arr[3]=5
            if(arr[j] >arr[i]){
               temp=arr[i]; //temp =7   temp=5      temp=4
               arr[i]=arr[j];//arr[0]=8  arr[1]=7    arr[2]=5
               arr[j]=temp;//arr[3]=7    arr[3]=5    arr[3]=4
            } 
         }
        }
    }
    // reverse Array
     public static void RevaersArray(int arr[]){
        int temp;
      for(int i=0 ;i <arr.length/2 ;i++){
        temp= arr[i];
        arr[i]=arr[arr.length-1-i];
        arr[arr.length-1-i]=temp;
       }
     }
     public static void printArray( int arr[]){
      for(int i=0 ;i <arr.length ;i++){
        System.out.print(arr[i] +"  ");
      }
     }
   public static void main(String[] args) {
        System.out.println("Enter arr Length :");
        int Length=scanner.nextInt();
        int arr[]=new int[Length];
            System.out.println("Enter arr element :");
        for(int i=0 ;i <Length ;i++){
            arr[i]=scanner.nextInt();
        }
        printArray(arr);
       // OrderArray(arr);
       //System.out.println("\nprint New order"); 
       System.out.println("\nprint New order"); 
       RevaersArray(arr);
        printArray(arr);
}
}
*/
/* 
class App{
  public static int numOfOddNum(int arr[]){
    int oddCount=0;
    for(int i=0 ;i<arr.length ;i++){
      if(arr[i] % 2==0) oddCount++;
    }
    return oddCount;
  }
  public static int [] NewArray(int arr[]){
    int ind=0;
    int NewArr[]=new int [numOfOddNum(arr)];
        for(int i=0 ;i<arr.length ;i++){
      if(arr[i] % 2==0) {
           NewArr[ind]=arr[i];
           ind++;
      }
  }
  return NewArr;
}
     public static void printArray( int arr[]){
      for(int i=0 ;i <arr.length ;i++){
        System.out.print(arr[i] +"  ");
      }
     }
public static void main(String[] args) {
printArray (NewArray(new int[] {2,5,4,7,3,1,4,8}));
}
}
*/
/* 
class App {
  public static int[] ReverseArray(int arr[]) {
    int temp;
    for (int i = 0; i < arr.length / 2; i++) {
      temp = arr[i];
      arr[i] = arr[arr.length - 1 - i];
      arr[arr.length - 1 - i] = temp;
    }
    return arr;
  }

  public static void printArray(int arr[]) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + "  ");
    }
  }

  public static void main(String[] args) {
    printArray(ReverseArray(new int[] { 2, 5, 4, 7, 3, 1, 4, 8 }));
  }
}
*/
/* 
class App{
  public static int [] OrderArray(int arr[]){
    int temp;
    for(int i=0 ;i<arr.length-1 ;i++){
      for(int j=i+1 ;j<arr.length ;j++){
        if(arr[j] > arr[i]){
          temp=arr[i];
          arr[i]=arr[j];
          arr[j]=temp;
        }
    }
  }
  return arr;
}
  public static void main(String[] args) {
    int arr[]= { 2, 5, 4, 7, 3, 1, 4, 8 };
    System.out.println(OrderArray(arr)[1]);
  }
}
*/
/* 
class App{
  public static int [] MoveZeros(int arr[]){
    int newArr[]=new int[arr.length];
    int ind=0;
   for(int i=0 ;i<arr.length ;i++){
    if(arr[i]!=0){
      newArr[ind]=arr[i];
      ind++;
    }
  }
  return newArr;
}
public static int[] MoveZeros2(int arr[]){
  int j=0;
  int temp;
   for(int i=0 ;i<arr.length ;i++){
    if(arr[i] != 0 && arr[j]==0){
        temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    if(arr[j] !=0){
      j++;
    }
  }
  return arr;
}
  public static void printArray(int arr[]) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + "  ");
    }
  }

  public static void main(String[] args) {
    int arr[]={ 1,0, 5, 0, 0, 3, 0, 4, 8 };
    printArray(MoveZeros2(arr));
  }
}
*/
/* 
class App{
  public static int findMissingNum(int []arr){
    int n=arr.length+1;
    int sum=(n * (n+1))/2;
    for(int i=0 ;i<arr.length ;i++){
      sum-=arr[i];
    }
    return sum;
  }
    public static void main(String[] args) throws Exception {
       System.out.println(findMissingNum(new int []{1,2,3,4,5,7}));
    }
  }
*/
/* 
class App{
 public static boolean IsPalindrome(String text){
     for(int i=0 ;i<text.length()/2 ;i++){
      if(text.charAt(i) != text.charAt(text.length()-1-i)) return false;
     }
     return true;
 }
     public static void main(String[] args) throws Exception {
      boolean result =IsPalindrome("mnllnm")  ;
      System.out.println(result);
    }
}
*/