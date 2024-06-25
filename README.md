To limit the swap memory usage of Elasticsearch on your Linux server, you can adjust the JVM options and system settings. Here's a step-by-step guide to achieve this:

1. **Adjust Elasticsearch JVM Options:**

   Open the JVM options file:

   ```bash
   sudo nano /etc/elasticsearch/jvm.options
   ```

   Add or modify the following lines to limit the heap size and disable swapping:

   ```plaintext
   -Xms2g
   -Xmx2g
   -XX:+DisableExplicitGC
   ```

   This sets the minimum and maximum heap size to 2 GB.

2. **Set the `bootstrap.memory_lock` Option:**

   Open the Elasticsearch configuration file:

   ```bash
   sudo nano /etc/elasticsearch/elasticsearch.yml
   ```

   Add or modify the following line to lock the memory:

   ```yaml
   bootstrap.memory_lock: true
   ```

3. **Configure System Settings:**

   Ensure that the Elasticsearch user has permission to lock memory. Open the limits configuration file:

   ```bash
   sudo nano /etc/security/limits.conf
   ```

   Add the following lines:

   ```plaintext
   elasticsearch soft memlock unlimited
   elasticsearch hard memlock unlimited
   ```

   Save and close the file.

4. **Disable Swap Usage:**

   You can disable swap for Elasticsearch by setting the `vm.swappiness` parameter to a low value (e.g., 1):

   Open the sysctl configuration file:

   ```bash
   sudo nano /etc/sysctl.conf
   ```

   Add the following line:

   ```plaintext
   vm.swappiness = 1
   ```

   Apply the changes:

   ```bash
   sudo sysctl -p
   ```

5. **Restart Elasticsearch:**

   After making these changes, restart the Elasticsearch service:

   ```bash
   sudo systemctl restart elasticsearch
   ```

By following these steps, you should be able to limit Elasticsearch's use of swap memory to 2 GB and prevent excessive swapping, ensuring better performance.
