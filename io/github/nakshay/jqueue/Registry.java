import java.util.ArrayList;
import java.util.List;
class Registry {

   static List<MessageQueue> registry;

    static {

         registry = new ArrayList<MessageQueue>();
    }

    static void addQueue(MessageQueue queue) {

        if(!isQueueExists(queue)){
            registry.add(queue);
        }
    }

    static MessageQueue getQueue(String queueName) {
        for (MessageQueue q : registry) {
            if (q.queueName.equals(queueName)) {
                return q;
            }
        }
        return null;
    }

    static String getAllQueues() {
        String queueList = "";
        for (MessageQueue q : registry) {
            queueList +=  q.queueName+", ";
        }
        return queueList;
    }

    static boolean isQueueExists(MessageQueue queue) {

        for (MessageQueue q : registry) {
            if(q.queueName.equals(queue.queueName)) {
                return true;
            }
        }
        return false;
    }
}