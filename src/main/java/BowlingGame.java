public class BowlingGame {

    public int getBowlingScore(String bowlingCode) {
		int sum = 0;
		if(bowlingCode.substring(bowlingCode.length()-2).equals("||")){
			bowlingCode +="0";
		}
		String[] se = bowlingCode.split("\\|\\|");
		String[] str=se[0].split("\\|");
		
		for(int i = 0; i < str.length; i++){
			if((i !=8) && (i !=9) ){
				if(str[i].equals("X")){
					if(str[i+1].equals("X")){
						sum += compute(str[i]+str[i+1]+str[i+2].substring(0, 1));
					}else{
						sum+=compute(str[i]+str[i+1]);
					}
				}else if(str[i].charAt(1) == '/'){
					sum+=compute(str[i]+str[i+1].substring(0, 1));
				}else{
					sum+=compute(str[i]);
				}
			}else if(i != 9){
				if(str[i].equals("X")){
					if(str[i+1].equals("X")){
						sum += compute(str[i]+str[i+1]+se[1].substring(0, 1));
					}else{
						sum+=compute(str[i]+str[i+1]);
					}
				}else if(str[i].charAt(1) == '/'){
					sum+=compute(str[i]+se[1].substring(0, 1));
				}else{
					sum+=compute(str[i]);
				}
			}else{
				sum+=compute(str[i]+se[1]);
			}
		}
		return sum;
    }
	public Integer compute(String s){
		int count = 0;
		for(int i = 0; i < s.length(); i++){
			if(s.substring(i, i+1).equals("X")){
				count += 10;
			}else if(s.substring(i, i+1).equals("/")){
				count +=  (10-Integer.parseInt(s.substring(i-1,i)));
			}else if(s.substring(i, i+1).equals("-")){
				count += 0;
			}else{
				count += Integer.parseInt(s.substring(i,i+1));
			}
		}
		return count;
	}
}
