import java.net.*;
import java.io.*;

public class PortScanner {
    
    private String ipAddress;
    private int minPort = 0;
    private int maxPort = Integer.MAX_VALUE;
    private int timeout;

    private InetAddress connection;

    PortScanner(String ipAddress, int minPort, int maxPort, int timeout) {
        this.setIpAddress(ipAddress);
        this.setMinPort(minPort);
        this.setMaxPort(maxPort);
        this.setTimeout(timeout);

    }

    public void scan() {
        for (int port = this.getMinPort(); port < this.getMaxPort(); port++) {
            System.out.println("IP Address..."+ this.getIpAddress());
            System.out.println("Port........."+port);
            System.out.println("Can connect.."+this.canConnect(port));
            System.out.println();
        }
    }

    public boolean canConnect(int port) {
        try {

            Socket socket = new Socket();
            socket.connect(
                new InetSocketAddress(this.getIpAddress(), port), 
                this.getTimeout()
            );
            // socket.setSoTimeout(this.getTimeout());
            return socket.isBound();

        } 

        catch (UnknownHostException e) { e.printStackTrace(); } 
        catch (IOException e)          { return false; }

        return false;
    }

    /*
     * setIpAddress
     *
     * Description: Setter function for this.ipAddress
     *
     * Arguments:
     *  String - ipAddress - contains an IPv4 IP address
     *
     * Returns:
     *  N/A
     */
    private void setIpAddress(String ipAddress) { this.ipAddress = ipAddress; }

    /*
     * getIpAddress()
     *
     * Description: Getter function for this.ipAddress
     *
     * Arguments:
     *  N/A
     *
     * Returns:
     *  String - string representation of an IPv4 IP address
     */
    public String getIpAddress() { return this.ipAddress; }

    /*
     * setMinPort()
     *
     * Description: Setter function for this.minPort
     *
     * Arguments:
     *  int - minPort - a positive number below the current value of 
     *      this.maxPort, is the lowest port number to be scanned
     *
     * Returns:
     *  N/A
     */
    private void setMinPort(int minPort) {
        if (minPort < this.getMaxPort() && minPort > 0) {
            this.minPort = minPort;
        }
    }

    /*
     * getMinPort()
     *
     * Description: Getter function for this.minPort
     *
     * Arguments:
     *  N/A
     *
     * Returns:
     *  int - lowest port number to be scanned
     */
    public int getMinPort() { return this.minPort; }

    /*
     * setMaxPort()
     *
     * Description: Getter function for this.maxPort
     *
     * Arguments:
     *  int - maxPort - a positive number above the current value of 
     *      this.minPort, is the lowest port number to be scanned
     *
     * Returns:
     *  N/A
     */
    private void setMaxPort(int maxPort) {
        if (maxPort > this.getMinPort() && maxPort > 0) {
            this.maxPort = maxPort;
        }
    }

    /*
     * getMaxPort()
     *
     * Description: Getter function for this.maxPort
     *
     * Arguments:
     *  N/A
     *
     * Returns:
     *  int - highest port number to be scanned
     */
    public int getMaxPort() { return this.maxPort; }

    /*
     * setTimeout()
     *
     * Description: Setter function for this.timeout
     *
     * Arguments:
     *  int - timeout - a positive number in milliseconds for how long to wait
     *      before timing out on the current port
     *
     * Returns:
     *  N/A
     */
    private void setTimeout(int timeout) {
        if (timeout > 0) {
            this.timeout = timeout;
        }
    }

    /*
     * getTimeout()
     *
     * Description: Getter function for this.timeout
     *
     * Arguments:
     *  N/A
     *
     * Returns:
     *  int - a positive number in milliseconds for how long to wait
     *      before timing out on the current port
     */
    public int getTimeout() { return this.timeout; }
}