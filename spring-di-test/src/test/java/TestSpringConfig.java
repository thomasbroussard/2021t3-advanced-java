import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DBSpringConfig.class})
public class TestSpringConfig {

    @Inject
    @Named("myFirstQueryAsBeanConfig")
    String string;

    @Inject
    @Named("mainDS")
    DataSource ds;


    @Test
    public void test(){
        Assert.assertNotNull(string);
    }

}
