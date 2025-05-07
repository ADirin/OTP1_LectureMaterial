# Docker Setup
## Use XQuartz on Mac to run JavaFX GUI in docker
- Install XQuartz via brew $ brew install --cask xquartz 
- Logout and login of your Mac to activate XQuartz as default X11 server 
- Start XQuartz $ open -a XQuartz 
- Go to Security Settings and ensure that "Allow connections from network clients" is on
- Restart your Mac and start XQuartz again

```css
$ open -a XQuartz 

```

- Check if XQuartz is setup and running correctly $ ps aux | grep Xquartz 
- Ensure that XQuartz is running similar to this: /opt/X11/bin/Xquartz :0 -listen tcp :0 means the display is running on display port 0. Important is that its not saying –nolisten tcp which would block any X11 forwarding to the X11 display. 
- Allow X11 forwarding via xhost

 ```css
$ xhost +

  ```


