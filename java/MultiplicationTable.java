public class MultiplicationTable {
    public void table(int n) {
        for (int i = 1; i < 10; i++) {
            System.out.println(n * i);
        }
    }

    public static void main(String[] args) {
        MultiplicationTable mt = new MultiplicationTable();
        for (int i = 2; i < 10; i++) {
            mt.table(i);
        }
    }
}
