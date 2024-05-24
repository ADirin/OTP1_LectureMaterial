# How to Add a Virtual Machine

To add a virtual machine (VM), you typically need virtualization software installed on your computer such as VirtualBox, VMware, or Hyper-V. Here's a general guide on how to add a virtual machine using VirtualBox:

## Install VirtualBox
If you haven't already, download and install VirtualBox from the official website, such as [Oracle VM VirtualBox](https://www.virtualbox.org/).

## Open VirtualBox
Launch the VirtualBox application on your computer.

## Create a New Virtual Machine
1. Download the Ubuntu ISO from [Ubuntu Download](https://ubuntu.com/download).
2. Open VirtualBox and click on `New` to create a new virtual machine.
3. Follow the wizard to set up the new virtual machine:
   - Provide a name for your VM.
   - Choose the type and version of the operating system you'll be installing on the VM.
   
## Allocate Memory (RAM)
Choose the amount of RAM to allocate to the virtual machine. Ensure that you allocate enough memory for the operating system and any applications you plan to run.

## Create a Virtual Hard Disk
1. Select "Create a virtual hard disk now" and click "Create".
2. Choose the hard disk file type (the default, VDI, is usually fine).
3. Choose whether the disk should be dynamically allocated (grows as needed) or fixed size (pre-allocated).
4. Allocate the desired amount of disk space.

## Configure Virtual Machine Settings
1. Configure additional settings for your VM as needed (e.g., network, storage, etc.).

## Install Operating System
1. Start the VM by selecting it from the VirtualBox Manager and clicking "Start".
2. Follow the prompts to install the operating system from the ISO file.

## Install Virtual Machine Additions/Tools
1. Install necessary tools and additions, such as Docker.
   - Follow the guide to [install and configure Docker](https://devopscube.com/how-to-install-and-configure-docker/).

## How to Run a Docker Image from Docker Hub in a Linux Environment
1. Run the terminal in Linux.
2. Connect to Docker Hub in the browser.
3. Docker login if needed.
4. In terminal:
   ```sh
   docker pull yourRepo/imagename
