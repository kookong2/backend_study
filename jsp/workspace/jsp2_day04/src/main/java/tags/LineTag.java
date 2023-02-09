package tags;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class LineTag extends SimpleTagSupport{
	
	private String color = "black";
	private Integer size = 5;
	
	

	public void setColor(String color) {
		this.color = color;
	}



	public void setSize(Integer size) {
		this.size = size;
	}



	@Override
	public void doTag() throws JspException, IOException {
		PageContext context = (PageContext)getJspContext();
		JspWriter out = context.getOut();
		
		out.print("<div style='color:" + color + ";'>");
		for(int i = 0; i < size; i++) {
			out.print("*");
		}
		out.print("</div>");
	}
	
}
