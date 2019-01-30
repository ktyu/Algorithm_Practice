import java.util.HashMap;
import java.util.LinkedList;

class Solution {
    
    public String[] solution(String[] record) {

        // 해시맵 => uid : nickname
        HashMap<String, String> nameMap = new HashMap<String, String>();

        // 로그 리스트
        LinkedList<Log> logList = new LinkedList<Log>();


        for(String log : record) {
            String[] words = log.split("\\s");

            if(log.charAt(0) == 'E') {
                nameMap.put(words[1], words[2]);
                logList.add(new Log('E', words[1], null));
            }

            else if(log.charAt(0) == 'L') {
                logList.add(new Log('L', words[1], null));
            }

            else { // Change
                nameMap.put(words[1], words[2]);
            }
        }

        String[] answer = new String[logList.size()];

        int i=0;
        for(Log log : logList) {
            log.nickname = nameMap.get(log.uid);

            if(log.type == 'E') {
                answer[i] = log.nickname + "님이 들어왔습니다.";
            }

            else {
                answer[i] = log.nickname + "님이 나갔습니다.";
            }
            
            i++;
        }

        return answer;
    }

    class Log {
        char type;
        String uid;
        String nickname;

        public Log(char type, String uid, String nickname) {
            this.type = type;
            this.uid = uid;
            this.nickname = nickname;
        }
        
    }

}