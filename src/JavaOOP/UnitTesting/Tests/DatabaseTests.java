package JavaOOP.UnitTesting.Tests;

import JavaOOP.UnitTesting.Database.Database;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTests {
    private Database<Integer> database;

    @Before
    public void doBefore() {
        this.database = new Database<>();
    }

    @Test
    public void addingValues() throws OperationNotSupportedException {
        this.database.add(1);
        this.database.add(2);
        this.database.add(3);

        Assert.assertEquals(3, this.database.size());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addingNullShouldProduceException() throws OperationNotSupportedException {
        this.database.add(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addingMoreElementsFromActualSize() throws OperationNotSupportedException {
        for (int i = 1; i <= 16; i++) {
            this.database.add(i);
        }

        this.database.add(17);
    }

    @Test
    public void removingElementsShouldDecreaseSize() throws OperationNotSupportedException {
        this.database.add(1);
        this.database.add(2);
        this.database.add(3);

        this.database.remove();
        Assert.assertEquals(2, this.database.size());
    }


}
