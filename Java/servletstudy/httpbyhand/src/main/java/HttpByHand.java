import java.io.*;
import java.net.Socket;

public class HttpByHand {
    public static void main(String[] args) throws IOException{
        Socket s = new Socket("www.baidu.com", 80);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        bw.write("GET / HTTP/1.1");
        bw.newLine();
        bw.write("Host: www.baidu.com:80");
        bw.newLine();
        bw.write("Content-Type: text/html");
        bw.newLine();
        bw.newLine();
        bw.flush();
        BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
        String str = null;
        while ((str = br.readLine()) != null) {
            System.out.println(str);
        }
        bw.close();
        br.close();
        s.close();
    }
}
