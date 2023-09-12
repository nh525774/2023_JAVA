class Sports{
	String getName() {return "아직 결정되지 않음";}
	int getPlayers() {return 0;}
}	

class Soccer extends Sports{
@Override
	public String getName() {System.out.println("경기이름: 축구");
	return null;
}
@Override
	public int getPlayers() {System.out.println("경기자수: 11");
	return 0;
	
	}
}
public class Week02_02 {

	public static void main(String[] args) {
		Soccer sc=new Soccer();
		sc.getName();
		sc.getPlayers();
	}}
	
