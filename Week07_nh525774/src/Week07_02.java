import java.io.*;
import java.util.Scanner;

public class Week07_02 {

	public static void main(String[] args) throws IOException{
		int num2;
		String search;
		String num,name, tel, email;
		Scanner scan=null;
		PrintWriter in =new PrintWriter(new FileWriter("user.txt"));
		Scanner s=new Scanner(System.in);
		while(true) {
			System.out.println("번호: ");
			num=s.next();
			System.out.println("이름: ");
			name=s.next();
			System.out.println("전화번호: ");
			tel=s.next();
			System.out.println("이메일: ");
			email=s.next();
			System.out.println("입력이 끝났으면1, 계속하려면0: ");
			num2=s.nextInt();
			in.print(num+','+name+','+tel+','+email+"");
			in.flush();
			if(num2==1)
				break;
			
		}
		in.close();

        // 파일에 저장한 정보를 읽어옴
        try (BufferedReader br = new BufferedReader(new FileReader("user.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                System.out.println("번호: " + parts[0]);
                System.out.println("이름: " + parts[1]);
                System.out.println("전화번호: " + parts[2]);
                System.out.println("이메일: " + parts[3]);
            }
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("입출력 오류가 발생했습니다: " + e.getMessage());
        }

        // 번호 입력에 대한 처리
        System.out.print("전화번호를 검색할 번호를 입력하세요: ");
        search = s.next();

        try (BufferedReader br = new BufferedReader(new FileReader("user.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(search)) {
                    System.out.println("번호: " + parts[0]);
                    System.out.println("이름: " + parts[1]);
                    System.out.println("전화번호: " + parts[2]);
                    System.out.println("이메일: " + parts[3]);
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("입출력 오류가 발생했습니다: " + e.getMessage());
        }

	}

}