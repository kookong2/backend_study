package tags;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class itemsTag extends SimpleTagSupport {
	
	private String marker;
	

	public void setMarker(String marker) {
		this.marker = marker;
	}
	

	public String getMarker() {
		return marker;
	}


	@Override
	public void doTag() throws JspException, IOException {
		JspFragment body = getJspBody();
		body.invoke(null);
		
	}
	
}
