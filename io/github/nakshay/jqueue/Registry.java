import java.util.ArrayList;
class Registry {

   static ArrayList<MessageQueue> registry;

    static {

         registry = new ArrayList();
    }

    static void addQueue(MessageQueue queue) {
        registry.add(queue);
    }

    static MessageQueue getQueue(String queueName) {
        for (MessageQueue q : registry) {
            if (q.queueName.equals(queueName)) {
                return q;
            }
        }
        return null;
    }


    static boolean isQueueExists(MessageQueue queue) {
        return registry.contains(queue);
    }
}