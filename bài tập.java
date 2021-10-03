import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String message;
    System.out.println("\n\nNhập vào chuỗi cần in hoa: ");
    message = sc.nextLine();
    //khai báo một mảng, sau đó sử dụng phương thức toCharArray() 
    //để chuyển đổi message thành một mảng kiểu char
    char[] charArray = message.toCharArray();
    //sử dụng vòng lặp for để duyệt các phần tử trong charArray
    for(int i = 0; i < charArray.length; i++) {
      if(charArray[i] >= 97 && charArray[i] <= 122){
        charArray[i] -= 32;
      }
    }
    // chuyển đổi mảng char thành string
    message = String.valueOf(charArray);
    System.out.println("Chuỗi sau khi đổi: \n" + message);
  }
}