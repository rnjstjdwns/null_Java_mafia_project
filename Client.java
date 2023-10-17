import java.io.BufferedReader; //BufferedReader import
import java.io.IOException; //IOException import
import java.io.InputStreamReader; //InputStreamReader import
import java.io.PrintWriter; // PrintWriter import
import java.net.Socket; //Socket import
import java.util.Scanner; //Scanner import

public class Client {
    public static void main(String[] args) {
        BufferedReader in = null; //데이터 수신시 필요한 BufferedReader class의 in 인스턴스 생성
        //null을 넣는 이유 : IOException 예외처리는 in==null일때 예외처리를 하기 때문
        PrintWriter out = null; //데이터 출력시 필요한 PrintWriter class의 out 인스턴스 생성
        //null을 넣는 이유 : IOException 예외처리는 in==null일때 예외처리를 하기 때문
        Socket socket = null; //클라이언트 소켓 생성을 위한 Socket class의 socket 인스턴스 생성
        //null을 넣는 이유 : IOException 예외처리는 in==null일때 예외처리를 하기 때문
        Scanner scanner = new Scanner(System.in); //입력시 필요한 Scanner class의 scanner 인스턴스 생성
       
        try { //예외처리 시작
            socket = new Socket("192.168.219.100", 8000); //접속할 IP주소(127.0.0.1[Local]) Port번호(8000) 클라이언트 소켓 생성, 서버 연결
           
            in = new BufferedReader(new InputStreamReader(socket.getInputStream())); //소켓 입력 스트림
            out = new PrintWriter(socket.getOutputStream());//소켓 출력 스트림(출력 포맷 편리함)
           
            while(true) {
                System.out.print("전송하기>>> ");
                String outputMessage = scanner.nextLine(); //전송할 메세지 outputMessage String 객체 생성
                out.println(outputMessage); //데이터 전송 (줄바꿈 포함)
                out.flush();
                if ("quit".equalsIgnoreCase(outputMessage))
                    break; //만약 Server에 보낸 메세지가 quit이라면 입력 종료
                               
                String inputMessage = in.readLine(); //Server로부터 한 행 수신 (inputMessage에 넣음)
                System.out.println("From Server: " + inputMessage); //Server에서 보낸 메세지 출력
                if ("quit".equalsIgnoreCase(inputMessage)) //만약 Server가 quit을 보냈다면 연결 종료
                    break;
            }
        } catch (IOException e) { //예외처리
            System.out.println(e.getMessage());
        } finally {
            try {
                scanner.close(); //입력 scanner 종료
                if (socket != null) socket.close(); //클라이언트 소켓 닫기
                System.out.println("서버연결종료");
            } catch (IOException e) { //예외처리
                System.out.println("소켓통신에러");
            }
        }
    }
}