package ioc;

import org.framework.beans.factory.BeanFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BeanContainerTest {
    @Test
    @DisplayName("Test Get Bean (not null)")
    public void testGetBean() {
        BeanFactory beanFactory = new BeanFactory();
        beanFactory.registerBean("testService", new TestService());
        // Get testService from beanFactory
        TestService testService = (TestService) beanFactory.getBean("testService");
        Assertions.assertNotNull(testService);
        System.out.println(testService.test());
        Assertions.assertEquals(testService.test(), "Test");
    }

    @Test
    @DisplayName("Test Null Check")
    public void testNull() {
        BeanFactory beanFactory = new BeanFactory();
        beanFactory.registerBean("testService", new TestService());
        TestService testService = (TestService) beanFactory.getBean("test");
        Assertions.assertNull(testService);
    }

    class TestService {
        private String test() {
            return "Test";
        }
    }
}
