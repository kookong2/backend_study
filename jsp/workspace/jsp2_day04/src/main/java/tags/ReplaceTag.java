package tags;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ReplaceTag extends SimpleTagSupport{
	
	private String src;
	private String dest;
	
	

	public void setSrc(String src) {
		this.src = src;
	}



	public void setDest(String dest) {
		this.dest = dest;
	}



	@Override
	public void doTag() throws JspException, IOException {
		JspContext context = getJspContext();
		JspWriter out = context.getOut();
		JspFragment body = getJspBody();
		
		StringWriter writer = new StringWriter();
		body.invoke(writer);
		
		String text = writer.toString();
		text = text.replace(src, dest);
		out.print(text);
	}
	
}
