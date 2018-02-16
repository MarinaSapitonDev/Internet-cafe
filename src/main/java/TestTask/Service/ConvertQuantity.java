package TestTask.Service;


public class ConvertQuantity {

public static int convertToInt(String quantity){

    int   quantInt= Integer.parseInt(quantity);
    return quantInt;

}

public static int[] quantitysStringToInt(String[] quantitys){

    int[] quantitysArr=new  int[quantitys.length];
    for(int i=0;i<quantitys.length;i++)
        quantitysArr[i]=convertToInt(quantitys[i]);
    return quantitysArr;

    }

}
