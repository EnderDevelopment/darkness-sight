# Darkness Sight Minecraft Plugin

Darkness Sight is a Minecraft plugin that automatically grants players night vision when the light level at their location is 7 or lower, making it a lightweight dark-place vision plugin for Paper servers.

## Install

1. Ensure your server runs Paper 1.21.11 or a compatible 1.21 server.
2. Ensure the server uses Java 21 or newer.
3. Build the plugin with Maven:

   ```text
   mvn package
   ```

4. Copy the generated `target/plugin.jar` file into your server's `plugins` folder.
5. Start or restart the server.
6. Confirm that the plugin has loaded successfully in the server console.

## Use

1. Join the server.
2. Enter an area where the light level at your location is 7 or lower.
3. Darkness Sight automatically applies Night Vision.
4. Leave the dark area and the plugin removes the Night Vision effect that it applied.
5. No commands or configuration are required.

The plugin checks online players once per second. Night Vision is refreshed while a player remains in darkness so the effect continues without interruption.

---

More Minecraft plugin projects by EnderDevelopment: https://github.com/EnderDevelopment

Project page: https://dash.enderdevelopment.com/community/4bdbbb3f-3ef1-4e0d-af16-4809a8421dab?utm_source=github&utm_medium=readme&utm_campaign=auto_publish&utm_content=4bdbbb3f-3ef1-4e0d-af16-4809a8421dab
