package random.main;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import random.model.CoinService;
import random.model.DiceService;

@Configuration
@PropertySource("classpath:application.properties")
public class SpringBeanConfig {
    @Bean
    public DiceService diceBean() {
        return new DiceService();
    }

    @Bean
    @Scope("singleton")
    public CoinService fairCoinBean() {
        return new CoinService(0.5);
    }

    @Bean
    @Scope("prototype")
    public CoinService biasCoinBean() {
        CoinService cs = new CoinService();
        cs.setChance(0.1);
        return cs;
    }

    @Value("${coin.headChance}") double value;
    @Value("${coin.tailChance}")double test;

    @Bean
    public CoinService propertyCoinBean() {
        return new CoinService(test);
    }
}
