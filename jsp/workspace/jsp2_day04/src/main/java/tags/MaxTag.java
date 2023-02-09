package tags;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MaxTag extends SimpleTagSupport implements DynamicAttributes{

	private Map<String, String> attrs = new HashMap<>();
	private String var;
	
	
	
	
	public void setVar(String var) {
		this.var = var;
	}

	@Override
	public void doTag() throws JspException, IOException {
		
		JspContext jspContext = getJspContext();
		
		int num1 = Integer.valueOf(attrs.get("num1"));
		int num2 = Integer.valueOf(attrs.get("num2"));
		
		int max = num1;
		if(num1 < num2) max = num2;
		
		jspContext.setAttribute(var, max);
	}

	@Override
	public void setDynamicAttribute(String uri, String name, Object value) throws JspException {
		attrs.put(name, String.valueOf(value));
		
	}
	
}
