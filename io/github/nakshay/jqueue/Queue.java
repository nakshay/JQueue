import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Queue {

    String queueName;
    BlockingQueue<byte[]> blkQueue;

    public Queue(String queueName) {
        this.queueName = queueName;
        blkQueue = new LinkedBlockingQueue();
    }

    protected void write(byte[] element) {
        try {
            blkQueue.offer(element);    
        } catch (Exception e) {
            System.err.println("error while adding element in queue");
        }
    }

    protected byte[] read() {
        try {
         return blkQueue.poll();   
        } catch (Exception e) {
            System.err.println("error while removing element in queue");
        }       
        return new byte[]{};
    }

}