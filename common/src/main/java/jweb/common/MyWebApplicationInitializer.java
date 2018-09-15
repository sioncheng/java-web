package jweb.common;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public interface MyWebApplicationInitializer {

    void onStartup(ServletContext var1) throws ServletException;
}
