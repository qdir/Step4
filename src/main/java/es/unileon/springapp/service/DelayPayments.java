package es.unileon.springapp.service;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.springsource.vfabric.licensing.log.LogFactory;

import sun.rmi.runtime.Log;

public class DelayPayments {

    /** Logger for this class and subclasses */
    //protected final Log logger = LogFactory.getLog(getClass());

    @Min(0)
    @Max(50)
    private int percentage;

    public void setPercentage(int i) {
        percentage = i;
        //logger.info("Percentage set to " + i);
    }

    public int getPercentage() {
        return percentage;
    }
}