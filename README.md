## Steps

1. Make Server/bin your current directory
   ```bash
   cd /Server/bin
   ```
2. Run
   ```bash
   rmiregistry &
   ```
3. A port number will be printed. Assume Port=1234

4. Edit Server.java line 14:
   ```java
   Naming.rebind("rmi://localhost/1234/hello");
   ```
5. Save changes
6. Run
   ```
   ifconfig
   ```
7. Get wlp3s0 IP address. Assume it is 12.15.17.19

8. Edit Client.java line 8:
   ```java
   ClientInterface h = (ClientInterface) Naming.lookup("rmi://12.15.17.19/1234/hello");
   ```
9. Save changes
