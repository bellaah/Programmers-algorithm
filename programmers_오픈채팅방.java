import java.util.*;

public class programmers_오픈채팅방_0106 {

	public static void main(String[] args) {
		String[] a = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		String[] b = solution(a);
		for(int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}

	}
	
	public static String[] solution(String[] record) {
		List<String> answerList = new ArrayList<String>();
        HashMap<String , String> map = new HashMap<String , String>();

        for(int i = 0; i < record.length; i++) {
        	String[] userRecord = record[i].split(" ");
        	if(userRecord[0].equals("Enter") || userRecord[0].equals("Change")) {
        		map.put(userRecord[1], userRecord[2]);
        	}
        }
        
        for(int i = 0; i < record.length; i++) {
        	String[] userRecord = record[i].split(" ");
        	switch(userRecord[0]) {
        		case "Enter":
        			answerList.add(map.get(userRecord[1])+"님이 들어왔습니다.");
        			break;
        		case "Leave":
        			answerList.add(map.get(userRecord[1])+"님이 나갔습니다.");
        	}
        }
        
        String[] answer = new String[answerList.size()];
        answerList.toArray(answer);
        return answer;
    }

}
