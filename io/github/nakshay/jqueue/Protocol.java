class Protocol {

    private final char newQueue = '+';
    private final char newMessage = '!';
    private final char readMessage = '?';
    private final String message;

    protected Protocol(byte[] message){
        this.message =  new String(message).trim();
    }

    protected void process() {
        String queueName = "";
        MessageQueue mq = null;
        char ch = message.charAt(0);
        switch (ch) {
            case newQueue:

                 queueName = message.substring(1,message.length());
                System.out.println("New queue created "+queueName);
                 mq = new MessageQueue(queueName);
                Registry.addQueue(mq);

                break;

            case newMessage :
                 queueName =  message.substring(message.indexOf(newMessage)+1, message.lastIndexOf(newMessage));
                String msg = message.substring(message.lastIndexOf(newMessage)+1,message.length());

                System.out.println("New message :  "+msg +"added in queue "+ queueName);

                mq = Registry.getQueue(queueName);
                System.out.println(mq.queueName);
                if(mq != null) {
                    mq.write(msg);

                } else {
                    System.out.println("queue does not exist while adding message");
                }
                break;

            case readMessage :
                     queueName = message.substring(1,message.length());
                    System.out.println("read message from "+ queueName);

                    mq = Registry.getQueue(queueName);
                    if(mq != null) {
    
                        System.out.println("Message is "+ mq.read());
    
                    } else {
                        System.out.println("queue does not exist while reading message");
                    }
                
                break;
                
            default:
            System.out.println("unknown command");
        }
    }

}