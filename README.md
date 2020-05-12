# Port Scanner
## Daily Java Project for: 5/11/2020

### Description:
A simple script using Java's `Socket`'s to test which ports within a given range are open for a given IP Address.

### Daily Java Projects
I'm creating a small Java project each day to help me learn Java. These aren't rigorously tested, but instead exist just so I can get a better understanding of some portion of Java.

### Points of Interest

+ Much more easily able to read the Java documentation at docs.oracle.com. And can now quickly write code without running into preventable errors like not handling a specific exception.
+ I now better understand the `Socket` and `InetAddress` classes
+ I wonder what the correct procedure is for setting the access modifiers for getter and setter functions are. For example the `Socket` class barely has any setter functions compared to the number of getter functions.

### Using `PortScanner`
+ Example: Scanning localhost for ports 1000-1049, with a timeout of 100ms for each port:
```
public class Parent {

    public static void main(String args[]) {
        PortScanner scanner = new PortScanner("127.0.0.1", 1000, 1050, 100);

        scanner.scan();
    }
}
```

### Documentation


+ `PortScanner(String ipAddress, int minPort, int maxPort, int timeout)`
    + Creates a PortScanner with the given values
+ `public void scan()`
    + Scans the given ports on the given IP address
+ `public boolean canConnect(int port)`
    + Scans a single port on the given IP address
+ `public String getIpAddress()`
    + Returns the stored IP Address
+ `public int getMinPort()`
    + Returns the smallest port number to be checked
+ `public int getMaxPort()`
    + Returns one above the largest port number to be checked
+ `private void getTimeout()`
    + Returns the timeout value