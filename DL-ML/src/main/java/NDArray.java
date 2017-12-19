import org.junit.Test;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

/**
 * @author zhongailing(zhongailing@daojia.com)
 * @version V1.0
 * @Description:
 * @date Created in 2017-12-7 10:11
 */

public class NDArray {
    @Test
    public  void test(){
        INDArray x= Nd4j.create(new double[]{1,2,3,4,5,6},new int[]{3,2});
        x.add(1);
        System.out.println(x);
    }

    @Test
    public  void test2(){
        //create 参数 （数组真实值，向量--矩阵形状）
        INDArray x= Nd4j.create(new double[]{1,2,3,4,5,6},new int[]{3,2});
        INDArray y= Nd4j.create(new double[]{6,5,4,3,2,1},new int[]{3,2});
        x.add(y);
        x.sub(y);
        x.mul(y);
        x.div(y);
        System.out.println(x);
    }

    public void test4(){
        MultiLayerConfiguration conf = new NeuralNetConfiguration.Builder()
                .iterations(1)
                .weightInit(WeightInit.XAVIER)
                .activation("relu")
                .optimizationAlgo(OptimizationAlgorithm.STOCHASTIC_GRADIENT_DESCENT)
                .learningRate(0.05)
                // ... other hyperparameters
                .list()
                .backprop(true)
                .build();
    }


}
