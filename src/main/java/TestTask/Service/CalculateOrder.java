package TestTask.Service;

import java.util.ArrayList;
import java.util.List;


public class CalculateOrder {

    public static List<CoffeeItemValues> values=null;
    private String[] coffetypes;
    private int[] quantitys;
    private  String m;
    private  String x;
    private  String n;
    public double delivery;
    public double sum;
    public static double result=0;

    public CalculateOrder(String[] coffetypes,int[] quantitys) {

        this.coffetypes=new String[coffetypes.length];
        this.quantitys=new int[coffetypes.length];
        this.coffetypes=coffetypes;
        this.quantitys=quantitys;
        setConfigurations();
        calculateResult();

    }


   private void calculateResult(){
       calculateCoffee();
       calculateDelivery();
       result=delivery+sum;
   }

   private void calculateCoffee(){
        values=new ArrayList<CoffeeItemValues>();
        ServiceCoffee sc=new ServiceCoffee();
        Integer N=Integer.parseInt(n);
        for (int i=0;i<quantitys.length;i++) {
            double costOneType=0;
            double priceOneType=sc.getPrice(coffetypes[i]);
            for(int j=1;j<=quantitys[i];j++)
                if (!(j % N == 0))
                    costOneType = costOneType + priceOneType;

            sum=sum+costOneType;

            CoffeeItemValues value=new CoffeeItemValues();
            value.setPrice(priceOneType);
            value.setType(coffetypes[i]);
            value.setQuantity(quantitys[i]);
            value.setResult(costOneType);
            values.add(value);
        }
   }

   private void calculateDelivery(){

        double X=Double.parseDouble(x);
        if(sum<X)
        delivery=Double.parseDouble(m);
        else delivery=0;

   }


   private void setConfigurations(){

       ServiceConfiguration configuration=new ServiceConfiguration();
       m=configuration.getValue("m");
       x=configuration.getValue("x");
       n=configuration.getValue("n");
   }

}
