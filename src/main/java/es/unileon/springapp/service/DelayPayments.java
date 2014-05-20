package es.unileon.springapp.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DelayPayments {

	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());

	private String date;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}