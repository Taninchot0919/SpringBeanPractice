package random.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import random.model.CoinService;
import random.model.DiceService;

public class RandomMain {
    public static void main(String[] args) {

//          * - random01 - xml configuration: 1-4
//          ไปหา Context Xml ก่อน
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//          * 1. diceBean - IoC
        DiceService diceBean = (DiceService) context.getBean("diceBean");
//          * 2. fairCoinBean - DI constructor injection 0.5
        CoinService csFairCoinBean = (CoinService) context.getBean("fairCoinBean");
        System.out.println(csFairCoinBean.getChanceOfHead());
//          * 3. biasCoinBean - DI setter injection 0.1
        CoinService csBiasCoinBean = (CoinService) context.getBean("biasCoinBean");
        System.out.println(csBiasCoinBean.getChanceOfHead());
//          * 4. propertyCoinBean - DI setter injection read from property file
        CoinService propertyCoinBean = (CoinService) context.getBean("propertyCoinBean");
        System.out.println(propertyCoinBean.getChanceOfHead());
        System.out.println("---------------------------------------------------- \n");
        context.close();

//          * - random03 - java class with component scanning: 1 and one of 2,3,4
        System.out.println("Spring Bean Configuration using Java Class\n");
//        หลังวงเล็บของ AnnotationConfig คือไปจัดการ Bean ที่ไหน คล้ายๆกับ xml
        AnnotationConfigApplicationContext annotation = new AnnotationConfigApplicationContext(SpringBeanConfig.class);
        //          * 1. diceBean - IoC
        DiceService dice = (DiceService) annotation.getBean("diceBean");
        //          * 2. fairCoinBean - DI constructor injection 0.5
        CoinService csFair = (CoinService) annotation.getBean("fairCoinBean");
        System.out.println(csFair.getChanceOfHead());
        //          * 3. biasCoinBean - DI setter injection 0.1
        CoinService csBias = (CoinService) annotation.getBean("biasCoinBean");
        System.out.println(csBias.getChanceOfHead());
        //          * 4. propertyCoinBean - DI setter injection read from property file
        CoinService csProperty = (CoinService) annotation.getBean("propertyCoinBean");
        System.out.println(csProperty.getChanceOfHead());
        annotation.close();
    }
}