package number;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class MaxNumberModuleTest {
    @Test
    public void testMaxNumber(){
        MaxNumberModule maxNumberModule = new MaxNumberModule();
        int[] testArray = new int []{-4, 323, 53434, 455, 6, 9};

        assertThat(maxNumberModule.getMax(testArray)).isEqualTo(53434);
    }

}