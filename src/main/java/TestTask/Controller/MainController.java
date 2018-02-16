package TestTask.Controller;
import TestTask.Model.*;
import TestTask.Service.*;
import TestTask.Validator.QuantityValidator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;


@Controller
public class MainController {

   @RequestMapping(value = "/")
    public ModelAndView showCoffeeList() {

      ServiceCoffee sc=new ServiceCoffee();
      sc.putInListCoffees();
      ModelAndView modelAndView = new ModelAndView();
      modelAndView.addObject("coffees",ServiceCoffee.coffees);
      modelAndView.addObject("typeQuant",new TypeQuantitys());
      modelAndView.setViewName("order");
      return modelAndView;
    }


    @RequestMapping(value = "/calculate-order")
    public ModelAndView showOrder(@Valid @ModelAttribute("typeQuant")  TypeQuantitys tq) {

       ModelAndView modelAndView = new ModelAndView();
       QuantityValidator quantitysValidator=new QuantityValidator();
       if(!quantitysValidator.isValid(tq)){
            modelAndView.addObject("typeQuant", tq);
            modelAndView.addObject("coffees",ServiceCoffee.coffees);
            modelAndView.addObject("error_code","errors");
            modelAndView.setViewName("order");
            return  modelAndView;
       }
        CalculateOrder calc=new CalculateOrder(tq.getTypes(),ConvertQuantity.quantitysStringToInt(tq.getQuantitys()));
        modelAndView.addObject("delivery", calc.delivery);
        modelAndView.addObject("allPrice", calc.sum);
        modelAndView.addObject("result", calc.result);
        modelAndView.addObject("values", CalculateOrder.values);
        modelAndView.addObject("order", new CoffeeOrder());
        modelAndView.setViewName("orderlist");
        return  modelAndView;

    }


    @RequestMapping(value = "/add-order")
    public ModelAndView showConfirmPage(@Valid  @ModelAttribute("order")  CoffeeOrder order, BindingResult result)
    {
        ModelAndView modelAndView = new ModelAndView();
        if (result.hasErrors()) {
             modelAndView.setViewName("orderlist");
             return modelAndView ;
        }

        DatesInDBAdder adder = new DatesInDBAdder(order,CalculateOrder.result,CalculateOrder.values);
        adder.addDatesToDB();
        modelAndView.setViewName("confirm");
        return modelAndView;
    }

}