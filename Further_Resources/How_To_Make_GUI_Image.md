# Create a Docker image for a JavaFX application

Made by: [Mahnoor Fatima](https://github.com/MahnoorFatima02), [Ricardo de Sousa](https://github.com/IsNotRicardo) and [Saku Heinonen](https://github.com/SakuJuuH)

## Introduction

This guide will show you how to create a Docker image for a JavaFX application. It will not, however,
show you how to create a JavaFX application. The following steps assume that you have a working JavaFX
application that you want to containerise.

## X Server Setup

In order to run a JavaFX application in a Docker container, you need to have an [X.org Server](https://en.wikipedia.org/wiki/X.Org_Server)
installed and running on your machine. This will allow the JavaFX application to display its GUI on your device. The
process to set one up is different for each operating system, so make sure to follow the correct guide for your OS.

### Windows

Follow the steps in the [Windows X server guide](windows-x-server.md).

### macOS

Follow the steps in the [macOS X server guide](macos-x-server.md).

### Unix/Linux

Follow the steps in the [Unix/Linux X server guide](unix-linux-x-server.md).

## Building and Running

> [!IMPORTANT]
> Make sure that you have followed all the previous steps for your OS before running the Docker image.
> 
> Additionally, make sure that Docker Desktop or any Docker Engine is running on your machine.

1. Make sure that the Docker image exists in your local repository. You can do this by running the
   following command in any terminal:

   ```bash
   docker images
   ```

   You should see the name of your image listed in the output. If it is not there, you will need to either pull it
   from a remote repository or build it yourself from a Dockerfile.
   
   If the image is located in a **remote repository**, pull it by running the following command in any terminal:

   ```bash
   docker pull <docker-username>/<image-name>:<tag>
   ```
   
   Otherwise, build the Docker image by running the following command:

   ```bash
   docker build -t <image-name>:<tag> <path-to-dockerfile>
   ```

   If you are using the terminal from Intellij IDEA or another IDE, the path to the Dockerfile will be the
   same as the project root directory, which will be a `.`. If you are using a separate terminal, you will need
   to provide the full path to the Dockerfile or navigate to the directory where it is located.

> [!NOTE]
> The tag is optional when building, although it is recommended to keep track of the image versions.

2. Run the Docker image by executing the following command:

   ```bash
   docker run -e DISPLAY=host.docker.internal:0.0 <image-name>:<tag>
   ```
   
   Replace `<image-name>` and `<tag>` with the same values you used when building the Docker image or pulling it.

> [!NOTE]
> The `-e DISPLAY=host.docker.internal:0.0` flag is used to set the display environment variable for the container.
> `host.docker.internal` is a special DNS name that resolves to the internal IP address used by the host and
> `0.0` represent the display and screen numbers.

> [!TIP]
> You can include the environment variable in the Dockerfile to avoid having to set it every time you run the image,
> by adding the following line:
> 
> ```Dockerfile
> ENV DISPLAY=host.docker.internal:0.0
> ```
> 
> After this, you will need to build the image again, and then you can run the `docker run` command without the
> `-e DISPLAY=host.docker.internal:0.0` flag.
> 
> Note that if you have the same environment variable set in the Dockerfile and in the `docker run` command,
> the value in the `docker run` command will take precedence.

If everything is set up correctly, you should see the JavaFX application running on your screen.

If you are interested in learning about persisting data in Docker containers, you can check out the
guide on how to [Persist data in Docker containers](docker-data-persistence.md).
