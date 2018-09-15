package jweb.common;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.annotation.HandlesTypes;
import java.lang.reflect.Modifier;
import java.util.Set;

@HandlesTypes(MyWebApplicationInitializer.class)
public class MyServletContainerInitializer implements ServletContainerInitializer {

    public void onStartup(Set<Class<?>> set, ServletContext servletContext) {
        System.out.println("MyServletContainerInitializer#onStartup");
        for (Class<?> cls :
                set) {
            System.out.println(cls.getName());

            if (isInstantiatableMyWebApplicationInitializer(cls)) {
                try {
                    MyWebApplicationInitializer mwi = (MyWebApplicationInitializer)cls.newInstance();
                    mwi.onStartup(servletContext);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    private boolean isInstantiatableMyWebApplicationInitializer(Class<?> cls) {
        return MyWebApplicationInitializer.class.isAssignableFrom(cls)
                && !cls.isInterface()
                && !Modifier.isAbstract(cls.getModifiers());
    }
}
