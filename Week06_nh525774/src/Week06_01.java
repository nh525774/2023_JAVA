import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class Week06_01 {

	public static void main(String[] args) {
		List<String> listOfNames=Arrays.asList("Apple","Bannana","Cherry");
		List<String> lowerCaseList= listOfNames.stream()
				.map(String::toLowerCase)
				.collect(Collectors.toList());
		
		for (String str: lowerCaseList) {
			System.out.println(str);
		}

	}

}
