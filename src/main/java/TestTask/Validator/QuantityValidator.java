package TestTask.Validator;
import TestTask.Model.TypeQuantitys;


public class QuantityValidator  {

private int[]convertedQuantitysToInt=null;

public boolean isValid( TypeQuantitys tg){

 convertedQuantitysToInt=new int[tg.getQuantitys().length];

    for (int i = 0; i < tg.getQuantitys().length; i++) {

        String valueString = tg.getQuantity(i);

        if(notInteger(valueString, i)){

            return false;
        }

        if(isEmpty(valueString)){

            return false;
        }

        if(lessThanZero(convertedQuantitysToInt[i])) {

            return false;

        }

    }

    return true;
}

boolean notInteger (String val,int i) {
    int valInt=0;
    try {
        Integer.parseInt(val);
        convertedQuantitysToInt[i]=valInt;
        return false;
    }

    catch (Exception e){
        return  true;
    }


}

boolean lessThanZero(int value){

        if(value<0)
        {
            return true;
        }
        else
            return false;
}




boolean isEmpty(String value){

        if(value==null|value=="")
        {
            return true;
        }
        else
            return false;
    }


}
