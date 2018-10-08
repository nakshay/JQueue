class Protocol {

    private final char newQueue = '+';
    private final char newMessage = '!';
    private final char readMessage = '?';
    private final char listQueues = '&';
    private final char deleQueue = '~';
    private final String message;

    protected Protocol(byte[] message){
        this.message =  new String(message).trim();
    }

    protected String process() {

        String retMessage = "";
        String queueName = "";
        MessageQueue mq = null;
        String msg ="";
        char ch = message.charAt(0);
        switch (ch) {
            case newQueue:

                 queueName = message.substring(1,message.length());
                retMessage = "New queue created "+queueName ;
                 mq = new MessageQueue(queueName);
                Registry.addQueue(mq);
                break;

            case newMessage :
                 queueName =  message.substring(message.indexOf(newMessage)+1, message.lastIndexOf(newMessage));
                msg = message.substring(message.lastIndexOf(newMessage)+1,message.length());
                mq = Registry.getQueue(queueName);

                if(mq != null) {
                    mq.write(msg);
                    retMessage = "New message :  "+msg +" added in queue "+ queueName;

                } else {
                    retMessage = "queue does not exist while adding message";
                }
                break;

            case readMessage :
                     queueName = message.substring(1,message.length());
                    

                    mq = Registry.getQueue(queueName);
                    if(mq != null) {
                        
                        msg = mq.read();
                        if(msg!=null) {
                            retMessage ="Message is "+ msg;
                        } else {
                            retMessage ="Queue is empty";
                        }    
                    } else {
                        retMessage= "queue does not exist while reading message";
                    }
                break;

            case deleQueue:    
                queueName = message.substring(1,message.length());
                if(Registry.deleteQueue(queueName)) {
                    retMessage =" queue delete from Registry";
                }else{
                    retMessage = "queue not found in the Registry";
                }

                break;

            case listQueues :
                retMessage =  Registry.getAllQueues();
                    break;
            default:
            retMessage = "unknown command";
        }
        return retMessage;
    }

}