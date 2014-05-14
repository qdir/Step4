package es.unileon.springapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.unileon.springapp.service.DelayPayments;
import es.unileon.springapp.service.FinancialProduct;

@Controller
@RequestMapping(value="/priceincrease.htm")
public class PriceIncreaseFormController {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private FinancialProduct productManager;

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(@Valid DelayPayments priceIncrease, BindingResult result)
    {
        if (result.hasErrors()) {
            return "priceincrease";
        }
		
        int increase = priceIncrease.getPercentage();
        logger.info("Increasing prices by " + increase + "%.");

        productManager.increasePrice(increase);

        return "redirect:/hello.htm";
    }

    @RequestMapping(method = RequestMethod.GET)
    protected DelayPayments formBackingObject(HttpServletRequest request) throws ServletException {
        DelayPayments priceIncrease = new DelayPayments();
        priceIncrease.setPercentage(15);
        return priceIncrease;
    }

    public void setProductManager(FinancialProduct productManager) {
        this.productManager = productManager;
    }

    public FinancialProduct getProductManager() {
        return productManager;
    }

}