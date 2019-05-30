import org.junit.Test;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class CalBit {
    public int NumberOf1(int n) {
        if(n==0){
           return 0;
        }else if(n<0){
            StringBuilder stringBuilder=new StringBuilder();
            int num=0;
            for (int i = 0; i < 32; i++)
            {
                // 0x80000000 是一个首位为1，其余位数为0的整数
                int t = (n & 0x80000000 >>> i) >>> (31 - i);
                stringBuilder.append(t);
            }
            for (int i = 0; i <stringBuilder.length() ; i++) {
                if(stringBuilder.charAt(i)=='1'){
                    num++;
                }
            }

            return num;
        }else{
            int num=0;
            while (n!=0){
                if(n%2==1){
                    num++;
                }
                n=n>>1;
            }
            return num;
        }

    }
    @Test
    public void test(){
        int n=-95;
        System.out.println(NumberOf1(n));
        System.out.println(Integer.toBinaryString(n));

    }
}
