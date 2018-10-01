import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.BlockingQueue;

class MessageQueue {

    String queueName;
    BlockingQueue<String> blkQueue;

    public MessageQueue(String queueName) {
        this.queueName = queueName;
        blkQueue = new LinkedBlockingQueue();
    }

    protected void write(String element) {
        try {
            blkQueue.offer(element);    
        } catch (Exception e) {
            System.err.println("error while adding element in queue");
        }
    }

    protected String read() {
        try {
         return blkQueue.poll();
        } catch (Exception e) {
            System.err.println("error while removing element in queue");
        }       
        return new String("");
    }

}