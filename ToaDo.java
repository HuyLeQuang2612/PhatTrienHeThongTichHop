import java.util.Scanner;

public class ToaDo {
    int x;
    int y;
    
    void toado(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    void nhaptoado(){
        Scanner sc =new Scanner(System.in);
        int a,b;
        System.out.print("nhap toa do x");
        a =sc.nextInt();
        System.out.print("nhap toa do y");
        b =sc.nextInt();
        toado(a, b);
        sc.close();
    }
    void intoado(){
        System.out.println("Toa do cua x va y (x,y):" + "(" + x + "," + y + ")");
    }
    void khoangcachdenO(){
        double khoangcachdenO;
        //Math.sqrt(Math.pow((xB - xA), 2) + Math.pow((yB - yA), 2)) công thức gốc
        khoangcachdenO = Math.sqrt(Math.pow((0 - x), 2) + Math.pow((0 - y), 2));
        System.out.println("Độ dài đoạn thắng AB = " + khoangcachdenO );
    }

    public static void main(String[] args) {
        ToaDo A = new ToaDo();
        A.nhaptoado();
        A.intoado();
        A.khoangcachdenO();
    }
}
