package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.eduard.component.pojo.User;

// It's not possible here to use Spring autowire here because of @ScenarioScope annotation in com.eduard.config.
// @ScenarioScope is Cucumber context annotation. Spring context doesn't know about it. But Cucumber context doesn't run here.
// @RunWith(SpringJUnit4ClassRunner.class) won't help.
public class UserUnitTest {
  private User user;

  @Before
  public void prepare() {
    this.user = new User("John Wick", 21);
  }

  @Test
  public void userAgeTest() {
    int expectedAge = 21;
    int actualAge = user.getAge();
    Assert.assertEquals(expectedAge, actualAge);
  }

  @Test
  public void userNameTest() {
    String expectedName = "John Wick";
    String actualName = user.getName();
    Assert.assertEquals(expectedName, actualName);
  }
}
