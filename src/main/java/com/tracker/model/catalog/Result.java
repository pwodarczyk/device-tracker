package com.tracker.model.catalog;

import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("restriction")
@XmlRootElement(name="results")
public class Result<T> {

	private Map<String, String> terms;
	private int count;
	private List<T> results;
	private String exception;
	
	public Map<String, String> getTerms() {
		return terms;
	}
	public void setTerms(Map<String, String> terms) {
		this.terms = terms;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<T> getResults() {
		return results;
	}
	public void setResults(List<T> results) {
		this.results = results;
	}
	public void setException(String exception) {
		this.exception = exception;
	}
	public String getException() {
		return exception;
	}
	@Override
	public String toString() {
		return "Result [terms=" + terms + ", count=" + count + ", results="
				+ results + ", exception=" + exception + "]";
	}
	
	
}
