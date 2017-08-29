// CS1020 (AY2014/5 Semester 4) - Lab 10
//
// Name: Xie Peiyi
// Matric. No.: A01411123B
// Lab group: 1
//
// Write the program description below.
// Sort the tabs in a browers according to creation time or lexcigraphical order.
//
//
//
//
//

import java.util.*;

public class BrowserTabs {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Tab[] p = new Tab[sc.nextInt()];

		for(int i = 0; i < p.length; i++){
			p[i] = new Tab(sc.nextInt(), sc.next(), sc.nextInt());
		}
		List<Tab> list = Arrays.asList(p);
		NameComparator nameComp = new NameComparator();
		TimeComparator timeComp = new TimeComparator();
		NameOnlyComparator nameOnlyComp = new NameOnlyComparator();
		TimeOnlyComparator timeOnlyComp = new TimeOnlyComparator();
		
		int num = sc.nextInt();
		int preOp = sc.nextInt();
		if(preOp == 1) Collections.sort(list, nameComp);
		else Collections.sort(list, timeComp);
		for(int i = 0; i < num - 1; i++){
			int curOp = sc.nextInt();
			switch(curOp){
				case 1:
				if(preOp == 1)
					Collections.sort(list, nameComp);
				else
					Collections.sort(list, nameOnlyComp);
				break;
				case 2:
				if(preOp == 2)
					Collections.sort(list, timeComp);
				else
					Collections.sort(list, timeOnlyComp);
				break;
				default:
				break;
			}
			preOp = curOp;
		}

		for(Tab e: list){
			System.out.println(e);
		}
	}

	static class Tab{
		private int creTime;
		private String url;
		private int id;

		public Tab(int id, String url, int creTime){
			this.id = id;
			this.url = url;
			this.creTime = creTime;
		}

		public int getID(){ return id; }
		public String getName(){ return url; }
		public int getTime(){ return creTime; }

		public String toString(){
			return new Integer(id).toString();
		}

	}

	static class NameComparator implements Comparator<Tab> {
		public int compare(Tab p1, Tab p2) { // Compares its two arguments for order by name
			return p1.getName().compareTo(p2.getName()); 
		}
		public boolean equals(Object obj) {
		    return this == obj;
  		}
	} // end NameComparator

	static class NameOnlyComparator implements Comparator<Tab> {
		public int compare(Tab p1, Tab p2) { // Compares its two arguments for order by name
			if(p1.getTime() != p2.getTime()) return 0;
			return p1.getName().compareTo(p2.getName()); 
		}
		public boolean equals(Object obj) {
		    return this == obj;
  		}
	} // end NameComparator

	static class TimeComparator implements Comparator<Tab> {
		public int compare(Tab p1, Tab p2) { // Compares its two arguments for order by name
			return p1.getTime() - p2.getTime(); 
		}
		public boolean equals(Object obj) {
		    return this == obj;
  		}
	} // end NameComparator

	static class TimeOnlyComparator implements Comparator<Tab> {
		public int compare(Tab p1, Tab p2) { // Compares its two arguments for order by name
			if(p1.getName().compareTo(p2.getName()) != 0) return 0;
			return p1.getTime() - p2.getTime(); 
		}
		public boolean equals(Object obj) {
		    return this == obj;
  		}
	} // end NameComparator

}
