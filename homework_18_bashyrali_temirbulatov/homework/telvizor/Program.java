package homework.telvizor;

public class Program {
    public static void main(String[] args) {
        Television tv = new Television(1,100);
        Channel[] channels = new Channel[tv.maxChannels];
        
        for (int i = 0; i < channels.length; i++) {
            channels[i] = new Channel();
            channels[i].channelId = i+1;
            channels[i].channelName = "Name"+ String.valueOf(i+1);
            
        }
        
        boolean start = true;
        while (start) {
            Television.showChanel(tv.currentChannel);
            System.out.println("Enter + to next Channel, - to previous channel, choose number of channel(1-100), or enter stop for stop programm");
            String user = System.console().readLine();
            if (user.equals("+")) {
                tv.currentChannel= tv.nextChannel(tv.currentChannel);
                showName(tv.currentChannel, channels);
            }
            else if(user.equals("-")){
                tv.currentChannel = tv.previousChannel(tv.currentChannel);
                showName(tv.currentChannel, channels);
            }
            else if (isDigit(user) == true) {
                int userId = Integer.parseInt(user);
                if (userId > 0 && userId < 101) {
                    tv.currentChannel = tv.toChannel(userId, tv.currentChannel);
                    showName(tv.currentChannel, channels);
                }
                else{
                    System.out.println("There is no such channel. Try again only 1 - 100");
                }
            }
            else if (user.toLowerCase().equals("stop")) {
                start = false;
                System.out.println("Good Bye!");
            }
            else{
                System.out.println("There is no such command");
            }
        }

    }
    public static void showName(int currentChannel, Channel[] channels) {
        System.out.println("Channel number: "+ channels[currentChannel].channelId);
        System.out.println("Channel name: " + channels[currentChannel].channelName);
    }
    private static boolean isDigit(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
