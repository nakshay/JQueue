class Protocol {

    private static char newQueue = '+';
    private static char newMessage = '!';
    private static char readMessage = '?';
    private static String message;

    protected static void parseMessage(byte[] message){
        this.message = new String(message);
    }


}