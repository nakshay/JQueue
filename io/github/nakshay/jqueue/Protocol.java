class Protocol {
    char newQueue = '+';
    char newMessage = '!';
    char readMessage = '?';

    String message;

    private void parseMessage(byte[] message){
        this.message = new String(message);
    }


}