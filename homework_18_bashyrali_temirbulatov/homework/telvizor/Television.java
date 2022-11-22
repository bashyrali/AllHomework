package homework.telvizor;

public class Television {
    int currentChannel;
    int maxChannels;
    public Television(int currentChannel, int maxChannels){
        this.currentChannel = currentChannel;
        this.maxChannels = maxChannels;
    }
    public  int nextChannel(int currentChannel) {
        return currentChannel += 1;
    }
    public int previousChannel(int currentChannel) {
        return currentChannel += 1;
    }
    public int toChannel(int toChannel, int currentChannel) {
        return currentChannel = toChannel;
    }
    public static void showChanel(int currentChannel) {
        System.out.println("Current channel is: "+ currentChannel);
    }
}
