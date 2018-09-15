package jweb.web1;

import jweb.common.MyWebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebApplicationInitializer1 implements MyWebApplicationInitializer {

    public void onStartup(ServletContext var1) {
        System.out.println("WebApplicationInitializer1#onStartup");

        ServletRegistration.Dynamic servletRegistration1 = var1.addServlet("servlet1", new Servlet1());
        servletRegistration1.addMapping("/serv1");

        ServletRegistration.Dynamic servletRegistration2 = var1.addServlet("servlet2", new Servlet2());
        servletRegistration2.addMapping("/serv2");
    }
}
