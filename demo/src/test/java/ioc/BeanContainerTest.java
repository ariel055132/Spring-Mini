package ioc;

import org.framework.beans.factory.BeanFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BeanContainerTest {
    @Test
    public void testGetBean() {
        BeanFactory beanFactory = new BeanFactory();
        beanFactory.registerBean("testService", new TestService());
        TestService testService = (TestService) beanFactory.getBean("testService");
        Assertions.assertNotNull(testService);
        Assertions.assertEquals(testService.test(), "Test");
    }

    class TestService {
        private String test() {
            System.out.println("Test");
            return "Test";
        }
    }
}
