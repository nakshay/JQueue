import java.util.ArrayList;
class Registry {

   static ArrayList<Queue> registry;

    static {

         registry = new ArrayList();
    }

    static void addQueue(Queue queue) {
        registry.add(queue);
    }

    static Queue getQueue(Queue queue) {
        for (Queue q : registry) {
            if (q.queueName == queue.queueName) {
                return q;
            }
        }
        return null;
    }

    static boolean isQueueExists(Queue queue) {
        return registry.contains(queue);
    }
}