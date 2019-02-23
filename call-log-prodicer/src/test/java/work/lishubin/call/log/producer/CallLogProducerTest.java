package work.lishubin.call.log.producer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author 李树彬
 * @date 2019/2/23  0:40
 */
public class CallLogProducerTest {

    private CallLogProducer callLogProducer;

    @Before
    public void init(){
        callLogProducer = new CallLogProducer();
        callLogProducer.init();
    }

    @Test
    public void productTest(){

        System.out.println();

    }

}