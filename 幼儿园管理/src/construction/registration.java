package construction;
import windows.Window;

import java.io.Serializable;
import java.util.*;
public class registration implements Serializable{
//	�Ǽ�ÿ�յĳ�У��У��Ϣ
	public static void addRecord(Roll r,Date date,String inClassTime,String outClassTime,String expression,String pickUpPerson){
		r.getDairyRecord().add(new dayInformation(date,inClassTime, outClassTime,expression,pickUpPerson));
		
	}
//	�޸�ÿ�ճ�У��У��Ϣ
	
	
}

