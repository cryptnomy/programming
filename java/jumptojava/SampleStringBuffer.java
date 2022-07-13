package jumptojava;

public class SampleStringBuffer {
    public static void main(String[] args ){
        // append
        StringBuffer sb = new StringBuffer();
        sb.append("hello");
        sb.append(" ");
        sb.append("jump to java");
        String result = sb.toString();
        System.out.println(result);
        // The above example with string types only
        String result2 = "";
        // '+' operation creates new string object
        result2 += "hello";
        result2 += " ";
        result2 += "jump to java 2";
        // 4 string objects are mode.
        System.out.println(result2);
        // StringBuilder
        StringBuilder sb3 = new StringBuilder();
        sb3.append("hello");
        sb3.append(" ");
        sb3.append("jump to java 3");
        String result3 = sb3.toString();
        System.out.println(result3);
        // insert
        StringBuffer sb4 = new StringBuffer();
        sb4.append("jump to java 4");
        sb4.insert(0, "hello ");
        System.out.println(sb4.toString());
        // substring
        StringBuffer sb5 = new StringBuffer();
        sb5.append("Hello jump to java 5");
        System.out.println(sb5.substring(0, 7));
    }
}
