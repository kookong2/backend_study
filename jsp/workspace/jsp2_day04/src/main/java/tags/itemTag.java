package tags;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class itemTag extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		JspContext context = getJspContext();
		JspWriter out = context.getOut();
		JspFragment body = getJspBody();
		JspTag parent = getParent();
		out.print("<div>");
		
		if(parent != null) {
			if(!(parent instanceof itemsTag)) {
				throw new JspException("호환되지 않는 태그 입니다.");
			}
			
			itemsTag itemTag = (itemsTag)parent;
			String marker = itemTag.getMarker();
			out.print(marker);
		}
		body.invoke(null);
		out.print("</div>");
	}
	
}
