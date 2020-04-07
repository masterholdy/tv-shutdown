public class App {
    public static void main(String[] args) {
        String ip = "192.168.178.34";

        try {
            //wait till tv on
            while (!isReachable(ip)){
                Thread.sleep(600000); //10min
            }

            //wait till tv off
            while (isReachable(ip)){
                Thread.sleep(30000); //30 sec
            }

            shutdown();
        } catch (IOException | InterruptedException e) {}


    }

    private static boolean isReachable(String ip) throws IOException {
        InetAddress address = InetAddress.getByName(ip);
        return address.isReachable(10000);
    }

    public static void shutdown() throws IOException {
        Process p = Runtime.getRuntime().exec("shutdown -s -t 0");
    }

}
