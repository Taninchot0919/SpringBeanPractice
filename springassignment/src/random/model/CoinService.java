package random.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

public class CoinService implements RandomService {
    double chanceOfHead;

    public CoinService() {
    }

    public CoinService(double chanceOfHead) {
        this.chanceOfHead = chanceOfHead;
    }

    public void setChance(double chance) {
        chanceOfHead = chance;
    }

    public double getChanceOfHead() {
        return chanceOfHead;
    }

    @Override
    public String getStringValue() {
        // random 0-1 and return as string "tail" or "head"
        return Math.random() < chanceOfHead ? "Head" : "Tail";
    }

}
