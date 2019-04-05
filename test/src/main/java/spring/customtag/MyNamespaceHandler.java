package spring.customtag;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @author:jiliang
 * @Date:2019/4/5
 * @Time:13:53
 */
public class MyNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("user", new UserBeanDefinitionParser());
    }
}
