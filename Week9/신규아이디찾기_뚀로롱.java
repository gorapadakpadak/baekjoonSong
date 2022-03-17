class Solution {
    public String solution(String new_id) {
        String answer = "";
        //step1
        answer=new_id.toLowerCase();

        //step2 :정수를 char로 받으니까 '0','9'이렇게 표현해줘야함
        String step2="";
        for(int i=0;i<answer.length();i++){
            char c=answer.charAt(i);
            if(c=='.'||c=='_'||c=='-'||(c>='0'&&c<='9')||(c>='a'&&c<='z')){
                step2+=c;
            }
        }
        answer=step2;

        //step3 : 못 풀었음
        String step3 = step2.toString().replace("..", ".");
        while (step3.contains("..")) {
            step3 = step3.replace("..", ".");
        }
        answer=step3;


        //step4 : step4의 길이가 0보다 커야 4단계 테스트를 수행할 수 있음 주의
        String step4=answer;
        if(step4.length()>0){
            if(answer.charAt(0)=='.'){
                step4=answer.substring(1,answer.length());
            }
        }
        if(step4.length()>0){
            if(step4.charAt(step4.length()-1)=='.'){
                step4=step4.substring(0,step4.length()-1);
            }
        }
        answer=step4;

        //step5
        if(answer.equals("")){
            answer="a";
        }

        //step6 : 자르고 맨뒤 마침표 확인
        String step6 = answer;
        if (step6.length() >= 16) {
            step6 = step6.substring(0, 15);

            if (step6.charAt(step6.length() - 1) == '.') {
                step6 = step6.substring(0, step6.length() - 1);
            }
            answer=step6;
        }

        //step7
        String step7=answer;
        if(answer.length()<3){
            while(step7.length()<3){
                step7+=answer.charAt(answer.length()-1);
            }
            answer=step7;
        }

        return answer;
    }
}