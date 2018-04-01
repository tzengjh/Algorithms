import java.util.Scanner;

public class Reward{

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String name;
		int fight,fame,ability;
		boolean isMember, isOfficer;
		int maxReward = 0, r = 0, sum = 0;
		String firstPerson = ""; 
		int N = sc.nextInt();
	    for(int i = 0; i < N; i++){
	    	name = sc.next();
	    	fight = sc.nextInt();
	    	fame = sc.nextInt();
	    	isOfficer = sc.next().equals("Y");
	    	isMember = sc.next().equals("Y");
	    	ability = sc.nextInt();
	    	r = reward(fight, fame, isOfficer, isMember, ability);
	    	if(r > maxReward){
	    		maxReward = r;
	    		firstPerson = name;
	    	}
	    	sum += r;
	    }
	    sc.close();
	    System.out.println(firstPerson);
	    System.out.println(maxReward);
	    System.out.println(sum);
	}

	/**
	* 1.作战能力＞80，并且至少有一项特殊能力的人，每人8000银鹿
	* 2.作战能力＞85，并且声望＞80的人，每人4000银鹿
	* 3.作战能力＞90，每人2000银鹿
	* 4.作战能力＞85的灼人部成员每人1000银鹿
	* 5.声望＞80的军官每人850银鹿
	*/
	private static int reward(int fight, int fame, boolean isOfficer, boolean isMember, int ability){
		int sum = 0;
		if(fight > 80 && ability > 0)
			sum += 8000;
		if(fight > 85 && fame > 80)
			sum += 4000;
		if(fight > 90)
			sum += 2000;
		if(fight > 85 && isMember)
			sum += 1000;
		if(fame > 80 && isOfficer)
			sum += 850;
		return sum;
	}
}
