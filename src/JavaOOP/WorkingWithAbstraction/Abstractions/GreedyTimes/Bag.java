package JavaOOP.WorkingWithAbstraction.Abstractions.GreedyTimes;

import java.util.HashMap;

public class Bag {
    private HashMap<String, HashMap<String, Long>> inventory;
    private long maxCapacity;
    private long currCapacity;
    private long currGold;
    private long currGems;
    private long currCash;

    public Bag(long maxCapacity) {
        this.inventory = new HashMap<>();
        this.maxCapacity = maxCapacity;
        this.currCapacity = 0;
        this.currGold = 0;
        this.currGems = 0;
        this.currCash = 0;
    }

    public void addGold(String item, long amount) {
        if (itIsFull(amount)) { return; }

        currGold += amount;
        currCapacity += amount;
        addingValues(item, amount, item);
    }

    public void addGems(String itemToAdd, long amount) {
        if (itIsFull(amount)) { return; }
        if (! lessOrEqual(this.currGold, this.currGems, amount)) { return; }

        currGems += amount;
        currCapacity += amount;
        String item = "Gem";
        addingValues(itemToAdd, amount, item);
    }

    public void addCash(String itemToAdd, long amount) {
        if (itIsFull(amount)) { return; }
        if (! lessOrEqual(this.currGems, this.currCash, amount)) { return; }

        currCash += amount;
        currCapacity += amount;
        String item = "Cash";
        addingValues(itemToAdd, amount, item);
    }

    private void addingValues(String itemToAdd, long amount, String item) {
        this.inventory.putIfAbsent(item, new HashMap<>());
        this.inventory.get(item).putIfAbsent(itemToAdd, 0L);
        this.inventory.get(item).put(itemToAdd, this.inventory.get(item).get(itemToAdd) + amount);
    }

    private boolean itIsFull(long amount) {
        return maxCapacity < currCapacity + amount;
    }

    private boolean lessOrEqual(long biggerAmount, long smallerAmount, long amount) {
        return biggerAmount >= smallerAmount + amount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (hasKey("Gold")) {
            sb.append(String.format("<Gold> $%d%n", this.currGold));
            sb.append(String.format("##Gold - %d%n", this.currGold));
        }
        if (hasKey("Gem")) {
            sb.append(String.format("<Gem> $%d%n", this.currGems));
            SortAndAppend(sb, "Gem");
        }
        if (hasKey("Cash")) {
            sb.append(String.format("<Cash> $%d%n", this.currCash));
            SortAndAppend(sb, "Cash");
        }

        return sb.toString();
    }

    private boolean hasKey(String key) {
        return this.inventory.containsKey(key);
    }

    private void SortAndAppend(StringBuilder sb, String key) {
        this.inventory.get(key).entrySet().stream()
                .sorted((f, s) -> {
                    int result = s.getKey().compareTo(f.getKey());

                    if (result == 0) {
                        result = f.getValue().compareTo(s.getValue());
                    }

                    return result;
                }).forEach(wealth -> sb.append(String.format("##%s - %d%n", wealth.getKey(), wealth.getValue())));
    }
}
