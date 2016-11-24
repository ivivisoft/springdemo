/*
 *  Copyright (c) 2016, 张威, ivivisoft@gmail.com
 *  
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package springidol;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertEquals;

public class SpringIdolTest {

    private ApplicationContext context;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("spring-idol.xml");
    }


    @Test
    public void testPerformer() {
        Performer performer = (Performer) context.getBean("duke");
        performer.perform();
    }

    @Test
    public void testPoeticPerformer() {
        Performer performer = (Performer) context.getBean("poeticDuke");
        performer.perform();
    }

    @Test
    public void testAuditorium() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-idol.xml");
        Auditorium auditorium = (Auditorium) context.getBean("auditorium");
    }


    @Test
    public void testKennyPerformer() {
        Performer performer = (Performer) context.getBean("kenny");
        performer.perform();
    }

    @Test
    public void testKenny2Performer() {
        Performer performer = (Performer) context.getBean("kenny2");
        performer.perform();
    }


    @Test
    public void testHankPerformer() {
        Performer performer = (Performer) context.getBean("hank");
        performer.perform();
    }

    @Test
    public void testHank1Performer() {
        Performer performer = (Performer) context.getBean("hank1");
        performer.perform();
    }

    @Test
    public void testHank2Performer() {
        Performer performer = (Performer) context.getBean("hank2");
        performer.perform();
    }

    @Test
    public void testSpelDemo() {
        SpelDemo spelDemo = (SpelDemo) context.getBean("spelDemo");
        spelDemo.sayRandomNumber();
    }

    @Test
    public void testCityDemo() {
        CityDemo cityDemo = (CityDemo) context.getBean("cityDemo");
        cityDemo.printCity();
    }

    @Test
    //配置的方式aop传参
    public void testMindRead(){
        Thinker thinker = (Thinker) context.getBean("thinker");
        MindReader mindReader = (MindReader) context.getBean("magician");
        thinker.thinkOfSomething("Queen of Hearts!");

        assertEquals("Queen of Hearts!",mindReader.getThoughts());
    }

    @Test
    //测试注解的方式aop传参
    public void testAspectMindRead(){
        Thinker thinker = (Thinker) context.getBean("thinker");
        MindReader mindReader = (MindReader) context.getBean("magicianAspect");
        thinker.thinkOfSomething("Queen of Hearts!");

        assertEquals("Queen of Hearts!",mindReader.getThoughts());
    }

    @Test
    public void testRefAOP(){
        Contestant contestant = (Contestant) context.getBean("hank2");
        contestant.receiveAward();
    }
}
